package mul.com.sc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.sc.dao.NoticeDao;
import mul.com.sc.dto.BbsParam;
import mul.com.sc.dto.NoticeDto;


@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	SqlSession session;

	private String ns = "notice.";
	
	@Override
	public List<NoticeDto> getNoticeList() {
		List<NoticeDto> list = session.selectList(ns+"getlist");
		return list;
	}

	@Override
	public boolean NoticeWrite(NoticeDto dto) {
		int count = 0;
		
		count = session.insert(ns+"writenotice", dto);
		
		return count>0?true:false;
	}

	@Override
	public NoticeDto getNotice(int seq) {
		
		return session.selectOne(ns+"getnotice", seq);
	}

	@Override
	public boolean NoticeUpdate(NoticeDto dto) {
		int count = 0;
		
		count = session.update(ns+"updatenotice", dto);
		
		return count>0?true:false;
	}

	@Override
	public boolean NoticeDelete(int seq) {
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
	public NoticeDto getLatestNotice() {
		return session.selectOne(ns + "getLatestNotice");
	}
	
	
	@Override
	public List<NoticeDto> getNoticePagingList(BbsParam param) {
		
		return session.selectList(ns+"noticepaginglist", param);
	}
	
	
	
	
	
	
}
