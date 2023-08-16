package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.dao.BoardDAO;
import com.javassem.domain.BoardVO;

//@Controller
@RestController
public class BoardController {
	
	//select - GetMapping
	//insert - PostMapping
	//delete - DeleteMapping
	//update - PutMapping
	
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/getboard/{seq}")
	public BoardVO select_seq(@PathVariable int seq ) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardVO dto = dao.getBoard(vo);
		return dto;
	}
	
	@GetMapping("/getlist")
	public List<BoardVO> getList(){
		List list = dao.getBoardList();
		System.out.println(list);
		return list;
	}
	
	@PostMapping("/insert")
//		public void insert(@RequestParam String title, @RequestParam String content, @RequestParam String writer) {
	public void insert(@RequestBody BoardVO dto) {
		BoardVO vo = new BoardVO();
		vo.setTitle(dto.getTitle());
		vo.setContent(dto.getContent());
		vo.setWriter(dto.getWriter());
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
		dao.insertBoard(vo);
	}

	@DeleteMapping("/delete/{seq}")
	public void delete(@PathVariable int seq){
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		dao.deleteBoard(vo);
	}
	
	@PutMapping("/put")
//	public void put(@RequestParam String title, @RequestParam String content, @RequestParam int seq){
	public void put(@RequestBody BoardVO dto, @RequestParam int seq){
		BoardVO vo = new BoardVO();
		vo.setTitle(dto.getTitle());
		vo.setContent(dto.getContent());
		vo.setSeq(seq);
//		vo.setTitle(title);
//		vo.setContent(content);
		
		dao.updateBoard(vo);
	}
	
}
