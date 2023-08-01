package ex02.aop.java;

import java.lang.reflect.Proxy;

public class MainEntry {
	public static void main(String[] args) {
		
		ICalc c = new CalcImpl();
		ICalc proxy = (ICalc) Proxy.newProxyInstance(
							c.getClass().getClassLoader()			//loader : Ŭ���� ã��
							, c.getClass().getInterfaces()			//interface : ����(�Լ�)
							, new LogPrintHandlerImpl(c));			//h : ���� ���� ����
		
		//Proxy�� ���ؼ� ����
		System.out.println(proxy.add(2, 5));
		System.out.println(proxy.mul(5, 3));
		
		
		
		/*
		 * Ŭ���� ���ؼ� ����
		 * System.out.println(c.add(1, 2));
		 * System.out.println(c.add(10, 22));
		 * System.out.println();
		 * System.out.println(c.mul(3, 5));
		 * System.out.println(c.mul(5, 7));
		 */
		
	}
}


/*
invoke method start......
7�� 28, 2023 9:47:26 ���� ex02.aop.java.LogPrintHandlerImpl invoke
INFO: Ÿ�̸� ����
7�� 28, 2023 9:47:26 ���� ex02.aop.java.LogPrintHandlerImpl invoke
INFO: Ÿ�̸� ����
7�� 28, 2023 9:47:26 ���� ex02.aop.java.LogPrintHandlerImpl invoke
INFO: [TimerLOG] Method : mul
7�� 28, 2023 9:47:26 ���� ex02.aop.java.LogPrintHandlerImpl invoke
INFO: [TimerLog] process Time : 1
15
 */
