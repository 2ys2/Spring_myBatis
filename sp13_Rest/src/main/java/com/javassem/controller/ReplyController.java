package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyServiceImpl;

@RestController
@RequestMapping("/re")
public class ReplyController {

	@Autowired
	ReplyServiceImpl replyService;
	
//	@PostMapping("/insertreply")
//	public ReplyVO insertReply(@RequestBody ReplyVO vo) {
//		ReplyVO dto = new ReplyVO();
//		dto.setBno(vo.getBno());
//		dto.setReply(vo.getReply());
//		dto.setReplyer(vo.getReplyer());
//		
//		replyService.insertReply(dto);
//	}
	
	@PostMapping("/insertreply")
	public void insertReply(@RequestBody ReplyVO vo) {
		replyService.insertReply(vo);
	}
	
	@GetMapping("/getreply")
	public List<ReplyVO> selectAllReply() {
		List<ReplyVO> list = replyService.selectAllReply();
		return list;
	}
	
	@DeleteMapping("/deletereply")
	public void deleteReply(@RequestParam String rno) {
		replyService.deleteReply(rno);
	}
}
