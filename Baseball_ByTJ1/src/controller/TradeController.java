package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.logic.BaseballTeamServiceLogic;

@WebServlet("/trade.do")
public class TradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();
		
		service.tradePlayer(request.getParameter("sorece"), request.getParameter("targetPlayer"));
		response.sendRedirect("playerList.do");		
	}
}
