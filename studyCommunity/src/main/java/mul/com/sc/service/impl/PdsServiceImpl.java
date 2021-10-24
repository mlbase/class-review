package mul.com.sc.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.sc.dao.PdsDao;
import mul.com.sc.dto.PdsDto;
import mul.com.sc.dto.PdsParam;
import mul.com.sc.service.PdsService;
import mul.com.sc.util.ScUtil;

@Service
public class PdsServiceImpl implements PdsService {

	@Autowired
	PdsDao dao;
	
	@Override
	public List<PdsDto> getPdsList(PdsParam param) {
		
		return dao.getPdsList(param);
	}

	@Override
	public int getAllPds(PdsParam param) {		
		return dao.getAllPds(param);
	}
	
	@Override
	public boolean uploadPds(PdsDto dto) {
		return dao.uploadPds(dto);
	}

	@Override
	public PdsDto getPds(int seq) {
		return dao.getPds(seq);
	}

	@Override
	public void pdsreadcount(int seq) {
		dao.pdsreadcount(seq);
	}

	@Override
	public Boolean updatePds(PdsDto dto) {
		return dao.updatePds(dto);
	}

	@Override
	public Boolean deletePds(int seq) {

		return dao.deletePds(seq);
	}

	
    @Override 
    public void pdsdowncount(int seq) {
    	dao.pdsdowncount(seq);
    }

	@Override
	public List<PdsDto> getLatestPds() {
		List<PdsDto> list = dao.getLatestPds();
		for (PdsDto dto : list) {
			dto.setTitle(ScUtil.mainDot3(dto.getTitle()));
		}
		return list;
	}
	 
	  

}
