package mul.com.sc.controller;

import java.io.File;
import java.io.IOException;
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

import mul.com.sc.dto.BbsParam;
import mul.com.sc.dto.NoticeDto;
import mul.com.sc.dto.UserDto;
import mul.com.sc.service.NoticeService;
import mul.com.sc.util.ScUtil;



@Controller
public class NoticeController {

	private static Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	NoticeService service;
	
	@RequestMapping(value="noticelist.do", method={RequestMethod.POST,RequestMethod.GET})
	public String getNoticeList(Model model, BbsParam param) {
		logger.info("NoticeController noticelist.do" +new Date());
		
		List<NoticeDto> list = service.getNoticeList();
		int bbspage = list.size()/10;
		
		if(list.size()%10 > 0) {
			bbspage += 1;
		} else if(list.size()/10 < 1) {
			bbspage = 1;
		}
		

		int pageNum = 0;
		if(param != null) {	// 매개변수로 넘어 온 값이 있으면..  
			pageNum = param.getPageNumber();
		}
		
		 
		
		
		int start = (pageNum)*10 + 1;
		int end = (pageNum+1)*10;
		param.setStart(start);
		param.setEnd(end);
		//System.out.println(param.toString());
		List<NoticeDto> plist = service.getNoticePagingList(param);
		
		model.addAttribute("list",plist);
		model.addAttribute("pageNumber",param.getPageNumber());
		model.addAttribute("bbspage",bbspage);
		model.addAttribute("content", "noticeList");
		
		return "base";
	}
	
	@RequestMapping(value="noticewrite.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String Noticewrite(Model model, HttpSession session) {
		

		UserDto user = (UserDto)session.getAttribute("login");
		String msg = "다시 로그인 해주세요";
		model.addAttribute("msg", msg);
		
		
		if(user == null) {
			return "forward:noticelist.do";
		}
		String content = "noticewrite";
		model.addAttribute("content", content);
		System.out.println(content);
		return "base";
	}
	
	@RequestMapping(value="noticewriteAf.do", method={RequestMethod.POST,RequestMethod.GET})
	public String NoticewriteAf(NoticeDto notice, Model model,
			@RequestParam(value= "fileload", required = false)
			MultipartFile fileload,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(notice.getTitle().length() == 0) {
			return "forward:/noticelist.do";
		}
		String msg = "";
		
		String filenamex = fileload.getOriginalFilename();
		byte[] bytes = fileload.getBytes();
		String fupload = req.getServletContext().getRealPath("/upload/notice");
		
		//System.out.println("fupload:"+fupload);
		
		String filename = ScUtil.setNewFileName(filenamex);
		//System.out.println("filename:"+filename);
		//System.out.println(notice.toString());
		
		notice.setFilename(filename);
		
		boolean b = service.NoticeWrite(notice);
		  
		if(b) { msg = "작성성공"; File file = new File(fupload + "/" + filename);
		FileUtils.writeByteArrayToFile(file, fileload.getBytes()); } else { msg =
		"작성실패"; } System.out.println(msg);
		
		model.addAttribute("msg", msg);
		
		
		
		return "forward:/noticelist.do";
	}
	
	@RequestMapping(value="noticedetail.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String Noticedetail(int seq, Model model, HttpSession session, HttpServletRequest req) {
		
		UserDto user = (UserDto)session.getAttribute("login");
		
		
		if(user == null) {
			String msg = "다시 로그인 해주세요";
			model.addAttribute("msg", msg);
			return "forward:/noticelist.do";
		}
		
		service.NoticeCount(seq);
		NoticeDto notice = service.getNotice(seq);
		//System.out.println(notice.toString());
		model.addAttribute("notice",notice);
		model.addAttribute("content","noticedetail");
		
		return "base";
	}
	
	@RequestMapping(value="noticeupdate.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String Noticeupdate(Model model, HttpServletRequest req) {
		
		int seq = Integer.parseInt(req.getParameter("seq"));
		NoticeDto notice = service.getNotice(seq);
		
		model.addAttribute("notice", notice);
		model.addAttribute("seq",seq);
		model.addAttribute("content","noticeupdate");
		
		return "base";
	}
	
	@RequestMapping(value="noticeupdateAf.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String NoticeupdateAf(Model model, 
			@RequestParam(value= "fileload", required = false) MultipartFile fileload, 
			HttpServletRequest req, HttpServletResponse resp, int seq) throws IOException{
		
		String msg = "";
		System.out.println(seq);
		NoticeDto notice = service.getNotice(seq);
		
		String filenamex = fileload.getOriginalFilename();
		byte[] bytes = fileload.getBytes();
		String fupload = req.getServletContext().getRealPath("/upload/notice");
		
		System.out.println("fupload:"+fupload);
		
		String filename = ScUtil.setNewFileName(filenamex);
		
		System.out.println(notice.toString());
		
		File file = new File(fupload + "/" + filename);
		
		
		try {
			//폴더에 실제 업로드
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			//db에 저장
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		String title = (String)req.getParameter("title");
		String content = (String)req.getParameter("content");
		
		
		
		
		notice.setTitle(title);
		notice.setContent(content);
		notice.setFilename(filename);
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
	public String NoticeDelete(Model model, HttpServletRequest req) {
		
		String msg;
		
		int seq = Integer.parseInt(req.getParameter("seq"));
		
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
