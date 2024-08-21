package com.example.exam.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // The file to be downloaded.
        Path file = new ClassPathResource("report/sample.pdf").getFile().toPath();

        // Get the media type of the file
        String contentType = Files.probeContentType(file);
        if (contentType == null) {
            // Use the default media type
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        response.setContentType(contentType);
        // File Size
        response.setContentLengthLong(Files.size(file));
        /**
         * Building the Content-Disposition header with the ContentDisposition utility class can avoid the problem of garbled downloaded file names.
         */
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                .filename(file.getFileName().toString(), StandardCharsets.UTF_8)
                .build()
                .toString());
        // Response data to the client
        Files.copy(file, response.getOutputStream());
    }
}
