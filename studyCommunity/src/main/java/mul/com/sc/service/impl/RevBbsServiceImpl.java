package mul.com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.sc.dao.RevBbsDao;
import mul.com.sc.dto.PdsDto;
import mul.com.sc.dto.RevBbsDto;
import mul.com.sc.dto.RevBbsParam;
import mul.com.sc.service.RevBbsService;
import mul.com.sc.util.ScUtil;

@Service
public class RevBbsServiceImpl implements RevBbsService{

	@Autowired
	RevBbsDao dao;
	
	@Override
	public List<RevBbsDto> getReviewList(RevBbsParam param) {		
		return dao.getReviewList(param);
	}

	@Override
	public int getAllReview(RevBbsParam param) {		
		return dao.getAllReview(param);
	}

	
	@Override
	public void revreadcount(int seq) {
		dao.revreadcount(seq);
		
	}

	@Override
	public boolean writeReview(RevBbsDto rbbs) {		
		return dao.writeReview(rbbs);
	}

	@Override
	public RevBbsDto getReview(int seq) {
		dao.getReview(seq);
		return dao.getReview(seq);
	}

	@Override
	public boolean updateReview(RevBbsDto rbbs) {
		return dao.updateReview(rbbs);
	}

	@Override
	public boolean deleteReview(RevBbsDto rbbs) {
		return dao.deleteReview(rbbs);
	}

	@Override
	public List<RevBbsDto> getLatestRev() {
		List<RevBbsDto> list = dao.getLatestRev();
		for (RevBbsDto dto : list) {
			dto.setTitle(ScUtil.mainDot3(dto.getTitle()));
		}
		return list;
	}
	 
}


