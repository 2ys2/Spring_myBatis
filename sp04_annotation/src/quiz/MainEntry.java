package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("quiz/clientCtx.xml");
		Client client = ctx.getBean("client1", Client.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		Client2 client3 = ctx.getBean("client2", Client2.class);
		System.out.println(client2.hashCode());
		System.out.println(client3.hashCode());
		System.out.println( client2 == client3 );
		
//		client2.setHost("서버서버");
//		client3.send();
		 
		ctx.close();
	}
}
