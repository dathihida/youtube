package asm_java4.service.impl;

import java.util.List;

import asm_java4.dao.StatsDao;
import asm_java4.dao.impl.statsDaoImpl;
import asm_java4.dto.VideoLikedInfo;
import asm_java4.service.StatsService;

public class StatsServiceImpl implements StatsService{

	private StatsDao statsDao;
	
	public StatsServiceImpl() {
		statsDao = new statsDaoImpl();
	}
	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		
		return statsDao.findVideoLikedInfo();
	}

}
