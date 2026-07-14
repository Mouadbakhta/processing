package com.example.processing.service;

import com.example.processing.model.ProcessedFile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.Set;

public class DuplicateDetectionService {

    private final Set<String> hashes = new HashSet<>();




    public ProcessedFile vifrefy(ProcessedFile file) throws NoSuchAlgorithmException {
        String hash = hashe(file.getNormalizedContent());
        if (hashes.contains(hash)){
            throw new RuntimeException("Duplicate file");
        }
        hashes.add(hash);
        file.setSha256(hash);
        return file;
    }


    public  String hashe(String content) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] sha = md.digest(content.getBytes());
        return HexFormat.of().formatHex(sha);
    }



}
