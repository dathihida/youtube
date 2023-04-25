package asm_java4.service;

import java.util.List;

import asm_java4.enity.History;
import asm_java4.enity.User;
import asm_java4.enity.Video;

public interface HistoryService {
	List<History> findByUser(String username);
	List<History> findByUserAndIsLiked(String username);
	
	History findByUserIdAndVideoId(Integer userId, Integer videoId);
	History create(User user, Video video);
	boolean updateLikeOrUnline(User user, String videoHref);
}
