package ex03.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		String config = "classpath:ex03/aop/appCtx.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		
		ICalc proxy = ctx.getBean("proxy", ICalc.class);
		System.out.println(proxy.add(20, 30));
		System.out.println(proxy.sub(20, 30, 2));
		System.out.println(proxy.mul(20, 30));
	}
}

/*
 invoke method start..........
7월 28, 2023 10:33:22 오전 ex03.aop.LogPrintHandlerImpl invoke
INFO: 타이머 시작
7월 28, 2023 10:33:22 오전 ex03.aop.LogPrintHandlerImpl invoke
INFO: 타이머 정지
7월 28, 2023 10:33:22 오전 ex03.aop.LogPrintHandlerImpl invoke
INFO: [TimerLOG] Method : public abstract int ex03.aop.ICalc.mul(int,int)
7월 28, 2023 10:33:22 오전 ex03.aop.LogPrintHandlerImpl invoke
INFO: [TimerLog] process Time : 0
600
 */
