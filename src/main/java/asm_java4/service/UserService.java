package asm_java4.service;

import java.util.List;
import java.util.Map;

import asm_java4.dto.UserDto;
import asm_java4.enity.User;

public interface UserService {

	User findById(Integer id);
	
	User findByEmail(String email);
	
	User finByUsername(String username);
	
	User login(String username, String password);
	
	User resetPassword(String email);
	User shareVideo(String email);
	List<User> findAll();
	List<User> findAll(int pageNumber, int pageSize);
	//dang ki
	User register(String username, String password, String email);
	
	User update(User entity);
	
	User delete(String username);
	List<UserDto> findUsersLikeByVideoHref(String href);
}
