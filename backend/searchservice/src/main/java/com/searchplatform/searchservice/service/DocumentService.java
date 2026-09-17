package com.searchplatform.searchservice.service;

import com.searchplatform.searchservice.entity.Document;
import com.searchplatform.searchservice.repository.DocumentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository=documentRepository;
    }

    public static final Set<String> ALLOWED_CONTENT_TYPES=Set.of("application/pdf","application/vnd.openxmlformats-officedocument.wordprocessingml.document","text/plain");
    public void validateDocument(MultipartFile file) {

        System.out.println("Hello World10");
        if(file==null || file.isEmpty()) {
            System.out.println("Hello World1");
            throw new IllegalArgumentException("File is empty");
        }
        System.out.println("Hello World20");
        if(file.getSize()>19*1024*1024) {
            System.out.println("Hello World2");
            throw new IllegalArgumentException("File size cannot exceed 10 MB");
        }

        System.out.println("Hello World30");
        if(!ALLOWED_CONTENT_TYPES.contains(file.getContentType())) {
            System.out.println("Hello World3");
            throw new IllegalArgumentException("Only PDF, DOCX, AND TXT files are allowed");
        }

        createDocument(file);
    }

    public void createDocument(MultipartFile file) {
        System.out.println("Hello World4");

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();


        System.out.println("Hello World5");
        Document document=new Document();
        System.out.println(file.getOriginalFilename());
        document.setTitle(file.getOriginalFilename());
        document.setFileType(file.getContentType());
        document.setOwnerId(authentication.getName());
        documentRepository.save(document);


    }


}
