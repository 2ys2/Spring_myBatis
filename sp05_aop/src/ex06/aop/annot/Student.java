package ex06.aop.annot;

public class Student {
	
	private String name;
	private int age, gradeNum, classNum;
	
	public void setName(String name) { //DI
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
	public void getStudentInfo() {
		System.out.println("�̸� : " + this.name);
		System.out.println("���� : " + this.age);
		System.out.println("�г� : " + this.gradeNum);
		System.out.println("�� : " + this.classNum);
	}

}
