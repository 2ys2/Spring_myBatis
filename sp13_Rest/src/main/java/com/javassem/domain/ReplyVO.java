package com.javassem.domain;

import lombok.Data;

@Data
public class ReplyVO {
	private int rno;			// ��۹�ȣ
	private int bno;			// �Խñ۹�ȣ ( ����� �޸� �Խñ� )
	private String reply;		// ��۳���
	private String replyer;		// ����ۼ���
	private String replydate;	// ����ۼ���
}
