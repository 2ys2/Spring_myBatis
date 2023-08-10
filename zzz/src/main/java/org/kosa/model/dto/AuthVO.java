package org.kosa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthVO {
	
	private String userid, auth;

}

/*
create table auth_pr(
userid varchar2(50),
auth varchar2(30)
);
*/