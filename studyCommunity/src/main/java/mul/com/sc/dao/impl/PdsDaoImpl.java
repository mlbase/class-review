package mul.com.sc.dao.impl;

import java.util.List;   

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.sc.dao.PdsDao;
import mul.com.sc.dto.PdsDto;
import mul.com.sc.dto.PdsParam;

@Repository
public class PdsDaoImpl implements PdsDao{
	
	@Autowired
	SqlSession session;
	
	String ns="Pds.";

	@Override
	public List<PdsDto> getPdsList(PdsParam param) {
		
		return session.selectList(ns + "pdslist",param );
	}
	
	@Override
	public int getAllPds(PdsParam param) {		
		return session.selectOne(ns + "allpds", param);
	}
	
	
	@Override
	public boolean uploadPds(PdsDto dto) {
		int n = session.insert(ns + "uploadPds", dto);
		return n>0?true:false;
	}
	
	@Override
	public PdsDto getPds(int seq) {
		return session.selectOne(ns + "getPds", seq);
	}

	@Override
	public void pdsreadcount(int seq) {
		session.update(ns+"pdsreadcount", seq);
	}
	
	@Override
	public Boolean updatePds(PdsDto dto) {
		int count = 0;
		
		count = session.update(ns+"updatePds", dto);
		
		return count>0?true:false;
	}
	@Override
	public Boolean deletePds(int seq) {
		int count = 0;
		
		count = session.delete(ns+"deletePds", seq);
		
		return count>0?true:false;
	}

	
	  @Override public void pdsdowncount(int seq) {
	  session.update(ns+"pdsdowncount", seq); }

	@Override
	public List<PdsDto> getLatestPds() {
		return session.selectList(ns + "getLatestPds");
	}
	 
	  

}
