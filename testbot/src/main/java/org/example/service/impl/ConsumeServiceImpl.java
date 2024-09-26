package org.example.service.impl;

import lombok.extern.log4j.Log4j2;
import org.example.service.ConsumerService;
import org.example.service.ProducerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.common.rabbitmq.RabbitQueue.*;


@Service
@Log4j2
public class ConsumeServiceImpl implements ConsumerService {
    private final ProducerService producerService;

    public ConsumeServiceImpl(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    @RabbitListener(queues = TEXT_MESSAGE_UPDATE)
    public void consumeTextMessageUpdates(Update update) {
        log.info("NODE: Text message is received");

        var message = update.getMessage();
        var sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Invalid text message, call /help to see the valid commands.");
        producerService.produserAnswer(sendMessage);
    }

    @Override
    @RabbitListener(queues = DOC_MESSAGE_UPDATE)
    public void consumeDocMessageUpdates(Update update) {
        log.info("NODE: Doc message is received");

    }

    @Override
    @RabbitListener(queues = PHOTO_MESSAGE_UPDATE)
    public void consumePhotoMessageUpdates(Update update) {
        log.info("NODE: Photo message is received");

    }
}