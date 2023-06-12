package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper bookMapper;

	// 전체 조회
	@Override
	public List<BookVO> getBookAllList() {
		return bookMapper.selectAllBook();
	}

	// 단건 조회 - 도서번호 예측
	@Override
	public int getBookNo() {
		return bookMapper.getBookNo();
	}

	// 등록
	@Override
	public int insertBookInfo(BookVO bookVO) {
		return bookMapper.insertBookInfo(bookVO);
	}

	// 대여 현황 조회
	@Override
	public List<RentVO> getBookRentList() {
		return bookMapper.selectAllRent();
	}	
}
