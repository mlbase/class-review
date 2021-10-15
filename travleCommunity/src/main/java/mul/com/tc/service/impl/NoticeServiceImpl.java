package mul.com.tc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.tc.dao.NoticeDao;
import mul.com.tc.dto.NoticeDto;
import mul.com.tc.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao dao;
	
	@Override
	public List<NoticeDto> getNoticeList() {
		
		return dao.getNoticeList();
	}

	@Override
	public Boolean NoticeWrite(NoticeDto dto) {
		
		return dao.NoticeWrite(dto);
	}

	@Override
	public NoticeDto getNotice(int seq) {
		// TODO Auto-generated method stub
		return dao.getNotice(seq);
	}
	
	

	
}
