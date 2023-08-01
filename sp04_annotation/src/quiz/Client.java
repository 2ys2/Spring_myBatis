package quiz;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Client implements InitializingBean, DisposableBean{
	
	private String defualthost;
	private String host;
	
	public void send() {
		System.out.println("client send : " + host);
	}

	public Client() {
		super();
		System.out.println("default 생성자입니다.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() ");
	}
	

}
