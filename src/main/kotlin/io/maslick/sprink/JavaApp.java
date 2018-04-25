package io.maslick.sprink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

interface MessageServiceJava {
    String getMessage();
}

@Component
class MessagePrinterJava {

    final private MessageServiceJava service;

    @Autowired
    public MessagePrinterJava(MessageServiceJava service) {
        this.service = service;
    }

    void printMessage() {
        System.out.println(service.getMessage());
    }
}

@Configuration
@ComponentScan(basePackageClasses = MessagePrinterJava.class)
class MyJavaConfig {

    @Bean
    MessageServiceJava mockMessageService() {
        return () -> "Hello World!";
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJavaConfig.class);
        MessagePrinterJava printer = context.getBean(MessagePrinterJava.class);
        printer.printMessage();
    }
}
