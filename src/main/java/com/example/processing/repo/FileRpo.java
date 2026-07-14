package com.example.processing.repo;

import com.example.processing.model.ProcessedFile;
import org.springframework.data.jpa.repository.JpaRepository;

interface FileRpo extends JpaRepository<ProcessedFile,Long> {
    boolean existsBySha256(String sha256);
}
