package com.example.awsrekognition.service;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.*;
import com.example.awsrekognition.model.Imagem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AwsRekognitionService {

    private AmazonRekognition client;

    @Value("${aws.s3.bucket}")
    private String bucket;

    public AwsRekognitionService(AmazonRekognition client) {
        this.client = client;
    }

    public DetectModerationLabelsResult detectModerationLabels(Imagem image) {

        DetectModerationLabelsRequest request = new DetectModerationLabelsRequest()
                .withImage(new Image().withS3Object(new S3Object()
                .withName(image.getKeyFile())
                .withBucket(bucket)))
                .withMinConfidence(95F);

        return client.detectModerationLabels(request);
    }

}
