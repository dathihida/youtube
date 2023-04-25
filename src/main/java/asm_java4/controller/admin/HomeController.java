package asm_java4.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import asm_java4.common.SessionAttr;
import asm_java4.dto.UserDto;
import asm_java4.dto.VideoLikedInfo;
import asm_java4.enity.User;
import asm_java4.service.StatsService;
import asm_java4.service.UserService;
import asm_java4.service.impl.StatsServiceImpl;
import asm_java4.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin", "/admin/favorites"}, name = "HomeControllerOfAdmin")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2124304507602945614L;

	private StatsService statsService = new StatsServiceImpl();

	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);

		if (currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {

			String path = req.getServletPath();
			switch (path) {
			case "/admin":
				doGetHome(req, resp);
				break;
			case "/admin/favorites":
				doGetFavorites(req, resp);
				break;	
			}
		} else {
			resp.sendRedirect("index");
		}
	}

	private void doGetHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoLikedInfo> videos = statsService.findVideoLikedInfo();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
	}

	// localhost:8080/asm_java4/admin/favorite

	private void doGetFavorites(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String videoHref = req.getParameter("href");
		
		List<UserDto> user = userService.findUsersLikeByVideoHref(videoHref);
		
		if(user.isEmpty()) {
			resp.setStatus(400);
		}else {
			ObjectMapper mapper = new ObjectMapper();
			
			String dataResponse = mapper.writeValueAsString(user);
			
			resp.setStatus(200);
			out.print(dataResponse);
			out.flush();
		}
	}
}
