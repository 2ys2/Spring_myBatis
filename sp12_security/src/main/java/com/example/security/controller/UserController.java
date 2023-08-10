package com.example.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.security.model.dao.UserDAO;
import com.example.security.service.ShaEncoder;

@Controller
public class UserController {
	
	@Autowired
	ShaEncoder shaEncoder; //��ȣȭ ��, �츮�� ����ɷ�!
	
	@Inject
	UserDAO userDAO;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("key", "������ ��ť��Ƽ �׽�Ʈ �Դϴ�.");
		return "home"; //home.jsp
	}
	
//�α��� �������� �̵�
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";
	}

//ȸ������ �������� �̵�
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";
	}
	
//ȸ������ ó��
		@RequestMapping("/user/insertUser.do")
		public String insertUser(@RequestParam String userid,
				@RequestParam String passwd,
				@RequestParam String name,
				@RequestParam String authority) {
			
		//��й�ȣ ��ȣȭ
			String dbpw = shaEncoder.saltEncoding(passwd, userid);
			
			Map<String, String> map = new HashMap();
			map.put("userid", userid);
			map.put("passwd", dbpw);
			map.put("name", name);
			map.put("authority", authority);
			
			int result = userDAO.insertUser(map);
			
			return "user/login";
		}

		/*
		@RequestMapping("/user/login_check.do")
		public String selectUser(@RequestParam String passwd,
				@RequestParam String userid) {
			
			String dbpw = shaEncoder.saltEncoding(passwd, userid);
			
//			Map<String, Object> map = new HashMap();
//			map.put("userid", userid);
//			map.put("passwd", dbpw);
			System.out.println("userid : " + userid);
			System.out.println("passwd : " + passwd);
			
			userDAO.selectUser(userid);
			
			return "user/userMain";
		}
		*/
	
//������ ���� ������
		@RequestMapping("/admin/")
		public String admin() {
			return "admin/main";    
		}
		
		@RequestMapping("/user/")
		public String user() {
			return "user/userMain";    
		}
	
}
