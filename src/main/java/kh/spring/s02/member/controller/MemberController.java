package kh.spring.s02.member.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.s02.member.model.service.MemberService;
import kh.spring.s02.member.model.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/signup")
	public ModelAndView viewInsert(ModelAndView mv) throws Exception {
		mv.setViewName("member/signup");
		return mv;
	}
	
	@PostMapping("/signup")
	public ModelAndView insert(ModelAndView mv, MemberVo vo, RedirectAttributes rttr) throws Exception {
		System.out.println(vo);
		int result = -1;
//		try {
			result = service.insert(vo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		if(result > 0) {
//			방법 1 - 사용 x
//			mv.setViewName("redirect:/?msg=성공");
			
//			방법 2
//			mv.addObject("msg", "회원가입 성공");
//			mv.setViewName("error/errorFailure");
			
//			방법 3
			rttr.addFlashAttribute("msg", "회원가입 성공2");
			mv.setViewName("redirect:/");
		} else {
//			mv.addObject("msg", "회원가입 실패");
//			mv.setViewName("error/errorFailure");
			rttr.addFlashAttribute("msg", "회원가입 실패2");
			mv.setViewName("redirect:/member/signup");
		}
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView viewUpdate(ModelAndView mv
			// String id -> id라는 이름의 parameter 없어도 됨. 없는 경우 null 값
			// @RequestParam("id") String id -> id라는 이름의 parameter가 꼭 있어야 함. required = true가 기본값
			, @RequestParam("id") String id		// String id = request.getParameter("id");
//			, @RequestParam("aaa") int bbb		// String bbb = request.getParameter("aaa");
	/* , @RequestParam(name="ccc", required=false, defaultValue="100") int ccc */) throws Exception {
		MemberVo vo = service.selectOne(id);
		mv.addObject("membervo", vo);
		mv.setViewName("member/update");
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(ModelAndView mv, MemberVo vo) throws Exception {
		
		int result = service.update(vo);
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView mv, String id) throws Exception {
		int result = service.delete(id);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("/info")
	public ModelAndView selectOne(ModelAndView mv, String id) throws Exception {
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
	public ModelAndView selectList(ModelAndView mv) throws Exception {
		List<MemberVo> result = service.selectList();
		mv.addObject("memberlist", result);
		mv.setViewName("member/list");
		return mv;
	}
	
//	각각의 Exception에 대해 처리 가능
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView memberNullPointExceptionHandler(Exception e) {
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView memberNumberFormatExceptionHandler(Exception e) {
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView memberSqlExceptionHandler(Exception e) {
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
//	@ExceptionHandler
	@ExceptionHandler(Exception.class)
	public ModelAndView memberExceptionHandler(Exception e
			/* 오류발생함 ModelAndView mv */) {
		e.printStackTrace();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", e.getMessage() + "오류가 발생했습니다. 다시 시도해주세요.");
		mv.setViewName("error/error500");
		
		return mv;
	}
}
