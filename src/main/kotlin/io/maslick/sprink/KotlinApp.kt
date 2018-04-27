package io.maslick.sprink

import org.springframework.context.support.ClassPathXmlApplicationContext

class Performer {
    lateinit var instruments: List<Instrument>
    override fun toString(): String {
        return "Performer [instruments=$instruments]"
    }
}

data class Instrument(var name: String? = null) {
    override fun toString(): String {
        return "Instrument [name=$name]"
    }
}

fun main(args: Array<String>) {
    val timeA = System.currentTimeMillis()
    val context = ClassPathXmlApplicationContext("spring.xml")
    val timeB = System.currentTimeMillis()
    println("Context up time: ${timeB-timeA} ms")

    println("number of beans: " + context.beanDefinitionCount)
    context.beanDefinitionNames.forEach { println("bean: $it") }
    println()

    val performer = context.getBean("performer", Performer::class.java)
    performer.instruments.forEach { println(it) }
}