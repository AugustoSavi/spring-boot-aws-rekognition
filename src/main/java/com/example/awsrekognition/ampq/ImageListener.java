package com.example.awsrekognition.ampq;

import com.example.awsrekognition.ampq.event.ImagemAdicionadaEvent;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ImageListener {
    @RabbitListener(queues = "proc_img_q")
    public void onListener(ImagemAdicionadaEvent message) {
        try {
            //atorCriadoService.executar(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
