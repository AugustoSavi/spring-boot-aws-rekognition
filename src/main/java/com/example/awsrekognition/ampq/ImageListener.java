package com.example.awsrekognition.ampq;

import com.amazonaws.services.rekognition.model.DetectModerationLabelsResult;
import com.example.awsrekognition.ampq.event.ImagemAdicionadaEvent;
import com.example.awsrekognition.service.AwsRekognitionService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageListener {
    @Autowired
    AwsRekognitionService service;

    @RabbitListener(queues = "proc_img_q")
    public void onListener(ImagemAdicionadaEvent imagem) {
        try {
            DetectModerationLabelsResult detectModerationLabelsResult = service.detectModerationLabels(imagem);
            System.out.println(imagem.imprimir(detectModerationLabelsResult));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
