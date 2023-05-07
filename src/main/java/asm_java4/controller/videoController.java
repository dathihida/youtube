package asm_java4.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm_java4.common.SessionAttr;
import asm_java4.dao.historyDao;
import asm_java4.dao.impl.historyDaoImpl;
import asm_java4.enity.History;
import asm_java4.enity.User;
import asm_java4.enity.Video;
import asm_java4.service.EmailService;
import asm_java4.service.HistoryService;
import asm_java4.service.UserService;
import asm_java4.service.VideoService;
import asm_java4.service.impl.EmailServletImpl;
import asm_java4.service.impl.HistoryServiceImpl;
import asm_java4.service.impl.UserServiceImpl;
import asm_java4.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = "/video")
public class videoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7398695357724016147L;

	private VideoService videoService = new VideoServiceImpl();

	private HistoryService historyService = new HistoryServiceImpl();
	private UserService userService = new UserServiceImpl();
	private EmailService emailService = new EmailServletImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionParam = req.getParameter("action");
		String href = req.getParameter("id");

		HttpSession session = req.getSession();

		switch (actionParam) {
		case "watch":
			doGetWatch(session, href, req, resp);
			break;
		case "like":
			doGetLike(session, href, req, resp);
			break;
		/*
		 * case "share": doGetShare(session, href, req, resp); break;
		 */
		}
	}

	private void doGetWatch(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub;
		Video video = videoService.findByHref(href);
		Integer viewss = video.getViews();
		System.out.println(video.getViews()+ "dd");
		video.setViews(viewss + 1);
		
		Video videoviews = videoService.update(video);
		List<Video> videoList = videoService.findAll();
		req.setAttribute("video", video);
		req.setAttribute("videoList", videoList);
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (currentUser != null) {
			History history = historyService.create(currentUser, video);
			
			req.setAttribute("flagLikedBtn", history.getIsLiked());
		}
		req.getRequestDispatcher("/views/user/video_detail.jsp").forward(req, resp);
	}

	private void doGetLike(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		boolean result = historyService.updateLikeOrUnline(currentUser, href);

		if (result == true) {
			resp.setStatus(204);// succeed but no resposen data
		} else {
			resp.setStatus(400);
		}
	}
}
