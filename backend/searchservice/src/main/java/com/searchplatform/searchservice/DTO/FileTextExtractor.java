package com.searchplatform.searchservice.DTO;

import org.springframework.web.multipart.MultipartFile;

public interface FileTextExtractor {
    String extractText(MultipartFile file) throws Exception;

    boolean supports(String contentType);

}
