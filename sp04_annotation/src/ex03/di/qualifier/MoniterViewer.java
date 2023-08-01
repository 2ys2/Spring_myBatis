package ex03.di.qualifier;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoniterViewer {
	
	private Recorder recorder; //has-a
	
	//@Inject
//	@Autowired(required = false) /* default:required = true */
//	public MoniterViewer(@Qualifier("key") Recorder recorder) { //constructor method
//		super();
//		this.recorder = recorder;
//		System.out.println("@Autowired �ڵ� ����");
//	}
	
	@Autowired
	@Qualifier("recorder4") //id="recorder3" //<qualifier /> ������Ʈ�� �������
//	@Qualifier("key") //<qualifier value="key" />
//	public void setRecorder(@Qualifier("r1"))(Recorder recorder) {
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
	
//	@Autowired
//	@Qualifier("cord")
//	public void setRecorder(Recorder recorder) {
//		this.recorder = recorder;
//	}
	
	public void show() {
		recorder.show();
		System.out.println("MoniterViewer class show method call~~");
		System.out.println("setter method MoniterViewer class show method call~~");
	}

}
