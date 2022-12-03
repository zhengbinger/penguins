package com.penguins.controller;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/12/1 09:02
 **/
@RestController
public class PdfSplitController {

    private static final String SOURCE_PATH = "/Users/zhengbing/Desktop/test.pdf";
    private static final String TARGET_PATH = "/Users/zhengbing/Desktop/test_t.pdf";

    @GetMapping("pdf/{fromPage}/{toPage}")
    public void main(HttpServletResponse response, @PathVariable("fromPage") int fromPage, @PathVariable("toPage") int toPage) throws IOException, DocumentException {
        InputStream in = Files.newInputStream(Paths.get(SOURCE_PATH));
        PdfReader pdfReader = new PdfReader(in);
        response.setHeader("content-disposition",
                "attachment;fileName=" + new String("pdf.pdf".getBytes("gb2312"), StandardCharsets.ISO_8859_1));

        OutputStream os = response.getOutputStream();
        Document dd = new Document(pdfReader.getPageSize(pdfReader.getNumberOfPages()));
        PdfWriter writer = PdfWriter.getInstance(dd, os);
        dd.open();
        PdfContentByte cb = writer.getDirectContent();
        PdfImportedPage page;
        while (fromPage <= toPage) {
            dd.newPage();
            page = writer.getImportedPage(pdfReader, fromPage);
            cb.addTemplate(page, AffineTransform.getRotateInstance(0));
            fromPage++;
        }
        os.flush();
        dd.close();
        writer.close();
    }

    public void selectPdfPage(String range) throws IOException, DocumentException {

        PdfReader pdfReader = new PdfReader(SOURCE_PATH);
        PdfStamper pdfStamper = new PdfStamper(pdfReader, Files.newOutputStream(Paths.get(TARGET_PATH)));
        pdfReader.selectPages(range);
        pdfStamper.close();
    }

    public void selectPdfPageInStream(String range) throws IOException, DocumentException {
        InputStream in = Files.newInputStream(Paths.get(SOURCE_PATH));
        PdfReader pdfReader = new PdfReader(in);
        PdfStamper pdfStamper = new PdfStamper(pdfReader, Files.newOutputStream(Paths.get(TARGET_PATH)));
        pdfReader.selectPages(range);
        pdfStamper.close();
    }

    public static OutputStream selectPdfPageInOutStream(String range) throws IOException, DocumentException {
        InputStream in = Files.newInputStream(Paths.get(SOURCE_PATH));
        PdfReader pdfReader = new PdfReader(in);
        PdfStamper pdfStamper = new PdfStamper(pdfReader, Files.newOutputStream(Paths.get(TARGET_PATH)));

        pdfReader.selectPages(range);
        OutputStream os = new FileOutputStream(String.valueOf(Paths.get(TARGET_PATH)));
        PdfWriter writer = PdfWriter.getInstance(new Document(pdfReader.getPageSize(pdfReader.getNumberOfPages())), os);
        pdfStamper.close();
        writer.close();
        return os;
    }
}
