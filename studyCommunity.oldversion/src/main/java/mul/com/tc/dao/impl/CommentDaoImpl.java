package mul.com.tc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.tc.dao.CommentDao;
import mul.com.tc.dto.CommentDto;
@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	SqlSession session;
	
	String ns = "Comment.";
	
	@Override
	public boolean commentwrite(CommentDto com) {
		
		int count = 0;
		
		count = session.update(ns+"writeComment", com);
		
		return count>0?true:false;
	}

	@Override
	public List<CommentDto> getCommentList(CommentDto com) {
		
		
		
		return session.selectList(ns+"commentList", com);
	}

	@Override
	public CommentDto getCommentDto(int seq) {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"getcomment", seq);
	}

	@Override
	public boolean commentupdate(CommentDto com) {
		int count = 0;
		
		count = session.update(ns+"updateComment", com);
		
		return count>0?true:false;
	}

	@Override
	public boolean commentdelete(int seq) {
		int count = 0;
		
		count = session.delete(ns+"deleteComment", seq);
		return count>0?true:false;
	}
	
	
	

}
