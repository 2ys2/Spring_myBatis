package kr.edu.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {
	
	@RequestMapping(value = "/info")
	public String info(Model model) {
		//이름, 주소 연락처, 데이터 출력하기
		String phone = "010-9872-0202";
		String name = "이름입니다.";
		String address = "주소입니다.";
		
		model.addAttribute("tel", phone);
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		
		return "info";
	}
}
