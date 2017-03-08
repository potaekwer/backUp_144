package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.logic.UserMusicServiceLogic;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserMusicServiceLogic service = new UserMusicServiceLogic();
		int musicNum =Integer.parseInt(request.getParameter("musicId"));
		HttpSession session = request.getSession();
		
		
		service.remove((String)session.getAttribute("userId"),musicNum);
			
		response.sendRedirect("myList.do");
		
	}

}
