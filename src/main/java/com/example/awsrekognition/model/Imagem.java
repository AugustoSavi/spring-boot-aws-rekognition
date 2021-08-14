package com.example.awsrekognition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Imagem {

    private final String id;
    private final String bucketName;
    private final String url;
    private final String keyFile;
    private final String status;

}
