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
import mul.com.sc.dto.BbsParam;
import mul.com.sc.service.BbsService;

@Controller
public class BbsController {
	
	private static Logger logger = LoggerFactory.getLogger(BbsController.class);

	@Autowired
	BbsService service;
	
	@RequestMapping(value = "bbslist.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String bbslist(Model model, BbsParam param) {
		logger.info("MemberController bbslist()" + new Date());

		int pageNumber = 0;
		if(param != null) {	// 매개변수로 넘어 온 값이 있으면..  
			pageNumber = param.getPageNumber();
		}
		model.addAttribute("pageNumber", pageNumber);
		
		int start, end;
		start = 1 + 10 * pageNumber;
		end = 10 + 10 * pageNumber;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDto> list = service.getBbslist(param);
		model.addAttribute("bbslist", list);
		
		model.addAttribute("choice", param.getChoice());
		model.addAttribute("search", param.getSearch());
		
		// 총 글의 수 갖고오기
		int allbbs = service.getAllBbs(param);
		// 총 페이지 수
		int bbsPage = allbbs / 10;		// 29 / 10 -> 2
		if((allbbs % 10) > 0){
			bbsPage = bbsPage + 1;
		}
		if(allbbs / 10 < 1) {
			bbsPage = 1;
		}
		
		model.addAttribute("bbsPage", bbsPage);
		model.addAttribute("content", "bbsList");
		
		return "base";
	}
	@RequestMapping(value = "bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(int seq, Model model) {
		logger.info("MemberController bbsdetail()" + new Date());
		
		BbsDto bbs = service.getBbs(seq);
		service.readCount(seq);
		
		model.addAttribute("bbs", bbs);
		model.addAttribute("content", "bbsdetail");
		return "base";
	}
	
	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite(Model model) {
		logger.info("BbsController bbswrite() " + new Date());
		
		model.addAttribute("content", "bbswrite");
		return "base";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto dto, Model model) {
		
		boolean b = service.writeBbs(dto);
		String msg = "";
		
		if(b) {
			msg = "작성성공";
		} else {
			msg = "작성실패";
		}
		
		model.addAttribute("msg", msg);
		return "forward:/bbslist.do";
	}
	@RequestMapping(value = "bbsupdate.do", method = RequestMethod.GET)
	public String bbsupdate(int seq, Model model) {
		logger.info("BbsController bbsupdate() " + new Date());
		
		BbsDto bbs = service.getBbs(seq);
		
		model.addAttribute("bbs", bbs);
		model.addAttribute("content", "bbsupdate");
		return "base";
	}
	@RequestMapping(value = "bbsupdateAf.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String bbsupdateAf(BbsDto bbs, Model model) {
		logger.info("BbsController bbsupdateAf() " + new Date());
		
		boolean b = service.updateBbs(bbs);
		String msg = "";
		if(b) {
			msg="수정성공";
		} else {
			msg="수정실패";
		}
		
		model.addAttribute("msg", msg);
		
		return "forward:/bbslist.do";
	}
	@RequestMapping(value = "bbsdelete.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String bbsdelete(int seq, Model model) {
		logger.info("BbsController bbsdelete() " + new Date());
		
		boolean b = service.deleteBbs(seq);
		String msg = "";
		if(b) {
			msg = "삭제성공";
		} else {
			msg= "삭제실패";
		}
		

		model.addAttribute("msg", msg);
		
		return "forward:/bbslist.do";
	}
}
