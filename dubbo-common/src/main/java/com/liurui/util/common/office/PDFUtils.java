//package com.liurui.util.common.office;
//
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName PDFUtils
// * @Description TODO
// * @Author liurui
// * @Date 2019/1/15 11:39 AM
// **/
//public class PDFUtils {
//
//    private static final float dpi = 80f;
//
//    public static void main(String[] args) {
//        List<String> list = pdf2Image(new File("/Users/liurui/Downloads/test/aliyun/train_courseware/Java_manual.pdf"),
//                "/Users/liurui/Downloads/test/preview/CwTeshASAwgb");
//    }
//
//    public static List<String> pdf2Image(File target, String previewPath) {
//        if (!target.exists()) {
//            return null;
//        }
//        File preFile = new File(previewPath);
//        if (!preFile.exists()) {
//            preFile.mkdirs();
//        }
//        List<String> list = new ArrayList<>();
//        PDDocument pdDocument;
//        try {
//            String imgPDFPath = target.getParent();
//            int dot = target.getName().lastIndexOf('.');
//            String imagePDFName = target.getName().substring(0, dot); // 获取图片文件名
//            String imgFolderPath = previewPath;
//
//            pdDocument = PDDocument.load(target);
//            PDFRenderer renderer = new PDFRenderer(pdDocument);
//            /* dpi越大转换后越清晰，相对转换速度越慢 */
//            StringBuffer imgFilePath = null;
//            String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
//            for (int i=0; i<pdDocument.getPages().getCount(); i++) {
//                imgFilePath = new StringBuffer();
//                imgFilePath.append(imgFilePathPrefix).append(i).append(".png");
//                File dstFile = new File(imgFilePath.toString());
//                BufferedImage image = renderer.renderImageWithDPI(i, dpi);
//                ImageIO.write(image, "png", dstFile);
//                String rootPath = PathKit.getRootClassPath();
//                String webINFPath = rootPath.substring(0, rootPath.lastIndexOf(File.separator));
//                String filePath = webINFPath.substring(0, webINFPath.lastIndexOf(File.separator));
//                list.add(imgFilePath.toString().replace(filePath, ""));
//            }
//            return list;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//}
