package com.javastart.filerest.service;

import com.javastart.filerest.dto.FileRequest;
import com.javastart.filerest.dto.FileResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    public FileResponse saveAndRename(FileRequest fileRequest) throws IOException {
        Path path = Paths.get("/" + fileRequest.getFileName());
        fileRequest.getFile().transferTo(path);

        FileResponse fileResponse = new FileResponse();
        fileResponse.setFileName(fileRequest.getFileName());
        fileResponse.setPath(path.toAbsolutePath().toString());
        fileResponse.setFileSize(fileRequest.getFile().getSize());
        return fileResponse;
    }
}
