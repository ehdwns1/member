package com.icia.mbpro.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbpro.dto.MEMBER;
import com.icia.mbpro.service.MService;

@Controller
public class MController {
	
	@Autowired
	private MService msvc;
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}
	
	// mJoinForm : 회원가입 페이지 요청
	@RequestMapping(value = "mJoinForm", method = RequestMethod.GET)
	public String mJoinForm() {

		return "M_Join";
	}
	
	// mJoin : 회원가입 
	@RequestMapping(value = "mJoin", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {
		System.out.println();
		System.out.println("========== 회원가입 메소드 ==========");
		System.out.println("1. controller member : " + member);
		
		mav = msvc.mJoin(member);
		System.out.println("5. controller mav : " + mav);
		
		return mav;
	}
	
	// mList : 회원 목록
	@RequestMapping(value = "mList", method = RequestMethod.GET)
	public ModelAndView mList() {
		
		mav = msvc.mList();
		
		return mav;
	}
	
	// mModiForm : 회원 수정 페이지 
	@RequestMapping(value = "mModiForm", method = RequestMethod.GET)
	public ModelAndView mModiForm(@RequestParam("memId") String memId) {

		mav = msvc.mModiForm(memId);
		
		return mav;
	}
	
	// mView : 회원 목록 상세보기 
	@RequestMapping(value = "mView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("memId") String memId) {
		
		mav = msvc.mView(memId);
		
		return mav;
	}
	
	// mModify : 회원 수정 
	@RequestMapping(value = "mModify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute MEMBER member) {
		
		mav = msvc.mModify(member);
		
		return mav;
	}
	
	// mDelete : 회원 삭제
	@RequestMapping(value = "mDelete", method = RequestMethod.GET)
	public ModelAndView mDelete(@RequestParam("memId") String memId) {
		
		mav = msvc.mDelete(memId);
		
		return mav;
	}
	
	// mLoginForm : 로그인 페이지 요청
	@RequestMapping(value = "mLoginForm", method = RequestMethod.GET)
	public String mLoginForm() {
		
		return "M_Login";
	}
	
	// mLogin : 로그인
	@RequestMapping(value="mLogin", method=RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute MEMBER member) {
		
		mav = msvc.mLogin(member);
		
		return mav;
	}
}
