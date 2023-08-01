package ex05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex05/di/MemberCtx.xml");
		
		MemberDTO dto = ctx.getBean("vo", MemberDTO.class);
		MemberDAO dao = (MemberDAO) ctx.getBean("dao");
		
		dao.insert();
	}

}
