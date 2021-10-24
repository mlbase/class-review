package mul.com.sc.dao;

import java.util.List;

import mul.com.sc.dto.BbsDto;
import mul.com.sc.dto.BbsParam;

public interface BbsDao {
	
	List<BbsDto> getBbslist(BbsParam param);
	int getAllBbs(BbsParam param);
	BbsDto getBbs(int seq);
	void readCount(int seq);
	boolean writeBbs(BbsDto dto);
	boolean updateBbs(BbsDto dto);
	boolean deleteBbs(int seq);
	List<BbsDto> getLatestBbs();
}
