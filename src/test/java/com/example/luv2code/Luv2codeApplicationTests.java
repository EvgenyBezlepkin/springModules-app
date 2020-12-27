package com.example.luv2code;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration
class Luv2codeApplicationTests {

	@Test
	public void testSayQuote() throws Exception{
		ClassPathXmlApplicationContext context	= new ClassPathXmlApplicationContext("applicationContext.xml");

	}
}

