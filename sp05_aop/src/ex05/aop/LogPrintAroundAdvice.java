package ex05.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("Around Service invoke() start..........");
		//보조업무
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); //시간측정 시작
		log.info("타이머 시작");
		
		//////////////////main 실행 코드/////////////////////
		Object result = invocation.proceed();
		///////////////////////////////////////////////////
		
		sw.stop(); //시간측정 끝
		log.info("타이머 정지");

		log.info("[TimerLOG] Method : " + invocation.getMethod()); //실행하는 시점의 함수 명칭
		System.out.println("[TimerLOG] args : " + Arrays.toString(invocation.getArguments()));
		log.info("[TimerLog] process Time : " + sw.getTotalTimeMillis()); //작업에 걸린 시간
		
		return result;
	}
}
