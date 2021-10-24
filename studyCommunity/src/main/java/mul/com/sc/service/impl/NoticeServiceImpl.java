package mul.com.sc.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.sc.dao.NoticeDao;
import mul.com.sc.dto.BbsParam;
import mul.com.sc.dto.NoticeDto;
import mul.com.sc.service.NoticeService;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao dao;
	
	@Override
	public List<NoticeDto> getNoticeList() {
		
		return dao.getNoticeList();
	}

	@Override
	public boolean NoticeWrite(NoticeDto dto) {
		
		return dao.NoticeWrite(dto);
	}

	@Override
	public NoticeDto getNotice(int seq) {
		// TODO Auto-generated method stub
		return dao.getNotice(seq);
	}

	@Override
	public boolean NoticeUpdate(NoticeDto dto) {
		// TODO Auto-generated method stub
		return dao.NoticeUpdate(dto);
	}

	@Override
	public boolean NoticeDelete(int seq) {
		// TODO Auto-generated method stub
		return dao.NoticeDelete(seq);
	}

	@Override
	public void NoticeCount(int seq) {
		// TODO Auto-generated method stub
		dao.NoticeCount(seq);
	}

	@Override
	public NoticeDto getLatestNotice() {
		return dao.getLatestNotice();
	}

	@Override
	public List<NoticeDto> getNoticePagingList(BbsParam param) {
		
		return dao.getNoticePagingList(param);
	}
	
	
	

	
}
