package mul.com.sc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.sc.dao.RevBbsDao;
import mul.com.sc.dto.RevBbsDto;
import mul.com.sc.dto.RevBbsParam;

@Repository
public class RevBbsDaoImpl implements RevBbsDao{

	@Autowired
	SqlSession session;
	
	String ns = "RevBbs.";
	
	@Override
	public List<RevBbsDto> getReviewList(RevBbsParam param) {		
		return session.selectList(ns + "revbbs", param);
	}
	@Override
	public int getAllReview(RevBbsParam param) {		
		return session.selectOne(ns + "allreview", param);
	}
	
	@Override
	public boolean writeReview(RevBbsDto rbbs) {
		int n = session.insert(ns + "writeReview", rbbs);
		return n>0?true:false;
	}
	
	@Override
	public RevBbsDto getReview(int seq) {		
		return session.selectOne(ns + "getReview", seq);
	}
	@Override
	public void revreadcount(int seq) {
		session.update(ns + "revreadcount", seq);		
	}
	@Override
	public boolean updateReview(RevBbsDto rbbs) {
		int n = session.update(ns + "updateReview", rbbs);
		return n>0?true:false;
	}
	@Override
	public boolean deleteReview(RevBbsDto rbbs) {
		int n = session.delete(ns + "deleteReview", rbbs);
		return n>0?true:false;
	}
	@Override
	public List<RevBbsDto> getLatestRev() {
		return session.selectList(ns + "getLatestRev");
	}
		
	
}