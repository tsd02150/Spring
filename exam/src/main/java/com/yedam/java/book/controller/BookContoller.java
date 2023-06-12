package com.yedam.java.book.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookContoller {

	@Autowired
	BookService bookService;
	
	// 전체 조회 페이지
	@GetMapping("/bookList")
	public String bookList(Model model) {
		model.addAttribute("bookList", bookService.getBookAllList());
		return "book/bookList";
	}
	
	// 등록 페이지
	@GetMapping("/bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookNo", bookService.getBookNo());
		return "book/bookInsert";
	}
	//등록 처리
	@PostMapping("/bookInsert")
	public String bookInsert(BookVO bookVO) {
		bookService.insertBookInfo(bookVO);
		return "redirect:bookList";
	}
	
	// 대여 현황 페이지
	@GetMapping("rentList")
	public String rentList(Model model) {
		model.addAttribute("rentList", bookService.getBookRentList());
		return "book/rentList";
	}
}
