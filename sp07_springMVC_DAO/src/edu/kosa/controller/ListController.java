package edu.kosa.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.kosa.model.DeptDAO;

@Controller
public class ListController {

	@Autowired
	private DeptDAO deptDao; // DB연결 관련

//	public void setDeptDAO(DeptDAO deptDao) { //DI
//		this.deptDao = deptDao;
//	}

//	public String list(Model model) {
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		List list = deptDao.listDept();
		model.addAttribute("list",list);
		return "list"; // /WEB-INF/views/list.jsp
	}

	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", getGreeting()); /* 변수뿐 아니라 함수도 가능 */
		mav.setViewName("hello"); //hello.jsp
		
		return mav;
	}

	private Object getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if ( hour >= 6 && hour <= 11 ) {
			return "좋은 아침";
		} else if ( hour>=12 && hour <= 15) {
			return "점심 입니다. 밥먹고 졸려요";
		} else if ( hour>=18 && hour <= 20) {
			return "퇴근 기다려요. 편한 저녁 되세요!";
		}
		
		return "Hello World";
	}

}
