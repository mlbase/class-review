package mul.com.tc.service;

import java.util.List;

import mul.com.tc.dto.NoticeDto;

public interface NoticeService {

	List<NoticeDto> getNoticeList();
	
	Boolean NoticeWrite(NoticeDto dto);
	
	NoticeDto getNotice(int seq);
}
