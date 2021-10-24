package mul.com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.sc.dao.BbsDao;
import mul.com.sc.dto.BbsDto;
import mul.com.sc.dto.BbsParam;
import mul.com.sc.service.BbsService;
import mul.com.sc.util.ScUtil;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> getBbslist(BbsParam param) {
		return dao.getBbslist(param);
	}

	@Override
	public int getAllBbs(BbsParam param) {
		return dao.getAllBbs(param);
	}

	@Override
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	@Override
	public void readCount(int seq) {
		dao.readCount(seq);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		return dao.writeBbs(dto);
	}

	@Override
	public boolean updateBbs(BbsDto dto) {
		return dao.updateBbs(dto);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}

	@Override
	public List<BbsDto> getLatestBbs() {
		List<BbsDto> list = dao.getLatestBbs();
		for (BbsDto dto : list) {
			dto.setTitle(ScUtil.mainDot3(dto.getTitle()));
		}
		return list;
	}
	
	
}
