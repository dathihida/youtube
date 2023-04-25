package asm_java4.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


import asm_java4.common.SessionAttr;
import asm_java4.dao.userDao;
import asm_java4.enity.User;
import asm_java4.enity.Video;
import asm_java4.service.UserService;
import asm_java4.service.VideoService;
import asm_java4.service.impl.UserServiceImpl;
import asm_java4.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = {"/admin/user"}, name= "UserControllerOfAdmin")
public class UserController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5604079256125033543L;

	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		
		if(currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
			String action = req.getParameter("action");
			switch(action) {
			case "view":
				doGetOverView(req, resp);
				break;
			case "delete":
				doGetDelete(req, resp);
				break;
			case "edit":
				req.setAttribute("isEdit", true);
				doGetEdit(req, resp);
				break;
			}
		}else {
			resp.sendRedirect("index");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		
		if(currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
			String action = req.getParameter("action");
			switch(action) {
			case "edit":
				doPostEdit(req, resp);
				break;
			}
		}else {
			resp.sendRedirect("index");
		}
	}
	
	// /asm_java4/admin/video?action=view
	private void doGetOverView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> videos = userService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/user-overview.jsp").forward(req, resp);
	}
	// /asm_java4/admin/video?action=eidt&href={href}
	private void doGetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String href = req.getParameter("href");
//		Video video = videoService.findByHref(href);
		String username = req.getParameter("username");
		User user = userService.finByUsername(username);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/views/admin/user-edit.jsp").forward(req, resp);
	}
	// /asm_java4/admin/video?action=delete&href={href}
	private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/jsp");
//		String href = req.getParameter("href");
//		Video videoDeleted = videoService.delete(href);
		String username = req.getParameter("username");
		User userDelete = userService.delete(username);
		
		if (userDelete != null) {
			resp.setStatus(204);
		}else {
			resp.setStatus(400);
		}
	}
	
	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/jsp");
//		String title = req.getParameter("title");
//		String description = req.getParameter("description");
//		String href = req.getParameter("newHref");
//		String poster = req.getParameter("poster");
//		String hrefOrigin = req.getParameter("hrefOrigin");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String isAdmin = req.getParameter("isAdmin");
		
		System.out.print(username);
		System.out.print(password);
		System.out.print(email);
		System.out.print(isAdmin);
		
		User user = userService.finByUsername(username);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setIsAdmin(Boolean.TRUE);
		
		User userReturn = userService.update(user);
		
		if (userReturn != null) {
			resp.setStatus(204);
		}else {
			resp.setStatus(400);
		}
	}
}
