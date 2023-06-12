package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(Model model,BoardVO vo) {
		model.addAttribute("board", boardService.getBoardInfo(vo));
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO vo) {
		System.out.println(vo);
		boardService.insertBoardInfo(vo);
		return "redirect:boardList";
	}

	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(Model model,BoardVO vo) {
		model.addAttribute("board",boardService.getBoardInfo(vo));
		return "board/boardUpdate";
	}
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String,Object> boardUpdate(BoardVO board) {
		System.out.println(board);
		Map<String,Object> map = new HashMap();
		if(boardService.updateBoardInfo(board)>0) {
			map.put("result", "success");
			map.put("boardInfo", boardService.getBoardInfo(board));
			return map;			
		}else {
			map.put("result", "fail");
			return map;
		}
		
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam(required = false, defaultValue = "0", name="bno") int boardNo) {
		boardService.deleteBoardInfo(boardNo);
		return "redirect:boardList";
	}

}
