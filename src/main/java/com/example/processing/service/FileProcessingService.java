package com.example.processing.service;

import com.example.processing.model.ProcessedFile;
import com.example.processing.model.RawFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class FileProcessingService {
     private  final ContentNormalizationService normalized ;
     private  final DuplicateDetectionService duplicate ;
     private final FilePersistenceService persistence;

     public ProcessedFile process(RawFile file) throws NoSuchAlgorithmException {
         ProcessedFile processedFile = normalized.normalize(file);
         processedFile = duplicate.virefy(processedFile);

         processedFile = persistence.save(processedFile);

         return  processedFile;
     }


    public FileProcessingService(ContentNormalizationService normalized, DuplicateDetectionService duplicate, FilePersistenceService persistence) {
        this.normalized = normalized;
        this.duplicate = duplicate;
        this.persistence = persistence;
    }
}
