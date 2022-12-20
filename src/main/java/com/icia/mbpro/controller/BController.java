package com.icia.mbpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbpro.dto.BOARD;
import com.icia.mbpro.service.BService;

@Controller
public class BController {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BService bsvc;
	
	// boWriteForm : 게시글 작성 페이지 요청
		@RequestMapping(value = "/boWriteForm", method = RequestMethod.GET)
		public String boWriteForm() {
			return "B_Write";
		}
		
	// boWrite : 게시글 작성
		@RequestMapping(value = "boWrite", method = RequestMethod.POST)
		public ModelAndView boWrite(@ModelAttribute BOARD board) {
			
			mav = bsvc.boWrite(board);
			
			return mav;
		}

}
