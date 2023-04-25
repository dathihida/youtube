package asm_java4.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm_java4.common.SessionAttr;
import asm_java4.enity.History;
import asm_java4.enity.User;
import asm_java4.enity.Video;
import asm_java4.service.HistoryService;
import asm_java4.service.VideoService;
import asm_java4.service.impl.HistoryServiceImpl;
import asm_java4.service.impl.VideoServiceImpl;
@WebServlet(urlPatterns = {"/index", "/favorites", "/history", "/trending"})
public class homeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5074196141175180284L;
	private static final int VIDEO_MAX_PAGE_SIZE = 4;

	private VideoService videoser = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch(path) {
			case"/index":
				doGetIndex(req, resp);
				break;
			case"/favorites":
				doGetFavorites(session, req, resp);
				break;
			case"/history":
				doGetHistory(session, req, resp);
				break;
			case"/trending":
				doGetTrending(session, req, resp);
				break;
		}	
	}
	
	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Video> countVideo = videoser.findAll();
		int maxPage = (int) Math.ceil( countVideo.size() / (double) VIDEO_MAX_PAGE_SIZE);
		
		req.setAttribute("maxPage", maxPage);
		
		List<Video> videos;
		String pageNumber = req.getParameter("page");
		
		if(pageNumber == null || Integer.valueOf(pageNumber) > maxPage) {
			videos = videoser.findAll(1, VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", 1);
		}else {
			videos = videoser.findAll(Integer.valueOf(pageNumber), VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", Integer.valueOf(pageNumber));
		}
		
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
	
	private void doGetFavorites(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> histories = historyService.findByUserAndIsLiked(user.getUsername());
		
		List<Video> videos = new ArrayList<>();
		
//		histories.forEach(item -> videos.add(item.getVideo()));
		
		for(int i=0; i<histories.size(); i++) {
			videos.add(histories.get(i).getVideo());
		}
		req.setAttribute("videos", videos);
		
		req.getRequestDispatcher("/views/user/favorites.jsp").forward(req, resp);
	}
	
	private void doGetHistory(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> histories = historyService.findByUser(user.getUsername());
		
		List<Video> videos = new ArrayList<>();
		
//		histories.forEach(item -> videos.add(item.getVideo()));
		
		for(int i=0; i<histories.size(); i++) {
			videos.add(histories.get(i).getVideo());
		}
		
		req.setAttribute("videos", videos);
		
		req.getRequestDispatcher("/views/user/history.jsp").forward(req, resp);
	}
	
	private void doGetTrending(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String search = req.getParameter("search");
		System.out.print(search);
//		Video videoList = videoser.findByTitle(search);  
		List<Video> videoList = videoser.findByTitle_video("%" +search+ "%");
		req.setAttribute("videoList", videoList);
		
		req.getRequestDispatcher("/views/user/trending-sreach.jsp").forward(req, resp);
	}
	
//	private void doPostTrending(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String search = req.getParameter("search");
//		System.out.print(search);
//		Video videoList = videoser.findByTitle(search);  
//		req.setAttribute("videoList", videoList);
//		
//		req.getRequestDispatcher("/views/user/trending-sreach.jsp").forward(req, resp);
//	}
}
