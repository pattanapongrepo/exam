package com.example.exam.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {

        Resource resource = new ClassPathResource("report/sample.pdf");

        // Get the media type of the file
        String contentType = Files.probeContentType(resource.getFile().toPath());
        if (contentType == null) {
            // Use the default media type
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        response.setContentType(contentType);
        // File Size
        response.setContentLengthLong(Files.size(resource.getFile().toPath()));
        /**
         * Building the Content-Disposition header with the ContentDisposition utility class can avoid the problem of garbled downloaded file names.
         */
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                .filename(resource.getFile().toPath().getFileName().toString(), StandardCharsets.UTF_8)
                .build()
                .toString());
        // Response data to the client
        Files.copy(resource.getFile().toPath(), response.getOutputStream());
    }
}
