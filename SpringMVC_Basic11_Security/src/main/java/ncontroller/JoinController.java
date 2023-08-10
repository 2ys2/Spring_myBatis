package ncontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	//memberDao  ����
	private MemberDao memberdao;
	
	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	//GET ��û 
	//join.jsp ȭ��ó��
	@GetMapping("join.htm")
	public String join() {
		//return "join.jsp";
		return "joinus/join";
		//  /WEB-INF/views/joinus/join.jsp
				
	}
	
	
	
	//POST ��û
	@PostMapping("join.htm")
	public String join(Member member) {
		System.out.println(member.toString());
		try {
			memberdao.insert(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index.htm";
		//http://localhost:8090/SpringMVC/joinus/join.htm
		//return "redirect:/index.htm"; ó���ϸ�
		//http://localhost:8090/SpringMVC/index.htm
    }
	
	//�α��� ��û
	@GetMapping(value="login.htm")
	public String login() {
		return "joinus/login";
	}
}