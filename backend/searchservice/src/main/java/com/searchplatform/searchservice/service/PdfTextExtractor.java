package com.searchplatform.searchservice.service;

import com.searchplatform.searchservice.DTO.FileTextExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PdfTextExtractor implements FileTextExtractor {

    @Override
    public String extractText(MultipartFile file) throws Exception {

        PDDocument document= PDDocument.load(file.getInputStream());
        PDFTextStripper stripper=new PDFTextStripper();
        String text=stripper.getText(document);
        document.close();
        return text;
    }

    @Override
    public boolean supports(String contentType) {
        return "application/pdf".equals(contentType);
    }



}
