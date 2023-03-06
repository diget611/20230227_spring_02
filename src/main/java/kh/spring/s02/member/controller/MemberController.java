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
		mv.setViewName("member/signup");
		return mv;
	}
	
	@PostMapping("/signup")
	public ModelAndView insert(ModelAndView mv, MemberVo vo, String id, String email) {
		int result = service.insert(vo);
		
		if(result > 0) {
			mv.setViewName("redirect:/?msg=성공");
		} else {
			mv.setViewName("redirect:signup");
		}
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView viewUpdate(ModelAndView mv, String id) {
		MemberVo vo = service.selectOne(id);
		mv.addObject("membervo", vo);
		mv.setViewName("member/update");
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(ModelAndView mv, MemberVo vo) {
		
		int result = service.update(vo);
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView mv) {
		String id = "idddd";
		int result = service.delete(id);
		return mv;
	}
	
	@GetMapping("/info")
	public ModelAndView selectOne(ModelAndView mv, String id) {
		if(id == null) {
			mv.setViewName("redirect:list");
			return mv;
		} else {
			mv.addObject("info", service.selectOne(id));
			mv.setViewName("member/info");
		}
		return mv;
	}
	
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv) {
		List<MemberVo> result = service.selectList();
		return mv;
	}
}
