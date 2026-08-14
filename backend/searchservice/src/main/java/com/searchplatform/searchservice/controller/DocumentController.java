//package com.searchplatform.searchservice.controller;
//
//import com.searchplatform.searchservice.service.DocumentService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/api/docs")
//public class DocumentController {
//
//    DocumentService documentService;
//    DocumentController(DocumentService documentService) {
//        this.documentService=documentService;
//    }
//
//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam MultipartFile file) {
//        return documentService.uploadFile(file);
//    }
//
//
//
//}
