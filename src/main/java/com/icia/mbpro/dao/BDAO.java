package com.icia.mbpro.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.icia.mbpro.dto.BOARD;

@Repository
public class BDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public int boWrite(BOARD board) {
		
		
		return sql.insert("Board.boWrite",board);
	}




}
