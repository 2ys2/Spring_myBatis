package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.model.UserDAO;

@Controller
public class CommonController {
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	UserDAO dao;

	@RequestMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}

	@RequestMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("customLogin error : " + error);

		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Accout");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logout!");
		}
	}

	@RequestMapping("/customLogout")
	public void logoutGET() {
		System.out.println("customLogout");

	}
	
	@RequestMapping("/join")
	public void joinPage() {
		System.out.println("joinPage");

	}
	
	@RequestMapping("/insertUser")
	public String insertUser(String username, String password, String authority) {
		String bpasswd = bcryptPasswordEncoder.encode(password);
		System.out.println("password : " + password + ", bpasswd : " + bpasswd);
		
		Map<String, String> map = new HashMap();
		map.put("username", username);
		map.put("password", bpasswd);
		map.put("authority", authority);
		
		int result = dao.insertUser(map);
		System.out.println("result : " + result);
		
		return "hihi";
	}
	
	
	
}