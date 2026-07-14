package com.example.processing.service;

import com.example.processing.model.ProcessedFile;
import com.example.processing.repo.FileRepo;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.Set;


@Service
public class DuplicateDetectionService {

    private FileRepo repo ;




    public ProcessedFile vifrefy(ProcessedFile file) throws NoSuchAlgorithmException {
        String hash = hashe(file.getNormalizedContent());
        if (repo.existsBySha256(hash)){
            throw new RuntimeException("Duplicate file");
        }
        file.setSha256(hash);
        repo.save(file);
        return file;
    }


    public  String hashe(String content) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] sha = md.digest(content.getBytes());
        return HexFormat.of().formatHex(sha);
    }



}
