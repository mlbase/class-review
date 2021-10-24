package mul.com.sc.service;

import java.util.List;

import mul.com.sc.dto.PdsDto;
import mul.com.sc.dto.PdsParam;

public interface PdsService {

	List<PdsDto> getPdsList(PdsParam param);
	int getAllPds(PdsParam param);
	
	boolean uploadPds(PdsDto dto);
	PdsDto getPds(int seq);
	
	void pdsreadcount(int seq);
	void pdsdowncount(int seq); 
	
	Boolean updatePds(PdsDto dto);
	Boolean deletePds(int seq);
	List<PdsDto> getLatestPds();
}
