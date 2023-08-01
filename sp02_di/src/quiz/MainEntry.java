package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("quiz/appCtx.xml");
		IMessageKorImpl kor = (IMessageKorImpl) context.getBean("msgkor");
		IMessageEngImpl eng = context.getBean("msgeng", IMessageEngImpl.class);
		/* IMessageEngImpl eng = (IMessageEngImpl) context.getBean("msgeng"); */
		
		kor.sayHello();
		eng.sayHello();
		
	}
}
