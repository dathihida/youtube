package asm_java4.dao;

import java.util.List;

import asm_java4.enity.User;
import asm_java4.enity.Video;

public interface videodDao {
	Video findById(Integer id);
	Video findByHref(String href);
	Video findByTitle(String title);
	List<Video> findAll();
	List<Video> findByTitle_video(String title);
	
	List<Video> findAll(int pageNumber, int pageSize);
	
	Video create(Video entity);
	Video update(Video entity);
	Video delete(Video entity);
}
