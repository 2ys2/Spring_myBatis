package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfigPrototype;
import springConfig.Client2;

public class MainEntry2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
			= new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		
		Client2 client = ctx.getBean("client2", Client2.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		client.send();
		
		System.out.println(client.hashCode());
		System.out.println(client2.hashCode());
		/*
		1721246982
		1892627171 주소 다름 -> prototype : 각각 메모리에 선언되기때문
		 */
		ctx.close();
	}
}
