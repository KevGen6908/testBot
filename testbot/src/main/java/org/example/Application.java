package org.example;

import org.example.dispatcher.BotInitialization;
import org.example.dispatcher.DispatcherConfiguration;
import org.example.node.config.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Application {
    public static void main(String[] args) throws TelegramApiException {
        // Инициализация контекста Spring с использованием всех необходимых классов конфигурации
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                DispatcherConfiguration.class,
                NodeConfiguration.class,
                RabbitMQConfigg.class,
                RabbitConfigurationn.class,
                TomcatConfigg.class,
                DatabaseConfig.class,
                ReactiveDatabaseConfig.class
        );

        // Инициализация бота
        context.getBean(BotInitialization.class).init();

        // Убедиться, что сервер Tomcat запускается
        context.getBean(TomcatConfigg.class);
    }
}
