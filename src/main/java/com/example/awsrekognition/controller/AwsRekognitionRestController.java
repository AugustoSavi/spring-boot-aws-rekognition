package com.example.awsrekognition.controller;

import com.example.awsrekognition.model.Imagem;
import com.example.awsrekognition.service.AwsRekognitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class AwsRekognitionRestController {

    private AwsRekognitionService awsRekognitionService;

    public AwsRekognitionRestController(AwsRekognitionService awsRekognitionService) {
        this.awsRekognitionService = awsRekognitionService;
    }

    @PostMapping("/images/moderation")
    public Object detectModerationLabels(@Valid @RequestBody Imagem image) {
        return ResponseEntity.ok(awsRekognitionService.detectModerationLabels(image));
    }

}
