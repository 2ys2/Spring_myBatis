package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.JavaConfig;
import springConfig.Client;

public class MainEntry {
	public static void main(String[] args) {
		//ApplicationContext ctx
		AnnotationConfigApplicationContext ctx
		= new AnnotationConfigApplicationContext(JavaConfig.class);

		Client c = ctx.getBean("client", Client.class);
		c.setHost("서버야!!!!!");
		c.send();

		Client c2 = ctx.getBean("client", Client.class);
		c2.setHost("defaultHost");
		c2.send();


		//spring은 싱글톤 패턴임
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		/*
		205721196
		205721196 주소 같다
		 */

		ctx.close();
	}
}
