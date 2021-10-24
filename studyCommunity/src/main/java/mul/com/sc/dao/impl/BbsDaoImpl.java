package mul.com.sc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.sc.dao.BbsDao;
import mul.com.sc.dto.BbsDto;
import mul.com.sc.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao{

	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> getBbslist(BbsParam param) {
		return session.selectList(ns + "getBbslist", param);
	}

	@Override
	public int getAllBbs(BbsParam param) {
		return session.selectOne(ns + "getAllBbs", param);
	}

	@Override
	public BbsDto getBbs(int seq) {
		return session.selectOne(ns + "getBbs", seq);
	}

	@Override
	public void readCount(int seq) {
		session.update(ns + "readCount", seq);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		int n = session.insert(ns + "writeBbs", dto);
		return n>0?true:false;
	}

	@Override
	public boolean updateBbs(BbsDto dto) {
		int n = session.update(ns + "updateBbs", dto);
		return n>0?true:false;
	}

	@Override
	public boolean deleteBbs(int seq) {
		int n = session.delete(ns + "deleteBbs", seq);
		return n>0?true:false;
	}

	@Override
	public List<BbsDto> getLatestBbs() {
		return session.selectList(ns + "getLatestBbs");
	}
	
	
}
