package asm_java4.service.impl;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import asm_java4.dao.videodDao;
import asm_java4.dao.impl.videoDaoImpl;
import asm_java4.enity.User;
import asm_java4.enity.Video;
import asm_java4.service.VideoService;

public class VideoServiceImpl implements VideoService{

	private videodDao dao;
	
	public VideoServiceImpl() {
		dao = new videoDaoImpl();
	}
	
	@Override
	public Video findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Video findByHref(String href) {
		// TODO Auto-generated method stub
		
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Video create(Video entity) {
		// TODO Auto-generated method stub
		entity.setIsActive(Boolean.TRUE);
		entity.setViews(0);
		entity.setShares(0);
		return dao.create(entity);
	}

	@Override
	public Video update(Video entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public Video delete(String href) {
		// TODO Auto-generated method stub
		Video entity = findByHref(href);
		entity.setIsActive(Boolean.FALSE);
		return dao.update(entity);
	}

	@Override
	public Video findByTitle(String title) {
		return dao.findByTitle(title);
	}

	@Override
	public Video updateShare(String href) {
		int i =0;
		Video entity = findByHref(href);
		entity.setShares(entity.getShares()+ i);
		return dao.update(entity);
	}

	@Override
	public List<Video> findByTitle_video(String title) {
		// TODO Auto-generated method stub
		return dao.findByTitle_video(title);
	}
}
