package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@Slf4j
public class AuthController {

    @GetMapping("/")
    public String test() {
        log.info("testing");
        return "hello";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download() {
        log.info("file download");
        final File file = new File("/tmp/logs/app-logs.log");
        Resource resource = new FileSystemResource(file);

        // Fallback to the default content type if type could not be determined

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

    }


}
