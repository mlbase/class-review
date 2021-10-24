package mul.com.tc.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.tc.dao.CommentDao;
import mul.com.tc.dto.CommentDto;
import mul.com.tc.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao dao;
	
	@Override
	public boolean commentwrite(CommentDto com) {
		// TODO Auto-generated method stub
		return dao.commentwrite(com);
	}

	@Override
	public List<CommentDto> getCommentList(CommentDto com) {
		// TODO Auto-generated method stub
		return dao.getCommentList(com);
	}

	@Override
	public CommentDto getCommentDto(int seq) {
		// TODO Auto-generated method stub
		return dao.getCommentDto(seq);
	}

	@Override
	public boolean commentupdate(CommentDto com) {
		// TODO Auto-generated method stub
		return dao.commentupdate(com);
	}

	@Override
	public boolean commentdelete(int seq) {
		
		return dao.commentdelete(seq);
	}
	
	

	
	
}
