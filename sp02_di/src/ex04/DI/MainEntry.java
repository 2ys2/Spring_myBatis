package ex04.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		//��������� ��ü ������ new X , bean���� ��ü �����Ѵ�!
		ApplicationContext context = new ClassPathXmlApplicationContext("ex04/DI/appCtx.xml");
		IRecordViewImpl view = context.getBean("view", IRecordViewImpl.class);
		/*IRecordViewImpl view = (IRecordVIewImpl) context.getBean("view");*/
		view.print();

		
		
		/*
		IRecordVIewImpl view = new IRecordVIewImpl();
		IRecordImpl record = new IRecordImpl();
		
		//����
		view.setRecord(record);
		view.input();
		view.print();
		*/
		
	}
}
