package org.kosa.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosa.model.dao.UserDAO;
import org.kosa.model.dto.AuthVO;
import org.kosa.model.dto.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/accessError")
	public String accessError(Authentication auth) {
		System.out.println("access Denied : " + auth);
		return "accessError";
	}
	@RequestMapping("/signUpForm")
	public void signUpForm() {
		System.out.println("signUpForm Page!");
	}
	
	@RequestMapping("/loginForm")
	public void loginForm() {
		System.out.println("loginForm Page!");
	}
	
	/*
	 * @RequestMapping("/logout") public String logout() {
	 * System.out.println("logout!!"); return "loginForm"; }
	 */
	
	
	@RequestMapping("/updateForm")
	public String updateForm(HttpServletRequest request, String id) {
		
		UserVO vo = dao.detailUser(id);
		vo.setAuthList(dao.detailAuth(id));
		
		System.out.println("updateForm Page! : " + vo);
		request.setAttribute("user", vo);
		
		return "userUpdate";
	}
	
	@RequestMapping("/signup") //회원가입처리
	public String insertUser(String id, String password, String name, int age, String authority, String description) {
		
		//입력 받은 password bcryptPasswordEncoder으로 인코딩
		String bcpassword = bcryptPasswordEncoder.encode(password);
		
		Map<String, Object> usermap = new HashMap<>();
		usermap.put("id", id);
		usermap.put("password", bcpassword);
		usermap.put("name", name);
		usermap.put("age", age);
		usermap.put("description", description);
		
		
		Map<String, Object> authmap = new HashMap<>(); 
		authmap.put("userid", id);
		authmap.put("auth", authority);
		
		System.out.println("usermap : " + usermap + ", authmap : " + authmap);
		
		int userresult = dao.insertUser(usermap);
		int authresult = dao.insertAuth(authmap);
		
		System.out.println("userresult : " + userresult + ", authresult : " + authresult);
		
		return "loginForm";
	}
	
//	@RequestMapping("/mypage")
//	public String detailUser(String id) {
//		System.out.println("detailUser ! ");
//		Map<String, Object> map = dao.detailUser(id);
//		
//		System.out.println("datialUsermap : " + map);
//		
//		return "mypage";
//	}
	
	@RequestMapping("/getList")
	public String getList(HttpServletRequest request) {
		System.out.println("getList 회원 목록 조회");
		List<UserVO> list = new ArrayList<>();
		list = dao.selectAll();
		System.out.println( list );
		
		request.setAttribute("list", list);
		
		return "userList";
	}
	
	@RequestMapping("/userdetail")
	public String userdetail(String id, HttpServletRequest request) {
		System.out.println("userdetail id : " + id);
		UserVO vo = dao.detailUser(id);
		request.setAttribute("user", vo);
		return "userDetail";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Principal principal, HttpServletRequest request) {
		String id = principal.getName();
		System.out.println("principal : " + id);
		UserVO vo = dao.detailUser(id);
		vo.setAuthList(dao.detailAuth(id));
		AuthVO avo = dao.detailUserAuth(id);
		
		
		System.out.println("mypage vo : " + vo);
		request.setAttribute("user", vo);
		request.setAttribute("auth", avo);
//		Map<String, Object> map = dao.mypage(id);
//		System.out.println(map);
//		request.setAttribute("user", map);
		return "myPage";
	}
	
	@RequestMapping("/update")
	public void update(String id, String name, int age, String authority, String description, HttpServletResponse response) {
		
		Map<String, Object> usermap = new HashMap<>();
		usermap.put("id", id);
		usermap.put("name", name);
		usermap.put("age", age);
		usermap.put("description", description);
		
		Map<String, Object> authmap = new HashMap<>(); 
		authmap.put("userid", id);
		authmap.put("auth", authority);
		
		int result = dao.updateUser(usermap);
		dao.updateAuth(authmap);
		
		try {
			if ( result == 1) {
			response.sendRedirect("/getList");
			} else {
			response.sendRedirect("/loginForm");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/delete")
	public void deleteUser(String id, HttpServletResponse response) {
		int re = dao.deleteUser(id);
		int sult = dao.deleteAuth(id);
		System.out.println(re + ", " + sult);
		
		try {
			if (re == 1) {
			SecurityContextHolder.clearContext();
			response.sendRedirect("/loginForm");
			} else {
				response.sendRedirect("/getList");	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
//로그인 처리
public Map <String, Object> loginUser(String id);
//회원 정보 수정
public int updateUser(Map<String, String> map);
//회원 탈퇴 처리
public int deleteUser(String id, String password);
//회원 목록 조회
public List<UserVO> selectAll();
//회원 정보 상세
public UserVO detailUser(String id);
*/