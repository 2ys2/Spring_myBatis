package ex02.nonDI;

public class NewRecordView {
	
	public NewRecord record;
	
	
	//�ʿ��� ��ü�� setter �޼ҵ带 ���ؼ� ���� �޾Ƽ� ���
	//��ü�� ������ ���� �������̰� �ʿ�� ��ü�� ����
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	public void print() {
		System.out.println("kor : " + record.getKor());
		System.out.println(record.total() + "/" + record.avg());
		System.out.println("+++++++++++++++++++++++");
		record.disp();
		System.out.println(record); //toString() �Լ� ȣ��
	}
}
