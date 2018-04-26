package io.maslick.sprink

import org.springframework.context.support.ClassPathXmlApplicationContext

internal class Performer {

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

internal object AppMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val context = ClassPathXmlApplicationContext("spring.xml")
        println("number of beans: " + context.beanDefinitionCount)
        context.beanDefinitionNames.forEach { println(it) }

        val performer = context.getBean("performer", Performer::class.java)
        performer.instruments.forEach { println(it) }
    }
}