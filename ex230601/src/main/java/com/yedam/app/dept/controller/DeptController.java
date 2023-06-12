package com.yedam.app.dept.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {
	 
	@Autowired
	DeptService deptService;
	
	// 경로 <-> 기능 (View)
	// 경로 + Method -> Unique
	
	// 조회 (데이터, 페이지) -> GET
	// 등록,수정,삭제 -> POST
	
	// 전체 조회 - 페이지
	@RequestMapping(value="deptList" , method=RequestMethod.GET)
	public String deptList(Model model, @RequestParam(required=false) String msg,HttpServletRequest request) {
		model.addAttribute("deptList", deptService.getAllDept());
		
		System.out.println("redirect : "+msg);
		Map<String,?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			System.out.println("department_id : "+flashMap.get("departmentId"));
		}
		return "dept/deptList";
	}
	
	// 단건 조회 - 페이지
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptVO deptVO,Model model) {
		DeptVO findDept = deptService.getDeptInfo(deptVO);
		model.addAttribute("dept",findDept);	
		return "dept/deptInfo";
	}
		
	// 등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsetFrom(Model model) {
		model.addAttribute("managers", deptService.getManager());
		model.addAttribute("locations", deptService.getlocation());
		return "dept/deptInsert";
	}
	
	// 등록 - 기능
	@PostMapping("deptInsert")
	public String deptInsert(DeptVO vo, RedirectAttributes rtt) {
		deptService.insertDeptInfo(vo);
		rtt.addFlashAttribute("departmentId",vo.getDepartmentId()); // 세션을 활용하여 경로에 붙지 않음
		rtt.addAttribute("msg","test"); //경로에 붙음
		return "redirect:deptList";
//		return "redirect:deptList?departmentId="+vo.getDepartmentId(); //경로에 붙음		
	}
	
	// 삭제 - 기능
	@PostMapping("deptDelete")
	public String deptDelete(DeptListVO list) {
		int result=deptService.deleteDeptList(list.getDeptList());
		return "redirect:deptList?msg="+result;
	}
	/*
	 * @GetMapping("deptDelete") 
	 * public String deptDelete(DeptVO vo) { 
	 * List<DeptVO> list = new ArrayList<>(); 
	 * list.add(vo); 
	 * deptService.deleteDeptList(list);
	 * return "redirect:deptList"; }
	 */	
	
	// 수정 - 페이지
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Model model,DeptVO vo) {
		model.addAttribute("dept", deptService.getDeptInfo(vo));
		model.addAttribute("managers", deptService.getManager());
		model.addAttribute("locations", deptService.getlocation());
		return "dept/deptUpdate";
	}
	
	// 수정 - 기능
	// @RequestBody : JSON 포맷을 사용하는 경우
	//				-> content-type:'application/json'
	@PostMapping("deptUpdate")
	public String deptUpdate(@RequestBody List<DeptVO> DeptVo, RedirectAttributes rtt) {
		Map<String,Object> map = deptService.updateDeptList(DeptVo);
		rtt.addFlashAttribute("updateRes",map);
		return "redirect:deptInfo?departmentId="+DeptVo.get(0).getDepartmentId();
	}
//	@PostMapping("deptUpdate")
//	@ResponseBody
//	public Map<String,Object> deptUpdate(@RequestBody List<DeptVO> DeptVo, RedirectAttributes rtt) {
//		return deptService.updateDeptList(DeptVo);
//	}
	
//	@PostMapping("deptUpdate")
//	@ResponseBody
//	public String deptUpdateText(@RequestBody List<DeptVO> DeptVo, RedirectAttributes rtt) {
//		Map<String,Object> map = deptService.updateDeptList(DeptVo);
//		return "success";
//	}
}
