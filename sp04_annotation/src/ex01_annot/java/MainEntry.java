package ex01_annot.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Cats catsInfo = ctx.getBean("catsInfo", Cats.class);
		catsInfo.getMyCatsInfo();
		
		MyCats cats2 = (MyCats) ctx.getBean("cat2");
		catsInfo.setMyCatsInfo(cats2);
		catsInfo.getMyCatsInfo();
		ctx.close();
	}
}
