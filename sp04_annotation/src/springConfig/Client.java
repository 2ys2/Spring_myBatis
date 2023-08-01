package springConfig;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {
	
	private String defaulthost;
	private String host;

	public Client() {
		System.out.println("CLient Default Constructor");
	}

	//constructor DI
	public Client(String defaulthost) {
		super();
		this.defaulthost = defaulthost;
		System.out.println("Client ������ : " + this.defaulthost);
	}
	
	
	//setter DI
	public void setDefaulthost(String defaulthost) {
		this.defaulthost = defaulthost;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	
	public void send() { /* <property name="host" value="����" /> */
		System.out.println("Client.send() to : " + host);
	}

	//�ʱ�ȭ �޼���(�̺�Ʈ�� ���������� ������ �ڵ� ȣ�� : ȣ�����)
	//InitializingBean ���� ������
	//afterPropertieSet : property injection �Ŀ�
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() ����");

	}
	
	//�Ҹ� �޼���(�̺�Ʈ�� ���������� ������ �ڵ� ȣ�� : ȣ�����)
	//DisposableBean ���� ������
	@Override
	public void destroy() throws Exception { /*ctx.close();*/
		System.out.println("Client.destory() ����");
		
	}

}
