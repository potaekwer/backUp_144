package member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.domain.Member;
import member.service.MemberServiceLogic;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		MemberServiceLogic service = new MemberServiceLogic();
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		
		PrintWriter out = resp.getWriter();
		
		Member member = new Member();
		
		
		member.setEmail(req.getParameter("email"));
		member.setName(req.getParameter("name"));
		member.setPassword(req.getParameter("password"));
		
		out.println("<html>");
		out.println("<head><title>가입결과 페이지</title></head>");
		out.println("<body>");
		if(service.registerMember(member)){
			out.print("<h1>가입 완료</h1>");
		}else{
			out.print("<h1>가입 실패</h1>");
		}
		
		out.println("</body>");
		out.println("</html>");
		
		resp.sendRedirect("list.do");//완료후 다른 페이지 요청 url이 변경, 유지 로 구별
	}

}
