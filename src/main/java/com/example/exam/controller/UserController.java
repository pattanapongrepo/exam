package com.example.exam.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    ResourceLoader resourceLoader;


    @GetMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {
        log.info("{}","sdadasda");
        Resource resource = resourceLoader.getResource("classpath:report/sample.pdf");
// Get your file stream from wherever.
        InputStream myStream = resource.getInputStream();
        // Set the content type and attachment header.
        response.addHeader("Content-disposition", "attachment;filename=sample.pdf");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

        // Copy the stream to the response's output stream.
        IOUtils.copy(myStream, response.getOutputStream());
        response.flushBuffer();
    }
}
