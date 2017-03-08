package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Music;
import service.logic.MusicServiceLogic;

@WebServlet("/detail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MusicServiceLogic service ;
    public DetailController() {
    	
    	service = new MusicServiceLogic();
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String musicId = request.getParameter("id");
		Music music = new Music();
		music = service.find(Integer.parseInt(musicId));
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("detailmusic",music);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
	
	}


}
