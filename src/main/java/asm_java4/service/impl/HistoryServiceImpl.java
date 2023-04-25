package asm_java4.service.impl;

import java.sql.Timestamp;
import java.util.List;

import asm_java4.dao.historyDao;
import asm_java4.dao.videodDao;
import asm_java4.dao.impl.historyDaoImpl;
import asm_java4.dao.impl.videoDaoImpl;
import asm_java4.enity.History;
import asm_java4.enity.User;
import asm_java4.enity.Video;
import asm_java4.service.HistoryService;
import asm_java4.service.VideoService;

public class HistoryServiceImpl implements HistoryService{

	private historyDao dao;
	
	private VideoService videoService = new VideoServiceImpl();
	
	public HistoryServiceImpl() {
		dao = new historyDaoImpl();
	}
	
	@Override
	public List<History> findByUser(String username) {
		// TODO Auto-generated method stub
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		// TODO Auto-generated method stub
		return dao.findByUserAndIsLiked(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		// TODO Auto-generated method stub
		History existhistory = findByUserIdAndVideoId(user.getId(), video.getId());
		if(existhistory == null) {
			existhistory = new History();
			existhistory.setUser(user);
			existhistory.setVideo(video);
			existhistory.setViewDate(new Timestamp(System.currentTimeMillis()));
			existhistory.setIsLiked(Boolean.FALSE);
			
			return dao.create(existhistory);
		}
		return existhistory;
	}

	@Override
	public boolean updateLikeOrUnline(User user, String videoHref) {
		
		Video video = videoService.findByHref(videoHref);
		History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());
		if(existHistory.getIsLiked() == Boolean.FALSE) {
			existHistory.setIsLiked(Boolean.TRUE);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		}else {
			existHistory.setIsLiked(Boolean.FALSE);
			existHistory.setLikedDate(null);
		}
		History updateHistory = dao.update(existHistory);
		
		return updateHistory != null ? true : false;
	}
}
