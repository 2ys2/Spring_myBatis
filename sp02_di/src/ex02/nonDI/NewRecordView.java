package ex02.nonDI;

public class NewRecordView {
	
	public NewRecord record;
	
	
	//필요한 객체를 setter 메소드를 통해서 주입 받아서 사용
	//객체의 생성이 서로 독립적이고 필요시 객체에 주입
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	public void print() {
		System.out.println("kor : " + record.getKor());
		System.out.println(record.total() + "/" + record.avg());
		System.out.println("+++++++++++++++++++++++");
		record.disp();
		System.out.println(record); //toString() 함수 호출
	}
}
