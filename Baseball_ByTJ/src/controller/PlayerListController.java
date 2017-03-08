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

@WebServlet("/playerList.do")
public class PlayerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();
		
		
		
		List<BaseballTeam> list = new ArrayList<>();
		
		list= service.findAllTeamsWithPlayers();
		request.setAttribute("teams", list );
		request.getRequestDispatcher("playerList.jsp").forward(request, response);
		
		
		
	}

}
