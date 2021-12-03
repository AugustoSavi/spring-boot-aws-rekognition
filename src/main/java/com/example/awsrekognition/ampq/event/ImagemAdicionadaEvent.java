package com.example.awsrekognition.ampq.event;

import com.amazonaws.services.rekognition.model.DetectModerationLabelsResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImagemAdicionadaEvent {
    private String id;

    private String bucketName;

    private String url;

    private String keyFile;

    private StatusProcessamento status;

    public String imprimir(DetectModerationLabelsResult detectModerationLabelsResult) {
        return "ImagemAdicionadaEvent{\n" +
                "id='" + id + '\'' +
                "\n, bucketName='" + bucketName + '\'' +
                "\n, url='" + url + '\'' +
                "\n, keyFile='" + keyFile + '\'' +
                "\n, status=" + status +
                "} \n" + detectModerationLabelsResult.toString();
    }
}
