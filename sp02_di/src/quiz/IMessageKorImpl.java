package quiz;

public class IMessageKorImpl implements IMessage {
	
	private String msg;
	
	public IMessageKorImpl() {	}

	public IMessageKorImpl(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public void sayHello() {
		System.out.println(this.msg);

	}

}
