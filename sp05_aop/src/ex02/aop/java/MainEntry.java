package ex02.aop.java;

import java.lang.reflect.Proxy;

public class MainEntry {
	public static void main(String[] args) {
		
		ICalc c = new CalcImpl();
		ICalc proxy = (ICalc) Proxy.newProxyInstance(
							c.getClass().getClassLoader()			//loader : 클래스 찾기
							, c.getClass().getInterfaces()			//interface : 행위(함수)
							, new LogPrintHandlerImpl(c));			//h : 보조 업무 구현
		
		//Proxy를 통해서 실행
		System.out.println(proxy.add(2, 5));
		System.out.println(proxy.mul(5, 3));
		
		
		
		/*
		 * 클래스 통해서 실행
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
7월 28, 2023 9:47:26 오전 ex02.aop.java.LogPrintHandlerImpl invoke
INFO: 타이머 시작
7월 28, 2023 9:47:26 오전 ex02.aop.java.LogPrintHandlerImpl invoke
INFO: 타이머 정지
7월 28, 2023 9:47:26 오전 ex02.aop.java.LogPrintHandlerImpl invoke
INFO: [TimerLOG] Method : mul
7월 28, 2023 9:47:26 오전 ex02.aop.java.LogPrintHandlerImpl invoke
INFO: [TimerLog] process Time : 1
15
 */
