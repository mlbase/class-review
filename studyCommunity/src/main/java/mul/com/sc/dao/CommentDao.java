package mul.com.sc.dao;

import java.util.List;

import mul.com.sc.dto.CommentDto;

public interface CommentDao {

	
	boolean commentwrite(CommentDto com);
	
	List<CommentDto> getCommentList(CommentDto com);
	
	CommentDto getCommentDto(int seq);
	
	boolean commentupdate(CommentDto com);
	
	boolean commentdelete(int seq);
	
	boolean deleteAllComment(CommentDto com);
}
