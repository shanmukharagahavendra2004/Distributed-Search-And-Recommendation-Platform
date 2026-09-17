package com.searchplatform.searchservice.repository;

import com.searchplatform.searchservice.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {





}
