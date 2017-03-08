package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Music;
import service.logic.MusicServiceLogic;

@WebServlet("/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MusicServiceLogic service = new MusicServiceLogic();
		List<Music> list = service.findAll();		
		request.setAttribute("Musics", list);	
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		MusicServiceLogic service = new MusicServiceLogic();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Music> list = service.findByName(request.getParameter("search"));
		request.setAttribute("Musics", list);		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	
	}
}
