package com.liurui.util.common.office;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.xslf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @ClassName
 * @Description ppt转图片
 * @Author liurui
 * @Date 2019/1/3 9:46 AM
 **/
public class PPTUtils {

    //Suppress default constructor for noninstantiability
    private PPTUtils() {
        throw new AssertionError();
    }

    private static final String[] IMG_TYPE_LIST = {"jpeg", "png"};
    private static final String pptPath = "/Users/liurui/Downloads/共享空间/1Course.ppt";
    private static final String imgPath = "/Users/liurui/Downloads/共享空间/test";

    public static void main(String[] args) {
        File pptFile = new File(pptPath);
        File imgFile = new File(imgPath);
        try {
            pptToImage(pptFile, imgFile, "png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ppt2003(后缀为.ppt)转图片
     * @param pptFile
     * @param imgFile
     */
    public static void pptToImage(File pptFile, File imgFile) throws Exception {
        pptToImage(pptFile, imgFile, "JPEG");
    }

    /**
     * ppt2003(后缀为.ppt)转图片
     * @param pptFile
     * @param imgFile
     * @param imgType
     */
    public static void pptToImage(File pptFile, File imgFile, String imgType) throws Exception {
        if (StringUtils.isBlank(imgType)) {
            imgType = IMG_TYPE_LIST[0];
        } else if (!checkType(imgType)) {
            imgType = IMG_TYPE_LIST[0];
        }
        if (!pptFile.getName().endsWith(".ppt")) {
            throw new Exception("文件类型错误");
        }
        doPPT2003ToImage(pptFile, imgFile, imgType);
    }

    /**
     * ppt2007(后缀为.pptx)转图片
     * @param pptFile
     * @param imgFile
     */
    public static void pptxToImage(File pptFile, File imgFile) throws Exception {
        pptToImage(pptFile, imgFile, "JPEG");
    }

    /**
     * ppt2007(后缀为.pptx)转图片
     * @param pptFile
     * @param imgFile
     * @param imgType
     */
    public static void pptxToImage(File pptFile, File imgFile, String imgType) throws Exception {
        if (StringUtils.isBlank(imgType)) {
            imgType = IMG_TYPE_LIST[0];
        } else if (!checkType(imgType)) {
            imgType = IMG_TYPE_LIST[0];
        }
        if (!pptFile.getName().endsWith(".pptx")) {
            throw new Exception("文件类型错误");
        }
        doPPT2007ToImage(pptFile, imgFile, imgType);
    }

    /**
     * 设置PPT字体
     * @param slides
     */
    private static void setFont(List<HSLFSlide> slides) {
        for (HSLFSlide slide : slides) {
            for (HSLFShape shape : slide.getShapes()) {
                if (shape instanceof HSLFTextShape) {
                    HSLFTextShape sh = (HSLFTextShape) shape;
                    List<HSLFTextParagraph> textParagraphs = sh.getTextParagraphs();
                    for (HSLFTextParagraph xslfTextParagraph : textParagraphs) {
                        List<HSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
                        for (HSLFTextRun xslfTextRun : textRuns) {
                            xslfTextRun.setFontFamily("宋体");
                        }
                    }
                }
            }
        }
    }

    /**
     * 设置PPT字体
     * @param slides
     */
    private static void setXFont(List<XSLFSlide> slides) {
        for (XSLFSlide slide : slides) {
            for (XSLFShape shape : slide.getShapes()) {
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape sh = (XSLFTextShape) shape;
                    for (XSLFTextParagraph xslfTextParagraph : sh.getTextParagraphs()) {
                        for (XSLFTextRun xslfTextRun : xslfTextParagraph.getTextRuns()) {
                            xslfTextRun.setFontFamily("宋体");
                        }
                    }
                }
            }
        }
    }

    /**
     * 判断图片类型是否符合要求
     * @param imgType
     * @return
     */
    private static boolean checkType(String imgType) {
        for (int i = 0; i < IMG_TYPE_LIST.length; i++) {
            if (IMG_TYPE_LIST[i].equals(imgType.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * ppt(2003)转图片
     * @param pptFile
     * @param imgFile
     * @param imgType
     */
    private static void doPPT2003ToImage(File pptFile, File imgFile, String imgType) throws Exception {
        FileInputStream is = null;
        FileOutputStream out = null;
        try {
            is = new FileInputStream(pptFile);
            HSLFSlideShow ppt = new HSLFSlideShow(is);
            //及时关闭输入流
            is.close();

            Dimension pgsize = ppt.getPageSize();
            List<HSLFSlide> slide = ppt.getSlides();
            for (int i = 0; i < slide.size(); i++) {
                //解决乱码
                setFont(slide);

                //根据幻灯片大小生成图片
                BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
                slide.get(i).draw(graphics);

                //图片保存位置
                String absolutePath = imgFile.getAbsolutePath() + File.separator + (i + 1) + "." + imgType;
                File jpegFile = new File(absolutePath);

                //如果图片存在，不生成
                if (jpegFile.exists()) {
                    continue;
                }

                //这里设置图片的存放路径和图片的格式(jpeg,png,bmp等)，注意生成文件路径
                out = new FileOutputStream(jpegFile);
                ImageIO.write(img, imgType, out);
                System.out.println("转换成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("转换失败");
        } finally {
            if (null != is) {
                is.close();
            }
            if (null != out) {
                out.close();
            }
        }
    }

    /**
     * ppt(2007)转图片
     * @param pptFile
     * @param imgFile
     * @param imgType
     */
    private static void doPPT2007ToImage(File pptFile, File imgFile, String imgType) throws Exception {
        FileInputStream is = null;
        FileOutputStream out = null;
        try {
            is = new FileInputStream(pptFile);
            XMLSlideShow xmlSlideShow = new XMLSlideShow(is);
            is.close();
            //获取大小
            Dimension pgsize = xmlSlideShow.getPageSize();
            //获取幻灯片
            List<XSLFSlide> slides = xmlSlideShow.getSlides();
            for (int i = 0; i < slides.size(); i++) {
                //解决乱码
                setXFont(slides);

                //根据幻灯片大小生成图片
                BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
                //最核心代码
                slides.get(i).draw(graphics);
                //图片存放路径
                String absolutePath = imgFile.getAbsolutePath() + File.separator + (i + 1) + "." + imgType;
                File imageFile = new File(absolutePath);
                if (imageFile.exists()) {
                    continue;
                }
                out = new FileOutputStream(imageFile);
                ImageIO.write(img, imgType, out);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("转换失败");
        } finally {
            if (null != is) {
                is.close();
            }
            if (null != out) {
                out.close();
            }
        }
    }

}
