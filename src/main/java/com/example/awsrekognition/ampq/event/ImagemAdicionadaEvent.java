package com.example.awsrekognition.ampq.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImagemAdicionadaEvent {
    private String id;

    private String imageKey;
}
