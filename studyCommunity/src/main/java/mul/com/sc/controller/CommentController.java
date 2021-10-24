package mul.com.sc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.com.sc.dto.CommentDto;
import mul.com.sc.service.CommentService;

@Controller
public class CommentController {

	
	private static Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService service;
	
	@ResponseBody
	@RequestMapping(value="getAllComment.do", method=RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String getAllComment(CommentDto dto) {
		JSONObject comments = new JSONObject();
		
		List<CommentDto> list = service.getCommentList(dto);
		comments.put("comments", list);
		
		return comments.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="commentWrite.do", method=RequestMethod.POST)
	public String CommentWrite(CommentDto com) {
		
		String result;
		
		boolean b = service.commentwrite(com);
		if(b) {
			result="YES";
		} else {
			result="NO";
		}
		
		return result;
	}
	
	@RequestMapping(value="commentupdate.do", method={RequestMethod.POST,RequestMethod.GET})
	public String Commentupdate(Model model, int seq, HttpSession session) {
		
		CommentDto com = service.getCommentDto(seq);
		
		
		
		model.addAttribute("com", com);
		
		return "comment/commentupdate";
	}
	
	@RequestMapping(value="commentupdateAf.do", method={RequestMethod.POST,RequestMethod.GET})
	public String CommentupdateAf(CommentDto com) {
		System.out.println(com.toString());
		
		String[] bbsar = {"bbslist.do","pdslist.do","revbbslist.do","noticelist.do"};
		long[] bbsar2 = {com.getBbsseq(), com.getPdsseq(), com.getReviewseq(),com.getNoticeseq()};
		
		int num = com.getBbschoice();
		
		boolean b = service.commentupdate(com);
		
		String msg="";
		if(b) {
			msg="댓글수정성공";
		} else {
			msg="댓글수정실패";
		}
		
		return "forward:/"+bbsar[num-1];
	}
	
	@RequestMapping(value="commentDelete.do", method={RequestMethod.POST,RequestMethod.GET})
	public String Commentdelete(int seq) {
		
		String result;
		boolean b = service.commentdelete(seq);
		if(b) {
			result = "YES";
		} else {
			result = "NO";
		}
		
		return result;
	}
	
	@RequestMapping(value="commentAllDelete.do", method={RequestMethod.POST,RequestMethod.GET})
	public String commentAllDelete(CommentDto com) {
		
		String result;
		
		boolean b = service.deleteAllComment(com);
		if(b) {
			result = "YES";
		} else {
			result = "NO";
		}
		
		return result;
	}
}
