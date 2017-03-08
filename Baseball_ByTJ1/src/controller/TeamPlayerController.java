package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/teamPlayer.do")
public class TeamPlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();
		List<BaseballTeam> list = new ArrayList<>();
		BaseballTeam team = new BaseballTeam();
		
		team = service.findTeam(request.getParameter("teamId"));
		
		list.add(team);
		request.setAttribute("teams",list);
		request.getRequestDispatcher("playerList.jsp").forward(request, response);
		
	
	}

}
