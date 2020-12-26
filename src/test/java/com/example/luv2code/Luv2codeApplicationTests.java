package com.example.luv2code;

import oldcode.app.AnnotationBeanScopeDemoApp;
import oldcode.terminator.Quoter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = AnnotationBeanScopeDemoApp.class)
@ContextConfiguration
class Luv2codeApplicationTests {

	// lookup нделать не по классам а по интерфейсам потому что если объект класса будет обернут в проки его класс поменяется и поиск будет невозможен

	@Test
	public void testSayQuote() throws Exception{
		ClassPathXmlApplicationContext context	= new ClassPathXmlApplicationContext("applicationContext.xml");

		// закомментировать для вызова третьей фазы
            context.getBean(Quoter.class).sayQuote();

	}

}

