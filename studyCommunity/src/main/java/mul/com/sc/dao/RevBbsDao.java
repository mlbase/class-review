package mul.com.sc.dao;

import java.util.List;

import mul.com.sc.dto.RevBbsDto;
import mul.com.sc.dto.RevBbsParam;

public interface RevBbsDao {

	List<RevBbsDto> getReviewList(RevBbsParam param);
	int getAllReview(RevBbsParam param);
	RevBbsDto getReview(int seq);
	
	boolean writeReview(RevBbsDto rbbs);
	void revreadcount(int seq);
	boolean updateReview(RevBbsDto rbbs);
	boolean deleteReview(RevBbsDto rbbs);
	List<RevBbsDto> getLatestRev();
}
