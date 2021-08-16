package com.example.awsrekognition.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static com.example.awsrekognition.configuration.AMQPConstants.*;


@Configuration
public class QueueConfiguration {

    private static final String EXCHANGE_NAME = "IMAGENS_EXCHANGE";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue imageQ() {
        return new Queue(PROCESSAR_IMAGENS_QUEUE, true, false, false);
    }

    @Bean
    public Binding image(DirectExchange exchange) {
        return BindingBuilder.bind(imageQ())
                .to(exchange)
                .with(PROCESSAR_IMAGENS_QUEUE);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        ObjectMapper mapper = Jackson2ObjectMapperBuilder
                .json()
                .modules(new JavaTimeModule())
                .dateFormat(new StdDateFormat())
                .build();

        return new Jackson2JsonMessageConverter(mapper);
    }
}

