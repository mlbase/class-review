package mul.com.sc.service;

import java.util.List;

import mul.com.sc.dto.RevBbsDto;
import mul.com.sc.dto.RevBbsParam;

public interface RevBbsService {

	List<RevBbsDto> getReviewList(RevBbsParam param);
	int getAllReview(RevBbsParam param);
	void revreadcount(int seq);
	
	boolean writeReview(RevBbsDto rbbs);
	RevBbsDto getReview(int seq);
	boolean updateReview(RevBbsDto rbbs);
	boolean deleteReview(RevBbsDto rbbs);
	List<RevBbsDto> getLatestRev();
}
