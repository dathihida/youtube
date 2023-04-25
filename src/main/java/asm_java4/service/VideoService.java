package asm_java4.service;

import java.util.List;

import asm_java4.enity.User;
import asm_java4.enity.Video;

public interface VideoService {
	Video findById(Integer id);
	Video findByHref(String href);
	Video findByTitle(String title);
	List<Video> findAll();
	List<Video> findByTitle_video(String title);
	
	List<Video> findAll(int pageNumber, int pageSize);
	
	Video create(Video entity);
	Video update(Video entity);
	Video delete(String href);
	Video updateShare(String href);
}
