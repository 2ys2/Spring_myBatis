package ex06.aop.annot;

public class Worker {
	
	private String name;
	private int age;
	private String job;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public void getWorkerInfo() {
		System.out.println("�̸� : " + this.name);
		System.out.println("���� : " + this.age);
		System.out.println("���� : " + this.job);
	}

}
