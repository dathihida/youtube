package asm_java4.dao.impl;

import java.util.List;

import asm_java4.dao.abstractDao;
import asm_java4.dao.historyDao;
import asm_java4.enity.History;

public class historyDaoImpl extends abstractDao<History> implements historyDao{

	@Override
	public List<History> findByUser(String username) {
		// TODO Auto-generated method stub
		String sql = "select o from History o where o.user.username = ?0 and o.video.isActive = 1 ORDER BY o.viewDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		String sql = "select o from History o where o.user.username = ?0 and o.isLiked = 1 and o.video.isActive = 1 ORDER BY o.viewDate DESC";
				return super.findMany(History.class, sql, username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		String sql = "select o from History o where o.user.id = ?0 and o.video.id = ?1"
				+" and o.video.isActive = 1";
		return super.findOne(History.class, sql, userId, videoId);
	}

}
