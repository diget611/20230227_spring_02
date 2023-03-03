package kh.spring.s02.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.s02.member.model.service.MemberService;
import kh.spring.s02.member.model.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/signup")
	public ModelAndView viewInsert(ModelAndView mv) {
		return mv;
	}
	
//	@PostMapping("/signup")
	@GetMapping("/signupTest")
	public ModelAndView insert(ModelAndView mv, MemberVo vo) {
		vo.setId("idddd");
		vo.setPasswd("passsss");
		vo.setName("nameeee");
		vo.setEmail("emaillll");
		
		service.insert(vo);
		
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView viewUpdate(ModelAndView mv) {
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(ModelAndView mv, MemberVo vo) {
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView mv, String id) {
		return mv;
	}
	
	@GetMapping("/info")
	public ModelAndView selectOne(ModelAndView mv, String id) {
		return mv;
	}
	
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv) {
		return mv;
	}
}
