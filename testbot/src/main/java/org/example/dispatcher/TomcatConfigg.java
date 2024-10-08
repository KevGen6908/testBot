package org.example.dispatcher;

import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app.properties")
public class TomcatConfigg {

    @Value("${server.port:8084}")
    private int serverPort;

    @Bean
    public Tomcat tomcat() throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(serverPort);
        tomcat.getConnector(); // Это необходимо для инициализации Tomcat
        tomcat.start();
        return tomcat;
    }
}
