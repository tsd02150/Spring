package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result=-1;
		if(boardMapper.insertBoard(boardVO)>0) {
			result=boardVO.getBno();
		}
		return result;
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result=-1;
		if(boardMapper.updateBoard(boardVO)>0) {
			result=boardVO.getBno();
		}
		return result;
	}

	@Override
	public int deleteBoardInfo(int boardNo) {
		int result=-1;
		if(boardMapper.deleteBoard(boardNo)>0) {
			result=boardNo;
		}
		return result;
	}

}
