package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //setter, getter toString method
@AllArgsConstructor //all member field constructor
@NoArgsConstructor //default constructor
public class MemberVO {
	
	private String id, name, pwd, email;
	private int age;

}