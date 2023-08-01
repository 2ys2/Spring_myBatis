package quiz;

public class IMessageEngImpl implements IMessage {
	
	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public IMessageEngImpl() {	}

	@Override
	public void sayHello() {
		System.out.println(this.msg);
	}
}
