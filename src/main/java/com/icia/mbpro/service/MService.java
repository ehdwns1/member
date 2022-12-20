package com.icia.mbpro.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbpro.dao.MDAO;
import com.icia.mbpro.dto.MEMBER;

@Service
public class MService {
	
	@Autowired
	private MDAO mdao;
	
	@Autowired
	private BCryptPasswordEncoder pwEnc;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;

	public ModelAndView mJoin(MEMBER member) throws IllegalStateException, IOException {
		System.out.println("2. service member : " + member);
		mav = new ModelAndView();
		
		// 1. 파일업로드
		MultipartFile memProfile = member.getMemProfile();
		UUID uuid = UUID.randomUUID();
		
		// 실제 업로드될 파일 이름
		String profileName = uuid.toString().substring(0, 8) + "_" + memProfile.getOriginalFilename();
		// 8자리의 랜덤 숫자 + 사진 이름 >> 파일 이름 정해줌
		
		// 파일 저장 경로
		String savePath = "C:\\Users\\user\\Desktop\\spring 2\\MBPRO\\src\\main\\webapp\\resources\\Profile\\";
		
		  if(!memProfile.isEmpty()) { 
			  member.setMemProfileName(profileName);
			  }
		  
		  // 2. 비밀번호 암호화
		  member.setMemPw(pwEnc.encode(member.getMemPw()));
		  
		  
		  int result = mdao.mJoin(member);
		  
		  if(result>0) {
			  memProfile.transferTo(new File(savePath+profileName));
			  mav.setViewName("index");
		  } else {
			  mav.setViewName("M_Join");
		  }
		 		
		return mav;
	}

	public ModelAndView mList() {
		mav = new ModelAndView();
		List<MEMBER> memberList = mdao.mList();
		
		mav.setViewName("M_List");
		mav.addObject("memberList",memberList);
		
		return mav;
	}

	public ModelAndView mView(String memId) {
		MEMBER member = mdao.mView(memId);
		
		mav.setViewName("M_View");
		mav.addObject("view", member);
		
		return mav;
	}

	public ModelAndView mModify(MEMBER member) {
		mav = new ModelAndView();
		
		int result = mdao.mModify(member);
		
		if(result>0) {
			mav.setViewName("redirect:/mList");
		} else {
			mav.setViewName("index");
		}
		
		return mav;
	}

	public ModelAndView mModiForm(String memId) {
		
		MEMBER member = mdao.mView(memId);
		
		mav.setViewName("M_Modify");
		mav.addObject("modify", member);
		
		return mav;
	}

	public ModelAndView mDelete(String memId) {
		
		int result = mdao.mDelete(memId);
		
		if(result>0) {
			mav.setViewName("redirect:/mList");
		} else {
			mav.setViewName("index");
		}
		
		return mav;
	}

	public ModelAndView mLogin(MEMBER member) {
		
			System.out.println("[2] service member : " + member);
			
			mav = new ModelAndView();
			// 우리가 입력한 정보 member(아이디, 비밀번호)에서 
			// DB에서 아이디를 기준으로 비밀번호를 조회한다.
			String dbPw = mdao.mLogin(member.getMemId());
			System.out.println("[4] service dbPw : " + dbPw);
			
			// DB에서 가져온 비밀번호(암호화 된 비밀번호)와 우리가 입력한 비밀번호를 매칭시킨다.
			if(dbPw != null) {
				// 비밀번호가 존재(아이디 존재)
				if(pwEnc.matches(member.getMemPw(), dbPw)) {
					// 입력한 비밀번호와 암호화 된 비밀번호가 일치할 경우
					System.out.println("비밀번호 일치");
					session.setAttribute("loginId", member.getMemId());
					mav.setViewName("index");
				} else {
					// 입력한 비밀번호와 암호화 된 비밀번호가 일치하지 않을 경우
					System.out.println("비밀번호 일치x");
					mav.setViewName("M_Login");
				}
				
				
			} else {
				// 아이디가 존재x
				System.out.println("################# 아이디 존재 x ######################");
				mav.setViewName("M_Login");
			}
			
		
		return mav;
	}

	

	

}
