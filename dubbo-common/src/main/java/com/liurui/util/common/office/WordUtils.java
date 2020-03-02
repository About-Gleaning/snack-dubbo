//package com.liurui.util.common.office;
//
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.converter.PicturesManager;
//import org.apache.poi.hwpf.converter.WordToHtmlConverter;
//import org.apache.poi.hwpf.usermodel.PictureType;
//import org.apache.poi.xwpf.converter.core.BasicURIResolver;
//import org.apache.poi.xwpf.converter.core.FileImageExtractor;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStreamWriter;
//
///**
// * @ClassName WordUtils
// * @Description TODO
// * @Author liurui
// * @Date 2019/1/15 11:42 AM
// **/
//public class WordUtils {
//
//    /**
//     * WORD转html
//     * @param target
//     * @param absoluPath
//     * @return
//     */
//    public static String convertDoc2HTML(File target, String absoluPath) {
//        if (!target.exists()) {
//            return null;
//        }
//        String result = null;
//        try {
//            if (target.getName().endsWith(".doc")) {
//                result = docToHtml(target, absoluPath);
//            } else if (target.getName().endsWith(".docx")) {
//                result = docxToHtml(target, absoluPath);
//            }
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private static String docToHtml(File target, String absoluPath) throws Exception {
//        final String imagePathStr = absoluPath + File.separator + "image" + File.separator;
//        String targetFileName = absoluPath + File.separator + File.separator + target.getName().substring(target.getName().lastIndexOf(".")) + ".html";
//        File file = new File(imagePathStr);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(target));
//        org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
//        //保存图片，并返回图片的相对路径
//        PicturesManager picturesManager = new PicturesManager() {
//            @Override
//            public String savePicture(byte[] bytes, PictureType pictureType, String s, float v, float v1) {
//                try (FileOutputStream out = new FileOutputStream(imagePathStr + s)) {
//                    out.write(bytes);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return imagePathStr.replace(PathKit.DEFAULT_COURSEWARE_PREVIEW_PATH, "/test/preview/") + s;
//            }
//        };
//        wordToHtmlConverter.setPicturesManager(picturesManager);
//        wordToHtmlConverter.processDocument(wordDocument);
//        org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
//        DOMSource domSource = new DOMSource(htmlDocument);
//        StreamResult streamResult = new StreamResult(new File(targetFileName));
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer serializer = tf.newTransformer();
//        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//        serializer.setOutputProperty(OutputKeys.METHOD, "html");
//        serializer.transform(domSource, streamResult);
//        return targetFileName;
//    }
//
//    /**
//     * DOCX转html
//     * @param absoluPath
//     * @return
//     * @throws Exception
//     */
//    private static String docxToHtml(File target, String absoluPath) throws Exception {
//        String imagePath = absoluPath + File.separator + "image";
//        String targetFileName = absoluPath + File.separator + target.getName().substring(0, target.getName().lastIndexOf(".")) + ".html";
//        File targetFile = new File(absoluPath);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
//
//        OutputStreamWriter outputStreamWriter = null;
//        try {
//            XWPFDocument document = new XWPFDocument(new FileInputStream(target));
//            XHTMLOptions options = XHTMLOptions.create();
//            // 存放图片的文件夹
//            options.setExtractor(new FileImageExtractor(new File(imagePath)));
//            // html中图片的路径
//            options.URIResolver(new BasicURIResolver("image"));
//            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");
//            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
//            xhtmlConverter.convert(document, outputStreamWriter, options);
//        } finally {
//            if (outputStreamWriter != null) {
//                outputStreamWriter.close();
//            }
//        }
//        return targetFileName;
//    }
//
//}
