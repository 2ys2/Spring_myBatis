package kr.co.mycom.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mycom.model.BoardDTO;
import kr.co.mycom.service.BoardService;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService; //db ���� �� DML ��ɾ� ó��
	
	@RequestMapping("/writeform.htm") //GET ���� ��� ó��
	public String writeform() {
		return "writeform"; // /WEB-INF/view/ + writeform + .jsp
	}
	
	@RequestMapping("/write.htm")
	public String write(BoardDTO dto) {
		boardService.insertBoard(dto);
		//return "test"; //list.htm
		return "redirect:/list.htm"; //list.htm
	}
	
	@RequestMapping("/list.htm")
	public String list(HttpServletRequest request) {
		int pg = 1;
		String strPg = request.getParameter("pg");
		
		if ( strPg != null ) {
			pg = Integer.parseInt(strPg);
		}
		int rowSize = 10;
		int start = ( pg * rowSize ) - ( rowSize - 1 );
		int end = pg * rowSize;
		
		int total = boardService.getBoardCount(); //�� �Խù� ��
		System.out.println(start + ", " + end + ", " +total);
		int allPage = (int) Math.ceil( total / (double) rowSize); //������ ��
		System.out.println("��ü �������� : " + allPage);
		
		int block = 10; //���������� ������ ���� <<[1][2][3]~~[9][10]>>
		int fromPage = ( (pg-1) / block*block ) + 1; //������ �������� ����
		int toPage = ( (pg-1) / block*block ) + block; //������ ������ ��
		
		if ( toPage > allPage ) { //20 > 17
			toPage = allPage;
		}
		
		HashMap map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardDTO> list = boardService.getBoardList(map);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("allPage", allPage);
		request.setAttribute("fromPage", fromPage);
		request.setAttribute("toPage", toPage);
		
		return "list"; //list.jsp
	}
	
	@RequestMapping("/read.htm")
	public String selectByNum(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		boardService.updateHit(num); //��ȸ�� ����
		
		request.setAttribute("pg", request.getParameter("pg"));
		request.setAttribute("dto", boardService.getBoard(num));
		return "read"; //read.jsp
	}
	
	//���� ��ư Ŭ����
	@RequestMapping("/updateform.htm")
	public String updateform(int num, int pg, Model model) {
		BoardDTO dto = boardService.getBoard(num);
		model.addAttribute("dto", dto);
		model.addAttribute("pg", pg);
		return "updateform"; // updateform.jsp
	}
	
	@RequestMapping("/update.htm")
	public String update(BoardDTO dto, int pg) {
		int result = boardService.updateBoard(dto); //���� 0, ���� 1
		String res = "redirect://list.htm?pg="+pg; //�����̷�Ʈ  URL�� ������. �ּҰ� �ٲ�,
		if( result  ==  0 ) res = "fail";
				
		return res;
	}
	@RequestMapping("/deleteform.htm")
	public String deleteform(int pg, int num) {
		return "deleteform";
	}
	
	@RequestMapping("/delete.htm")
	public String deleteBoard(BoardDTO dto, int pg) {
		System.out.println("num : " + dto.getNum());
		System.out.println("pwd : " + dto.getPwd());
		int result = boardService.deleteBoard(dto);
		
		if (result <= 0) {
			return "fail";
		}
		return "redirect:/list.htm?pg="+pg;
	}
	
	@RequestMapping("/replyform.htm")
	public String replyform( int num, Model model ) {   
		BoardDTO  dto = boardService.getBoard(num);
		model.addAttribute("dto", dto);
		return "replyform";  // replyform.jsp
	}
	
//	@RequestMapping("/reply.htm")
//	public String reply(HttpServletRequest request) {
//		BoardDTO dto = new BoardDTO();
//		int pg = Integer.parseInt(request.getParameter("pg"));
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		String subject = request.getParameter("subject");
//		String content = request.getParameter("content");
//		int sort =  Integer.parseInt(request.getParameter("sort"));
//		int parent = Integer.parseInt(request.getParameter("parent"));
//		int tab = Integer.parseInt(request.getParameter("tab"));
//		
//		dto.setName(name);
//		dto.setEmail(email);
//		dto.setPwd(pwd);
//		dto.setSubject(subject);
//		dto.setContent(content);
//		dto.setSort(sort);
//		dto.setParent(parent);
//		dto.setTab(tab);
////		dto.setSort(dto.getSort() + 1);
////		dto.setTab(dto.getTab() + 1);
////		System.out.println("1 " + dto.getSort() + "2 " + dto.getTab() + "3 " + pg);
//		System.out.println("pg : " + pg + ", " + name + ", " + email+ ", " +pwd+ ", " +subject+ ", " +content+ ", " +sort+ ", " +parent+ ", " +tab);
//		
//		boardService.insertReply(dto);
//		return "redirect:/list.htm?pg="+pg ;
//	}
	
	@RequestMapping("/reply.htm")
	public String reply(BoardDTO dto, int pg) {
		boardService.insertReply(dto);
		return "redirect:/list.htm?pg="+pg ;
	}
	
	
}
