package quiz;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data*/
public class Client2 {
	
	private String defualthost;
	private String host;
	
	
	public void send() {
		System.out.println("client send : " + host);
	}

	public void setDefualthost(String defualthost) {
		this.defualthost = defualthost;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void init() throws Exception {
		System.out.println("init()");
	}
	
	public void close() throws Exception {
		System.out.println("close() ");
	}
	

}
