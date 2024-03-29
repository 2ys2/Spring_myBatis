package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import springConfig.Client2;

@Configuration
public class JavaConfigPrototype {
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("prototype") /* 객체가 여러개 있을 경우에 */
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("server 222");
		
		return client2;
	}
	

}
