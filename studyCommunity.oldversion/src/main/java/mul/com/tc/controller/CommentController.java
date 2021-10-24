package mul.com.tc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.com.tc.dto.CommentDto;
import mul.com.tc.service.CommentService;

@Controller
public class CommentController {

	private static Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService service;
	
	@RequestMapping(value="commentwrite.do", method={RequestMethod.POST,RequestMethod.GET})
	public String CommentWrite(Model model, int seq) {
	
		
		model.addAttribute("seq",seq);
		
		
		return "notice/commentwrite";
	}
	
	
	
	@RequestMapping(value="commentwriteAf.do", method={RequestMethod.POST,RequestMethod.GET})
	public String CommentWriteAf(Model model, CommentDto com) {
		
		String msg = "";
		String[] bbsar = {"bbsdetail.do","pdsdetail.do","revbbsdetail.do","noticedetail.do"};
		long[] bbsar2 = {com.getBbsseq(), com.getPdsseq(), com.getReviewseq(),com.getNoticeseq()};
		
		int num = com.getBbschoice();
		model.addAttribute("seq", bbsar2[num-1]);
		System.out.println(bbsar2[num-1]);
		com.setSeq(1);
		System.out.println(com.toString());
		boolean b = service.commentwrite(com);
		if(b) {
			msg="댓글 작성 성공";
		} else {
			msg="댓글 작성 실패";
		}
		model.addAttribute("msg", msg);
		
		return "forward:/"+bbsar[num-1]+"?seq="+bbsar2[num-1];
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
	
	@RequestMapping(value="commentdelete.do", method={RequestMethod.POST,RequestMethod.GET})
	public String Commentdelete(Model model, int seq) {
		
		
		String[] bbsar = {"bbslist.do","pdslist.do","revbbslist.do","noticelist.do"};
		
		boolean b = service.commentdelete(seq);
		
		return "forward:/noticelist.do";
	}
}
