package mul.com.sc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import mul.com.sc.dto.PdsDto;
import mul.com.sc.dto.PdsParam;
import mul.com.sc.dto.UserDto;
import mul.com.sc.service.PdsService;
import mul.com.sc.util.ScUtil;

/**
 * Handles requests for the application home page.
 */ 
@Controller
public class PdsController {

	private static Logger logger = LoggerFactory.getLogger(PdsController.class);
	
	@Autowired
	PdsService service;
	
	@RequestMapping(value="pdslist.do", method = RequestMethod.GET)
	public String pdslist(Model model, PdsParam param) {
		logger.info("PdsController pdslist" + new Date());
		
		// 현재 페이지
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
		
		List<PdsDto> list = service.getPdsList(param);
		model.addAttribute("pdslist",list);
		
		model.addAttribute("choice", param.getChoice());
		model.addAttribute("search", param.getSearch());
		
		// 총 글의 수 갖고오기
		int allpds = service.getAllPds(param);
		// 총 페이지 수
		Integer pdsPage = allpds / 10;		// 29 / 10 -> 2
		if((allpds % 10) > 0){
			pdsPage = pdsPage + 1;
		}
		model.addAttribute("pdsPage", pdsPage);
		model.addAttribute("content", "pdslist");
		
		return "base";
	}

	
	@RequestMapping(value="pdswrite.do", method= RequestMethod.GET)
	public String pdswrite(Model model, HttpSession session) {
		logger.info("PdsController pdswrite" + new Date());
		
		UserDto user = (UserDto)session.getAttribute("login");
		
		
		if(user == null) {
			String msg = "다시 로그인 해주세요";
			model.addAttribute("msg", msg);
			return "forward:pdslist.do";
		}
		model.addAttribute("content", "pdswrite");
		return "base";
	}
	
	@RequestMapping(value = "pdsupload.do", method = RequestMethod.POST)
	public String pdsupload(PdsDto pdsdto,
								@RequestParam(value="fileload", required = false)
								MultipartFile fileload,
								HttpServletRequest req) {
		
		
		// filename(원본)취득
		String filename = fileload.getOriginalFilename();
		
		// upload 경로설정
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 파일명이 충돌되지 않도록 파일명을 변경
		String newfilename = ScUtil.setNewFileName(filename);
		
		pdsdto.setFilename(filename);
		pdsdto.setNewfilename(newfilename);
		
		File file = new File(fupload + "/" + newfilename); 
		
		try {
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			service.uploadPds(pdsdto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value = "pdsdetail.do", method = RequestMethod.GET)
	public String pdsdetail(int seq, Model model) {
		logger.info("PdsController pdsdetail " + new Date());
		
		PdsDto pds = service.getPds(seq);
		service.pdsreadcount(seq); 
		model.addAttribute("pds", pds);
		model.addAttribute("content", "pdsdetail");
		
		return "base";
	}
	
	@RequestMapping(value = "fileDownload.do", method = RequestMethod.GET)
	public String fileDownload(String newfilename, String filename, int seq, 
								Model model, HttpServletRequest req) {		
		// 경로
		// server
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
		File downloadFile = new File(fupload + "/" + newfilename); 
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("filename", filename);
		model.addAttribute("seq", seq);
		
		return "downloadView";
	}
	
	@RequestMapping(value = "pdsupdate.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String pdsupdate(Model model, HttpServletRequest req) {
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		PdsDto pds = service.getPds(seq);
		model.addAttribute("pds",pds);
		model.addAttribute("content", "pdsupdate");
		
		return "base";
	}
	
	@RequestMapping(value="pdsupdateAf.do",method = {RequestMethod.POST,RequestMethod.GET})
	public String updatePds(Model model, PdsDto dto,
								@RequestParam(value = "fileload", required = false)
								MultipartFile fileload,
								HttpServletRequest req) {
		logger.info("PdsController pdsupdateAf " + new Date());

		String filename = fileload.getOriginalFilename();
		
		String fupload = req.getServletContext().getRealPath("/upload");
		
		String newfilename = ScUtil.setNewFileName(filename);
		
		dto.setNewfilename(newfilename);
		File file = new File(fupload + "/" + newfilename); 
	
			try {
				// 폴더에 실제 업로드
				FileUtils.writeByteArrayToFile(file, fileload.getBytes());
				
				// DB에 저장
				service.updatePds(dto);
				
			} catch (IOException e) {			
				e.printStackTrace();
			}		
					
			return "redirect:/pdslist.do";	
			}
			
	
	@RequestMapping(value = "pdsdelete.do",method=RequestMethod.GET)
	public String deletePds(Model model, HttpServletRequest req) {
		logger.info("PdsController pdsdelete " + new Date());
		
		String message;
		int seq = Integer.parseInt(req.getParameter("seq"));
		boolean b = service.deletePds(seq);
		
		if (b) {
			message= "삭제되었습니다.";
		}else {	
			message="삭제되지 않았습니다.";
		}
		
		model.addAttribute("message", message);
		return "redirect:/pdslist.do?message="+message;
	}

	
}
