package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.MemberDAO;
import com.model.MemberVO;

@Controller
@RequestMapping("check.kosa")
public class MemberCheckController {
	
	@Autowired //자동주입
	private MemberDAO memberDAO; //DB 연결
	
	@RequestMapping(method = RequestMethod.GET )
	public String form() {
		
		return "membercheckForm";
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public ModelAndView submit( @RequestParam(value = "id", required = true) String id) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberVO vo = memberDAO.selectMemberById(id);
		List list = memberDAO.memberById(id);
		
		//mav.addObject("memberok", vo);
		mav.addObject("memberok", list);
		
		//if (vo != null) mav.setViewName("membercheckSuccess"); //move view page
		//if (list.size() > 0) mav.setViewName("membercheckSuccess"); //move view page
		if ( !list.isEmpty() ) mav.setViewName("membercheckSuccess"); //move view page
		else mav.setViewName("membercheckForm");
		
		return mav;
	}
}
