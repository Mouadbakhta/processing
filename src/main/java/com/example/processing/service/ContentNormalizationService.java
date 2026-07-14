package com.example.processing.service;

import com.example.processing.model.ProcessedFile;
import com.example.processing.model.RawFile;

public class ContentNormalizationService {
    public   ProcessedFile normalize(RawFile rawFile){

        String normalized = rawFile.getContent();

        normalized = normalized
                .replace("\r\n" , "\n")
                .replace("\r","\n");

        normalized = normalized
                .replace("\u0000", "")
                .replace("\u0001", "")
                .replace("\u0003", "");

        normalized = normalized.trim();

        return new ProcessedFile(rawFile.getFilename(),normalized , "");
    }

}
