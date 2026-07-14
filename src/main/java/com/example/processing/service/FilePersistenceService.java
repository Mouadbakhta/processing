package com.example.processing.service;

import com.example.processing.model.ProcessedFile;
import com.example.processing.repo.FileRepo;
import org.springframework.stereotype.Service;


@Service
public class FilePersistenceService {
    private FileRepo repo ;
    public ProcessedFile save(ProcessedFile file){
        return repo.save(file);
    }
}
