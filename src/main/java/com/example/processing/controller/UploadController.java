package com.example.processing.controller;

import com.example.processing.model.ProcessedFile;
import com.example.processing.model.RawFile;
import com.example.processing.service.FileProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api")
public class UploadController {
    private FileProcessingService process ;

    public UploadController(FileProcessingService process) {
        this.process = process;
    }

    @PostMapping("/upload")
    public ResponseEntity<ProcessedFile> upload(@RequestPart("file") MultipartFile file) throws NoSuchAlgorithmException, IOException {
        if (file.isEmpty()){
            System.out.println("bad request");
        }
        RawFile rawFile = new RawFile();
        rawFile.setFilename(file.getOriginalFilename());
        rawFile.setContent(new String(file.getBytes(), StandardCharsets.UTF_8));
        ProcessedFile processedFile = process.process(rawFile);

        return ResponseEntity.ok(processedFile);
    }

}
