package asm_java4.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import asm_java4.enity.History;

public interface historyDao {
	
	List<History> findByUser(String username);
	List<History> findByUserAndIsLiked(String username);
	
	History findByUserIdAndVideoId(Integer userId, Integer videoId);
	History create(History entity);
	History update(History entity);
}
