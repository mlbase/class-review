package mul.com.tc.controller;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mul.com.tc.dto.NoticeDto;
import mul.com.tc.dto.UserDto;
import mul.com.tc.service.NoticeService;
import mul.com.tc.util.PdsUtil;


@Controller
public class NoticeController {

	private static Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	NoticeService service;
	
	@RequestMapping(value="noticelist.do", method={RequestMethod.POST,RequestMethod.GET})
	public String getNoticeList(Model model) {
		logger.info("NoticeController noticelist.do" +new Date());
		
		List<NoticeDto> list = service.getNoticeList();
		
		model.addAttribute("list", list);
		
		return "notice/noticelist";
	}
	
	@RequestMapping(value="noticewrite.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String Noticewrite(Model model, HttpSession session) {
		
		UserDto user = (UserDto)session.getAttribute("login");
		String msg = "다시 로그인 해주세요";
		model.addAttribute("msg", msg);
		
		if(user == null) {
			
			return "forward:noticelist.do";
		}
		
		
		return "notice/noticewrite";
	}
	
	@RequestMapping(value="noticewriteAf.do", method={RequestMethod.POST,RequestMethod.GET})
	public String NoticewriteAf(NoticeDto notice, Model model,
			@RequestParam(value= "fileload", required = false)
			MultipartFile fileload,
			HttpServletRequest req) {
		String msg = "";
		
		String filenamex = fileload.getOriginalFilename();
		//System.out.println(filenamex);
		String fupload = req.getServletContext().getRealPath("/image_notice");
		
		//System.out.println("fupload:"+fupload);
		
		String filename = PdsUtil.setNewFileName(filenamex);
		//System.out.println("filename:"+filename);
		System.out.println(notice.toString());
		
		notice.setFilename(filename);
		
		boolean b = service.NoticeWrite(notice);
		
		if(b) {
			msg = "작성성공";
		} else {
			msg = "작성실패";
		}
		System.out.println(msg);
		model.addAttribute("msg", msg);
		
		return "forward:/noticelist.do";
	}
	
	@RequestMapping(value="noticedetail.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String Noticedetail(Model model, HttpSession session, HttpServletRequest req) {
		
		UserDto user = (UserDto)session.getAttribute("login");
		
		
		if(user == null) {
			String msg = "다시 로그인 해주세요";
			model.addAttribute("msg", msg);
			return "forward:/noticelist.do";
		}
		
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		NoticeDto notice = service.getNotice(seq);
		
		model.addAttribute("notice",notice);
		
		return "notice/noticedetail";
	}
}
