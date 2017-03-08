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

@WebServlet("/teamList.do")
public class TeamListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();
		
		
		List<BaseballTeam> list = new ArrayList<>();
		
		list = service.findAllTeams();
	
		request.setAttribute("teams", list);
		request.getRequestDispatcher("teamList.jsp").forward(request, response);
		
	}

}
