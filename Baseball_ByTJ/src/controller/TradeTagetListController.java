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
import domain.Player;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/tradeTargetList.do")
public class TradeTagetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();
		
	
		List<BaseballTeam> list = new ArrayList<>();
		
		Player player = new Player();
		
		player = service.findPlayer(request.getParameter("playerId"));
		list = service.findTradeTargetPalyers(player.getTeamId());
		request.setAttribute("sorece", player);
		request.setAttribute("trades", list);
		request.getRequestDispatcher("tradeTargetList.jsp").forward(request, response);
		
		
	
	}

}
