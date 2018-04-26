package io.maslick.sprink

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


internal interface MessageService {
    fun getMessage(): String
}

@Component
internal class MessagePrinter(private val service: MessageService) {
    fun printMessage() {
        println(service.getMessage())
    }
}

@Configuration
@ComponentScan(basePackages = ["io.maslick.sprink"])
internal class MyKotlinConfig {
    @Bean fun mockMessageService(): MessageService = object : MessageService {
        override fun getMessage() = "hello people!!!"
    }
}

fun main(args: Array<String>) {
    val timeA = System.currentTimeMillis()
    val context = AnnotationConfigApplicationContext(MyKotlinConfig::class.java)
    val timeB = System.currentTimeMillis()
    val time = timeB - timeA
    println("Time to load context: $time ms")

    val printer = context.getBean(MessagePrinter::class.java)
    printer.printMessage()
    println("Number of beans registered: ${context.beanDefinitionNames.size}")
}