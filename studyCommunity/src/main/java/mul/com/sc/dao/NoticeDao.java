package mul.com.sc.dao;

import java.util.List;

import mul.com.sc.dto.BbsParam;
import mul.com.sc.dto.NoticeDto;


public interface NoticeDao {

	List<NoticeDto> getNoticeList();
	
	boolean NoticeWrite(NoticeDto dto);
	
	NoticeDto getNotice(int seq);
	
	boolean NoticeUpdate(NoticeDto dto);
	
	boolean NoticeDelete(int seq);
	
	void NoticeCount(int seq);
	
	NoticeDto getLatestNotice();
	
	List<NoticeDto> getNoticePagingList(BbsParam param);
}
