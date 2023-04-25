package asm_java4.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import asm_java4.common.NameStored;
import asm_java4.dao.abstractDao;
import asm_java4.dao.userDao;
import asm_java4.enity.User;
import asm_java4.uitl.JpaUtil;

public class userDaoImpl extends abstractDao<User> implements userDao{

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select o from User o where o.email=?0";
		
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User finByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select o from User o where o.username=?0";
		
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select o from User o where o.username=?0 and o.password = ?1";
		
		return super.findOne(User.class, sql, username, password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true, pageNumber, pageSize);
	}

	@Override
	public List<User> findUsersLikeByVideoHref(Map<String, Object> params) {
		return super.callStored(NameStored.FIND_USER_LIKED_VIDEO_BY_VIDEO_HREF, params);
	}
}
