package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

public interface BookMapper {
	// 전체 조회
	public List<BookVO> selectAllBook();
	
	// 단건 조회 - 도서번호 예측
	public int getBookNo();
	
	// 등록
	public int insertBookInfo(BookVO baordVO);
	
	// 대여 현황 조회
	public List<RentVO> selectAllRent();
}
