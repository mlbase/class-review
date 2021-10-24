package mul.com.tc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.tc.dao.NoticeDao;
import mul.com.tc.dto.BbsParam;
import mul.com.tc.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	SqlSession session;

	private String ns = "notice.";
	
	@Override
	public List<NoticeDto> getNoticeList() {
		// TODO Auto-generated method stub
		List<NoticeDto> list = session.selectList(ns+"getlist");
		return list;
	}

	@Override
	public Boolean NoticeWrite(NoticeDto dto) {
		int count = 0;
		
		count = session.insert(ns+"writenotice", dto);
		
		return count>0?true:false;
	}

	@Override
	public NoticeDto getNotice(int seq) {
		
		return session.selectOne(ns+"getnotice", seq);
	}

	@Override
	public Boolean NoticeUpdate(NoticeDto dto) {
		int count = 0;
		
		count = session.update(ns+"updatenotice", dto);
		
		return count>0?true:false;
	}

	@Override
	public Boolean NoticeDelete(int seq) {
		int count = 0;
		
		count = session.delete(ns+"deletenotice", seq);
		
		return count>0?true:false;
	}

	@Override
	public void NoticeCount(int seq) {
		// TODO Auto-generated method stub
		session.update(ns+"readcountnotice", seq);
	}

	@Override
	public List<NoticeDto> getNoticePagingList(BbsParam param) {
		
		return session.selectList(ns+"noticepaginglist", param);
	}
	
	
	
	
	
	
	
	
	
}
