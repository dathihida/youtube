package asm_java4.dao.impl;

import java.util.List;

import asm_java4.dao.abstractDao;
import asm_java4.dao.videodDao;
import asm_java4.enity.History;
import asm_java4.enity.User;
import asm_java4.enity.Video;

public class videoDaoImpl extends abstractDao<Video> implements videodDao{

	@Override
	public Video findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM Video o WHERE o.href = ?0";
		
		return super.findOne(Video.class, sql, href);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}

	@Override
	public Video findByTitle(String title) {
		String sql = "select o from Video o where o.title=?0";
		return super.findOne(Video.class, sql, title);
	}

	@Override
	public List<Video> findByTitle_video(String title) {
		String sql = "SELECT o FROM Video o where o.title like ?0";
		return super.findMany(Video.class, sql, title);
	}

}
