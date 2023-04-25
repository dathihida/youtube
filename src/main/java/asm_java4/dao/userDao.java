package asm_java4.dao;

import java.util.List;
import java.util.Map;

import asm_java4.enity.User;

public interface userDao {
	User findById(Integer id);
	
	User findByEmail(String email);
	
	User finByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
	
	List<User> findAll();
	List<User> findAll(int pageNumber, int pageSize);
	User create(User entity);
	User update(User entity);
	User delete(User entity);
	List<User> findUsersLikeByVideoHref(Map<String, Object> params);
}
