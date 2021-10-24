package mul.com.sc.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.com.sc.dto.BbsDto;
import mul.com.sc.dto.NoticeDto;
import mul.com.sc.dto.PdsDto;
import mul.com.sc.dto.RevBbsDto;
import mul.com.sc.service.BbsService;
import mul.com.sc.service.NoticeService;
import mul.com.sc.service.PdsService;
import mul.com.sc.service.RevBbsService;
import mul.com.sc.service.UserService;

@Controller
public class MainController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	BbsService BbsService;
	
	@Autowired
	RevBbsService RevBbsService;
	
	@Autowired
	PdsService PdsService;
	
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public String main(Model model) {
		logger.info("UserController main()" + new Date());
		
		NoticeDto notice = noticeService.getLatestNotice();
		List<BbsDto> bbslist = BbsService.getLatestBbs();
		List<PdsDto> pdslist = PdsService.getLatestPds();
		List<RevBbsDto> revlist = RevBbsService.getLatestRev();
		String content = "main";
		
		model.addAttribute("content", content);
		
		model.addAttribute("bbslist", bbslist);
		model.addAttribute("pdslist", pdslist);
		model.addAttribute("revlist", revlist);
		model.addAttribute("notice", notice);
		return "base";
	}
}
