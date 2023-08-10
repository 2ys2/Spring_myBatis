package org.kosa.model.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	
	private String id, password, name, description;
	private int age;
	private Date regdate;
	private List<AuthVO> authList;

}

/*
create table member_pr(
id varchar2(50),
password varchar2(70),
name varchar2(50),
age number,
description varchar2(400),
regdate date default sysdate
);
*/