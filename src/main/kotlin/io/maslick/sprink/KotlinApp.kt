package io.maslick.sprink

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


internal interface MessageService {
    fun getMessage(): String
}

@Component
internal class MessagePrinter(@Autowired private val service: MessageService) {
    fun printMessage() {
        println(service.getMessage())
    }
}

@Configuration
@ComponentScan(basePackageClasses = [MessagePrinter::class])
internal class MyKotlinConfig {
    @Bean fun mockMessageService(): MessageService = object : MessageService {
        override fun getMessage() = "hello people!!!"
    }
}

fun main(args: Array<String>) {
    val context = AnnotationConfigApplicationContext(MyKotlinConfig::class.java)
    val printer = context.getBean(MessagePrinter::class.java)
    printer.printMessage()
}