package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/sample/*")
@Controller
public class SampleController {
	
	/*
	 * @RequestMapping("/login") public String login() {
	 * System.out.println("login page"); return "login"; }
	 */
	
	@RequestMapping("/all")
	public String doAll() {
		System.out.println("do all access everybody");
		return "all";
	}
	
	@RequestMapping("/member")
	public String doMember() {
		System.out.println("logined member");
		return "member";
	}
	
	@RequestMapping("/admin")
	public String doAdmin() {
		System.out.println("admin only");
		return "admin";
	}
}
	
	/*
	 * @GetMapping("/admin") public void doAdmin() {
	 * System.out.println("admin only"); }
	 */

