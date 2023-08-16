package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

//@RestController
//@RequestMapping("/sample")
public class SampleController {
	
	
	//1.���ڿ� ��ȯ
	@GetMapping(value = "/getText", produces="text/plain; charset=UTF-8")
	public String getTest() {
		return "��Ʈ�ѷ����� ���¾��!";
	}
	
	//2.��ü ��ȯ
	@GetMapping(value="/getObject")
	public SampleVO getObject(Model model) {
		SampleVO vo = new SampleVO("�迬��", 33, "�츮�� ���� ����Ʈ �׽�Ʈ","111","AAA");
		model.addAttribute("vo", vo);
		return vo;
	}
	
	//3.����Ʈ ��ü ��ȯ
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		
		List list = new ArrayList();
		list.add(new SampleVO("�迬��", 33, "�츮�� ���� ����Ʈ �׽�Ʈ","111","AAA"));
		list.add(new SampleVO("����ȯ", 22, "��������","111","AAA"));
		list.add(new SampleVO("�������", 77, "�ѱ� â��","111","AAA"));
		
		return list;
	}
	
	//4.URL���� ���� ��� /sample/{category}/{no}
	@GetMapping(value = "/sample/{cate}/{cno}")
	public String[] getPath(@PathVariable String cate, @PathVariable Integer cno) {
		return new String[] {"ī�װ� : " + cate + ", ��ȣ : " + cno};
	}
	
	//http://localhost:8080/controller/query-param?name=hitv&age=12&message=����Ƽ��
	@GetMapping(path="query-param") //@GetMapping("/query-param")
	public String queryParam(@RequestParam String name,
								@RequestParam String age,
								@RequestParam String message,
								@RequestParam String phoneNumber,
								@RequestParam String PINNUMBER) {
		System.out.println(name);
		System.out.println(age);
		System.out.println(message);
		return name +", " + age + ", " + message + ", " + phoneNumber + ", " + PINNUMBER ;
	}
	
	//http://localhost:8080/controller/query-param2?name=byetv&age=22&message=����Ƽ��
	@GetMapping(path="query-param2")
	public String queryParam2(SampleVO dto) { //��ü Ÿ������ �����Ҷ��� @RequestParam �Ⱦ���. �����͸� ����� ������ �����ϴ� ���
		System.out.println(dto.getMessage());
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(dto.getPhoneNumber());
		System.out.println(dto.getPINNUMBER());
		
		return dto.toString();
	}
	
	
	//5.POST  ���� /sample/{category}/{no}
	@PostMapping(value = "/sample/data")
	public SampleVO post(@RequestBody SampleVO vo) {
		System.out.println(vo);
//		System.out.println(vo.getMessage());
		System.out.println("Ȯ��");
		return vo;
	}
	
	@PostMapping("/post")
	public void postSample(@RequestBody Map<String, Object> vo) {
//		vo.entrySet().forEach(objEntry -> {
//			System.out.println("key : " + objEntry.getKey());
//			System.out.println("value : " + objEntry.getValue());
//		});
		
		vo.forEach( (key, value) -> {
			System.out.println("key : " + key);
			System.out.println("value : " + value);
		});
	}
	
	@DeleteMapping("/sample/delete/{name}") //http://localhost:8080/controller/sample/delete/{name}
	public void delete(@PathVariable String name){
		System.out.println(name);
	}
	
	@PutMapping("/sample/put-name/{name}")
	public SampleVO put(@RequestBody SampleVO dto, @PathVariable(name="name") String irum){
		System.out.println("irum : " + irum);
		System.out.println(dto.getMessage());
		System.out.println(dto.getPhoneNumber());
		System.out.println(dto.getPINNUMBER());
		return dto;
	}

}
