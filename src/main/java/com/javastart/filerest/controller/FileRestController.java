package com.javastart.filerest.controller;

import com.javastart.filerest.dto.FileRequest;
import com.javastart.filerest.dto.FileResponse;
import com.javastart.filerest.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileRestController {

    Logger logger = LoggerFactory.getLogger(FileRestController.class);

    private final FileService fileService;


    @Autowired
    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileResponse> renameFile(@ModelAttribute FileRequest fileRequest) throws IOException {

        return ResponseEntity.ok(fileService.saveAndRename(fileRequest));
    }
}
