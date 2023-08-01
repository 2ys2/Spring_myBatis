package ex04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex04/aop/ctx.xml");
		IMessageBean msg = (IMessageBean) ctx.getBean("messageBeanImpl");
		msg.sayHello();
		System.out.println("-=-==--=-==-==-=-=-=-=-=-=-=-=-==");
		msg.engHello();
		System.out.println("\n\n-=-==--=-==-==-=-=-=-=-=-=-=-=-==");
		IBookBean book = ctx.getBean("bookBeanImpl", IBookBean.class );
		System.out.println("deabo");
		System.out.println();
		book.korHello();
		
		
	}
}

/*
[LOG]methodName=method-execution, methodName2 = sayHello ȣ�� �Ǳ� ��....
public void sayHello( call!!!
[LOG] sayHelloȣ�� �Ϸ� �Ǿ����ϴ�.
[LOG] ���� �ð� : 0 ��
-=-==--=-==-==-=-=-=-=-=-=-=-=-==
[LOG]methodName=method-execution, methodName2 = engHello ȣ�� �Ǳ� ��....
public void engHello( call!!!
[LOG] engHelloȣ�� �Ϸ� �Ǿ����ϴ�.
[LOG] ���� �ð� : 0 ��


-=-==--=-==-==-=-=-=-=-=-=-=-=-==
deabo

public int korHello() call~~~
 */

/*
public void sayHello() call!!!
-=-==--=-==-==-=-=-=-=-=-=-=-=-==
public void engHello() call!!!


-=-==--=-==-==-=-=-=-=-=-=-=-=-==
deabo

[LOG]methodName=method-execution, methodName2 = korHello ȣ�� �Ǳ� ��....
public int korHello() call~~~
[LOG] korHelloȣ�� �Ϸ� �Ǿ����ϴ�.
[LOG] ���� �ð� : 0 ��
 */