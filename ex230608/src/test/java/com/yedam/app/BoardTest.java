package com.yedam.app;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class BoardTest {
	@Autowired
	BoardMapper boardMapper;
	
	@Ignore
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("title2");
		vo.setContents("content2");
		vo.setWriter("bb");
		boardMapper.insertBoard(vo);
		
		System.out.println(vo);
	}
	@Ignore
	public void testSelectInfo() {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		
		System.out.println(boardMapper.selectBoardInfo(vo));
	}
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		
		boardMapper.updateBoard(vo);
	}
	@Ignore
	public void testDelete() {
		BoardVO vo = new BoardVO();
		boardMapper.deleteBoard(2);
	}
}
