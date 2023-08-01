package ex04.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		//스프링기반 객체 생성시 new X , bean으로 객체 생성한다!
		ApplicationContext context = new ClassPathXmlApplicationContext("ex04/DI/appCtx.xml");
		IRecordViewImpl view = context.getBean("view", IRecordViewImpl.class);
		/*IRecordViewImpl view = (IRecordVIewImpl) context.getBean("view");*/
		view.print();

		
		
		/*
		IRecordVIewImpl view = new IRecordVIewImpl();
		IRecordImpl record = new IRecordImpl();
		
		//조립
		view.setRecord(record);
		view.input();
		view.print();
		*/
		
	}
}
