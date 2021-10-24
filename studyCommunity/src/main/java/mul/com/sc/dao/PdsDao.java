package mul.com.sc.dao;

import java.util.List; 

import mul.com.sc.dto.PdsDto;
import mul.com.sc.dto.PdsParam;

public interface PdsDao {
	
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
