package com.icia.mbpro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbpro.dao.BDAO;
import com.icia.mbpro.dto.BOARD;

@Service
public class BService {
	
	@Autowired
	private BDAO bdao;
	
	private ModelAndView mav = new ModelAndView();
	



public ModelAndView boWrite(BOARD board) {
	int result = bdao.boWrite(board);

	if(result>0) {
		mav.setViewName("redirect:/boList");	
	} else {
		mav.setViewName("index");
	}
	
	return mav;
}



}