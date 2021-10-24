package mul.com.sc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import mul.com.sc.dto.RevBbsDto;
import mul.com.sc.dto.RevBbsParam;
import mul.com.sc.service.RevBbsService;
import mul.com.sc.util.ScUtil;

@Controller
public class RevBbsController {

	private static Logger logger = LoggerFactory.getLogger(RevBbsController.class);

	@Autowired
	RevBbsService service;

	@RequestMapping(value = "revbbs.do", method = RequestMethod.GET)
	public String revbbs(Model model, RevBbsParam param) {
		logger.info("RevBbsController revbbs() " + new Date());

		String content = "";
		
		// 현재 페이지
		int pageNumber = 0;
		if (param != null) { // 매개변수로 넘어 온 값이 있으면..
			pageNumber = param.getPageNumber();
		
			content = "revbbs";
		}
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("content", content);

		int start, end;
		start = 1 + 10 * pageNumber;
		end = 10 + 10 * pageNumber;

		param.setStart(start);
		param.setEnd(end);

		List<RevBbsDto> list = service.getReviewList(param);
		model.addAttribute("revbbs", list);

		model.addAttribute("choice", param.getChoice());
		model.addAttribute("search", param.getSearch());

		// 총 글의 수 갖고오기
		int allreview = service.getAllReview(param);
		
		// 총 페이지 수
		Integer bbsPage = allreview / 10; // 29 / 10 -> 2
		if ((allreview % 10) > 0) {
			bbsPage = bbsPage + 1;
		}
		model.addAttribute("bbsPage", bbsPage);

		// return "bbs/bbslist";
		return "base";
	}

	// 글쓰기로 가기 
	@RequestMapping(value = "revwrite.do", method = RequestMethod.GET)
	public String revwrite(Model model) {
		
		logger.info("RevBbsController revwrite() " + new Date());
		
		 String content = "";
		
		 content = "revwrite";
		
		model.addAttribute("content", content);
		return "base";
	}
	
	// 글쓰기와 업로드 작동
	@RequestMapping(value = "revwriteAf.do", method = RequestMethod.POST)
	public String revwriteAf(RevBbsDto rbbs,
							@RequestParam(value = "revfile", required = false)
										 MultipartFile revfile,
										 HttpServletRequest req) {
		
		
			String filename = revfile.getOriginalFilename();
			System.out.println(filename);
			
		
			String fupload = req.getServletContext().getRealPath("/upload");
		
			System.out.println("fupload:" + fupload);
		
			String newfilename = ScUtil.setNewFileName(filename);
			System.out.println("newfilename:" + newfilename);
		
		
		   rbbs.setFilename(newfilename);
		   
			
			  if (filename.equals("")) { rbbs.setFilename("");
			  	System.out.print(rbbs.getFilename());
			  
			  	service.writeReview(rbbs); 
			  	return "redirect:/revbbs.do"; 
			  	}
			 
		
		   File file = new File(fupload + "/" + newfilename); 
		
		try {
			// 폴더에 실제 업로드
			FileUtils.writeByteArrayToFile(file, revfile.getBytes());
			
			// DB에 저장
			service.writeReview(rbbs);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}		
				
		return "redirect:/revbbs.do";
	  		
		}

	// 디테일로 가기
	@RequestMapping(value = "revdetail.do", method = RequestMethod.GET)
	public String revdetail(int seq, Model model) {
		logger.info("RevBbsController revdetail() " + new Date());

		 String content = "";
			
		 content = "revdetail";
		
		 RevBbsDto rbbs = service.getReview(seq);
		 service.revreadcount(seq);
		model.addAttribute("rbbs", rbbs);

		model.addAttribute("content", "revdetail");
		return "base";
	}

	// 수정페이지로 가기
	@RequestMapping(value="revupdate.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String revupdate(int seq, Model model ) {
		logger.info("RevBbsController revupdate" + new Date());
	
		String content = "";
		
		content = "revupdate";
		
		RevBbsDto rbbs = service.getReview(seq);
		model.addAttribute("rbbs", rbbs);

		model.addAttribute("content", "revupdate");
		return "base";
	}
	
	
	 //수정작동
	@RequestMapping(value="revupdateAf.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String revupdateAf(Model model, RevBbsDto rbbs,
					@RequestParam(value = "revfile", required = false)
		 			MultipartFile revfile,
		 			HttpServletRequest req) {
		
		String filename = revfile.getOriginalFilename();
		System.out.println(filename);
		
	
		String fupload = req.getServletContext().getRealPath("/upload");
	
		System.out.println("fupload:" + fupload);
	
		String newfilename = ScUtil.setNewFileName(filename);
		System.out.println("newfilename:" + newfilename);
	
	
	   rbbs.setFilename(newfilename);
	   
		
		  if (filename.equals("")) { rbbs.setFilename("");
		  	System.out.print(rbbs.getFilename());
		  
		  	service.updateReview(rbbs); 
		  	return "redirect:/revbbs.do"; 
		  	}
		 
	
	   File file = new File(fupload + "/" + newfilename); 
	
	try {
		// 폴더에 실제 업로드
		FileUtils.writeByteArrayToFile(file, revfile.getBytes());
		
		// DB에 저장
		service.updateReview(rbbs);
		
	} catch (IOException e) {			
		e.printStackTrace();
	}		
			
	return "redirect:/revbbs.do";
  		
	}
	
	//삭제
	@RequestMapping(value="revdelete.do", method=RequestMethod.GET)
	public String revdelete(Model model, RevBbsDto dto) {
		logger.info("RevBbsController revdelete" + new Date());
		
		String message="";
		
		boolean b = service.deleteReview(dto);
		
		if(b) {
			message="글이 삭제되었습니다";
		} else {
			message="삭제에 실패하였습니다";
		}
		
		return "redirect:/revbbs.do?message="+message;
	}

	
   

	
}
