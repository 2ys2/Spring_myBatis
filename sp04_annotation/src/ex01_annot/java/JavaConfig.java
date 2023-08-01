package ex01_annot.java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //xml ���� ���� ����
public class JavaConfig { //ctx.xml, appCtx.xml ... ���� ����
	
	@Bean
	public MyCats cat1() { //== MyCats cat1 = new MyCats(); == <bean id="cat1" class="ex01.annot.java.MyCats" /> == ����.
		ArrayList<String> hobbys = new ArrayList<>();
		hobbys.add("�߱���");
		hobbys.add("�չߵ��");
		
		MyCats myCats = new MyCats("����", 12, hobbys);
		myCats.setWeight(3.0);
		myCats.setColor("black");
		return myCats;
	}
	
	@Bean //��ü����
	public MyCats cat2() {
		ArrayList<String> hobbys = new ArrayList<>();
		hobbys.add("��ũ�ϱ�");
		hobbys.add("���ڱ�");
		
		MyCats myCats = new MyCats("�����", 3, hobbys);
		myCats.setWeight(2.3);
		myCats.setColor("white");
		return myCats;
	}
	
	@Bean
	public Cats catsInfo() {
		Cats cats = new Cats(this.cat1()); //ref="employee"
		return cats;
	}

}
