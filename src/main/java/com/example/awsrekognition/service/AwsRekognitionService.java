package com.example.awsrekognition.service;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.*;
import com.example.awsrekognition.ampq.event.ImagemAdicionadaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AwsRekognitionService {

    @Autowired
    private AmazonRekognition client;

    @Value("${aws.s3.bucket}")
    private String bucket;

    public DetectModerationLabelsResult detectModerationLabels(ImagemAdicionadaEvent image) {

        DetectModerationLabelsRequest request = new DetectModerationLabelsRequest()
                .withImage(new Image().withS3Object(new S3Object()
                .withName(image.getKeyFile())
                .withBucket(bucket)))
                .withMinConfidence(95F);

        return client.detectModerationLabels(request);
    }

}
