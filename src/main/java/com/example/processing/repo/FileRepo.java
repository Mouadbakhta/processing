package com.example.processing.repo;

import com.example.processing.model.ProcessedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<ProcessedFile,Long> {
    boolean existsBySha256(String sha256);
}
