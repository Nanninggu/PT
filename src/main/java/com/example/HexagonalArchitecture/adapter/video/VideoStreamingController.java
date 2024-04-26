package com.example.HexagonalArchitecture.adapter.video;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/video")
public class VideoStreamingController {

    @GetMapping
    public ResponseEntity<InputStreamResource> streamVideo() throws IOException {
        File videoFile = new File("C:\\Users\\김승현\\Documents\\oCam\\기술 동영상\\CloudFront와 S3 연동.mp4");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(videoFile));

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("video/mp4"))
                .body(resource);

    }
}
