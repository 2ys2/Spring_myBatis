package ex05.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("ex05/aop/appCtx.xml");
		
			ICalc proxy = (ICalc) ctx.getBean("proxy");
			System.out.println(proxy.add(10, 20));
			System.out.println(proxy.add(111, 222));
			System.out.println(proxy.sub(2, 10, 3));
	}
}

/*
Around Service invoke() start..........
7월 28, 2023 2:48:36 오후 ex05.aop.LogPrintAroundAdvice invoke
INFO: 타이머 시작
add 주관심사
7월 28, 2023 2:48:36 오후 ex05.aop.LogPrintAroundAdvice invoke
INFO: 타이머 정지
7월 28, 2023 2:48:36 오후 ex05.aop.LogPrintAroundAdvice invoke
INFO: [TimerLOG] Method : public abstract int ex05.aop.ICalc.add(int,int)
[TimerLOG] args : [111, 222]
7월 28, 2023 2:48:36 오후 ex05.aop.LogPrintAroundAdvice invoke
INFO: [TimerLog] process Time : 1
333
*/