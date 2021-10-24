package mul.com.tc.dao;

import java.util.List;

import mul.com.tc.dto.BbsParam;
import mul.com.tc.dto.NoticeDto;

public interface NoticeDao {

	List<NoticeDto> getNoticeList();
	
	Boolean NoticeWrite(NoticeDto dto);
	
	NoticeDto getNotice(int seq);
	
	Boolean NoticeUpdate(NoticeDto dto);
	
	Boolean NoticeDelete(int seq);
	
	void NoticeCount(int seq);
	
	List<NoticeDto> getNoticePagingList(BbsParam param);
}