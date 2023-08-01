package ex03.di;

import lombok.Data;

@Data
public class MyInfomation {
	
	private Person person; //has-a
	
	public boolean processMessage(StudentPersonImpl student) {
		return this.person.personShow(student.getName(), student.getAge(), student.getGender());
	}
	
	public boolean processMessage(EmployeePersonImpl emp) {
		return this.person.personShow(emp);
	}
	
	public boolean processMessage(String name, int age, String gender) {
		return this.person.personShow(name, age, gender);
	}
	

}
