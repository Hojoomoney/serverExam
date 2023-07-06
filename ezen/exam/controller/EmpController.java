package ezen.exam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import ezen.exam.service.EmpService;
import ezen.exam.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/emp/*")
@AllArgsConstructor
@Controller
public class EmpController {

	private EmpService service;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("eList", service.getList());
	}
	@GetMapping("/write")
	public void write() {
		log.info("write");

	}

	@PostMapping("/write")
	public String insert(EmpVO vo) {
		log.info("write");
		service.insert(vo);
		return "redirect:/emp/list";
	}

	@GetMapping("/read")
	public void read(@RequestParam("empno") Integer empno, Model model) {
		log.info("read");
		model.addAttribute("emp", service.read(empno));
	}
	
	@GetMapping(value="/remove")
	@ResponseBody
	public RedirectView delete(@RequestParam("empno") Integer empno) {
			service.delete(empno);
		return new RedirectView("/emp/list");
	}

}
