package kr.edu.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {
	
	@RequestMapping(value = "/info")
	public String info(Model model) {
		//�̸�, �ּ� ����ó, ������ ����ϱ�
		String phone = "010-9872-0202";
		String name = "�̸��Դϴ�.";
		String address = "�ּ��Դϴ�.";
		
		model.addAttribute("tel", phone);
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		
		return "info";
	}
}
