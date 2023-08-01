package ex03.nonDI;

public class MainEntry {
	public static void main(String[] args) {
		IRecordVIewImpl view = new IRecordVIewImpl();
		IRecordImpl record = new IRecordImpl();
		
		//Á¶¸³
		view.setRecord(record);
		view.input();
		view.print();
		
	}
}
