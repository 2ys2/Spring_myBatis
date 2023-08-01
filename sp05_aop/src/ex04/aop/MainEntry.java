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
[LOG]methodName=method-execution, methodName2 = sayHello 호출 되기 전....
public void sayHello( call!!!
[LOG] sayHello호출 완료 되었습니다.
[LOG] 실행 시간 : 0 초
-=-==--=-==-==-=-=-=-=-=-=-=-=-==
[LOG]methodName=method-execution, methodName2 = engHello 호출 되기 전....
public void engHello( call!!!
[LOG] engHello호출 완료 되었습니다.
[LOG] 실행 시간 : 0 초


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

[LOG]methodName=method-execution, methodName2 = korHello 호출 되기 전....
public int korHello() call~~~
[LOG] korHello호출 완료 되었습니다.
[LOG] 실행 시간 : 0 초
 */