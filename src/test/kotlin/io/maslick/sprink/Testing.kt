package io.maslick.sprink

import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

class Test {
    @Test
    fun testXmlBeanDefinition() {
        val context = ClassPathXmlApplicationContext("spring.xml")
    }
}