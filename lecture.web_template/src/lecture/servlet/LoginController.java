package lecture.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.sendRedirect("loginForm.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		String loginId = request.getParameter("loginId");
		HttpSession session = request.getSession();
		
		session.setAttribute("userId", loginId);
		session.setAttribute("isAdmin", isAdminuser(loginId));
		response.sendRedirect("list.do");
	}
	private boolean isAdminuser(String loginId){
		List<String> adminUser = new ArrayList<String>();
		adminUser.add("jin");
		adminUser.add("kim");
		adminUser.add("park");
		return adminUser.contains(loginId);
	}
}
