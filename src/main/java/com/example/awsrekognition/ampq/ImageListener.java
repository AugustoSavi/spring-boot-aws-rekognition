package com.example.awsrekognition.ampq;

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
            System.out.println(service.detectModerationLabels(imagem));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
