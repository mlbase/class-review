package mul.com.tc.controller;

import java.io.File;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mul.com.tc.dto.BbsParam;
import mul.com.tc.dto.CommentDto;
import mul.com.tc.dto.NoticeDto;
import mul.com.tc.dto.UserDto;
import mul.com.tc.service.CommentService;
import mul.com.tc.service.NoticeService;
import mul.com.tc.util.PdsUtil;


@Controller
public class NoticeController {

	private static Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	NoticeService service;
	@Autowired
	CommentService cservice;
	
	
	@RequestMapping(value="noticelist.do", method={RequestMethod.POST,RequestMethod.GET})
	public String getNoticeList(Model model, BbsParam param) {
		logger.info("NoticeController noticelist.do" +new Date());
		
		List<NoticeDto> list = service.getNoticeList();
		int bbspage = list.size()/10;
		
		if(list.size()%10 !=0) {
			bbspage += 1;
		}
		
		if(param == null) {
			param.setPageNumber(0);
		}
		
		
		 
		int pageNum = param.getPageNumber()+1;
		
		int start = (pageNum-1)*10 + 1;
		int end = (pageNum)*10;
		param.setStart(start);
		param.setEnd(end);
		//System.out.println(param.toString());
		List<NoticeDto> plist = service.getNoticePagingList(param);
		//System.out.println(plist.toString());
		model.addAttribute("list",plist);
		model.addAttribute("pageNumber",param.getPageNumber());
		model.addAttribute("bbspage",bbspage);
		
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
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String msg = "";
		String filenamex = fileload.getOriginalFilename();
		byte[] bytes = fileload.getBytes();
		//System.out.println(filenamex);
		String fupload = req.getServletContext().getRealPath("/image_notice");
		
		System.out.println("fupload:"+fupload);
		
		String filename = PdsUtil.setNewFileName(filenamex);
		System.out.println("filename:"+filename);
		//System.out.println(notice.toString());
		
		notice.setFilename(filename);
		
		boolean b = service.NoticeWrite(notice);
		
		if(b) {
			msg = "작성성공";
			File file = new File(fupload + "/" + filename);
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
		} else {
			msg = "작성실패";
		}
		System.out.println(msg);
		
		model.addAttribute("msg", msg);
		
		
		
		return "forward:/noticelist.do";
	}
	
	@RequestMapping(value="noticedetail.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String Noticedetail(Model model, HttpSession session, int seq, String msg) {
		
		UserDto user = (UserDto)session.getAttribute("login");
		//System.out.println(msg);
		
		if(user == null) {
			msg = "다시 로그인 해주세요";
			model.addAttribute("msg", msg);
			return "forward:/noticelist.do";
		}
		
		
		service.NoticeCount(seq);
		NoticeDto notice = service.getNotice(seq);
		//System.out.println(notice.toString());
		model.addAttribute("notice",notice);
		//////////////////////////////////////여기서부터 댓글관련 컨트롤러
		CommentDto com = new CommentDto();
		com.setNoticeseq(seq);
		com.setBbschoice(4);
		//System.out.println(com.toString());
		List<CommentDto> list = cservice.getCommentList(com);
		//System.out.println(list);
		model.addAttribute("list", list);
		return "notice/noticedetail";
	}
	
	@RequestMapping(value="noticeupdate.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String Noticeupdate(Model model, int seq) {
		
		
		NoticeDto notice = service.getNotice(seq);
		
		model.addAttribute("notice", notice);
		model.addAttribute("seq",seq);
		
		
		return "notice/noticeupdate";
	}
	
	@RequestMapping(value="noticeupdateAf.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String NoticeupdateAf(Model model, HttpServletRequest req) {
		
		String msg = "";
		
		int seq = Integer.parseInt(req.getParameter("seq"));
		String title = (String)req.getParameter("title");
		String content = (String)req.getParameter("content");
		
		
		NoticeDto notice = service.getNotice(seq);
		
		notice.setTitle(title);
		notice.setContent(content);
		System.out.println(notice.toString());
		
		boolean b = service.NoticeUpdate(notice);
		
		if(b) {
			msg="수정성공";
		} else {
			msg="수정실패";
		}
		
		model.addAttribute("msg", msg);
		
		return "forward:/noticelist.do";
	}
	
	@RequestMapping(value="noticedelete.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String NoticeDelete(Model model, int seq) {
		
		String msg;
		
		boolean b = service.NoticeDelete(seq);
		
		if(b) {
			
			msg = "삭제성공";
		} else {
			msg= "삭제실패";
		}
		
		model.addAttribute("msg", msg);
		
		return "forward:/noticelist.do";
	}
}
