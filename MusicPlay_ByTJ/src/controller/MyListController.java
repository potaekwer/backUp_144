package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Music;
import service.logic.MusicServiceLogic;
import service.logic.UserMusicServiceLogic;

@WebServlet("/myList.do")
public class MyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		UserMusicServiceLogic service = new UserMusicServiceLogic();
		HttpSession session = request.getSession();
		List<Music> list = new ArrayList<>();
		list = service.findMusicsByUser((String)session.getAttribute("userId"));
		request.setAttribute("mylist", list);
		request.getRequestDispatcher("myList.jsp").forward(request, response);
		
		
	}

}
