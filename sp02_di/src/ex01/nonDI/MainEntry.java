package ex01.nonDI;

public class MainEntry {
	/*
	is-a		,	has-a
	��Ӱ���			���԰���
	has-a ���踦 ���ؼ� ��ü �ٷ��
	*/
	public static void main(String[] args) {
		NewRecordView view = new NewRecordView(1, 2, 3, 4);
		view.print();
		
		
	}
}
