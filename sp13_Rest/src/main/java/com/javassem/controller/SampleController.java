package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

@RestController
public class SampleController {
	
	
	//1.���ڿ� ��ȯ
	@GetMapping(value = "/getText", produces="text/plain; charset=UTF-8")
	public String getTest() {
		return "��Ʈ�ѷ����� ���¾��!";
	}
	
	//2.��ü ��ȯ
	@GetMapping(value="/getObject")
	public SampleVO getObject(Model model) {
		SampleVO vo = new SampleVO("�迬��", 33, "�츮�� ���� ����Ʈ �׽�Ʈ");
		model.addAttribute("vo", vo);
		return vo;
	}
	
	//3.����Ʈ ��ü ��ȯ
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		
		List list = new ArrayList();
		list.add(new SampleVO("�迬��", 33, "�츮�� ���� ����Ʈ �׽�Ʈ"));
		list.add(new SampleVO("����ȯ", 22, "��������"));
		list.add(new SampleVO("�������", 77, "�ѱ� â��"));
		
		return list;
	}
	
	//4.URL���� ���� ��� /sample/{category}/{no}
	@GetMapping(value = "/sample/{cate}/{cno}")
	public String[] getPath(@PathVariable String cate, @PathVariable Integer cno) {
		return new String[] {"ī�װ� : " + cate + ", ��ȣ : " + cno};
	}
	
	
	//5.POST  ���� /sample/{category}/{no}
	@PostMapping(value = "/sample/data")
	public SampleVO post(@RequestBody SampleVO vo) {
		System.out.println(vo);
		return vo;
	}
	
}
