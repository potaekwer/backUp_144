package member.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.domain.Member;
import member.service.MemberServiceLogic;

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		MemberServiceLogic service = new MemberServiceLogic();
		List<Member> list = service.searchAll();
		out.println("<html>");
		out.println("<head><title>전체 맴버</title></head>");
		out.println("<body>");
		out.println("<form action = 'searchByName.do'>");
		out.println("<input type = 'text' name = 'name'>");
		out.println("<input type = 'submit' value = '검색'>");
		out.println("</form>");
		out.println("<hr>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>이름</th><th>이메일</th><th>삭제</th>");
		out.println("</tr>");
		out.println("<tbody>");
		for(Member m : list){
			out.println("<tr>");
			out.println("<td><a href='detail.do?no="+m.getNo()+"'>"
					+m.getName() + "</a></td><td>"+m.getEmail()+"</td>"
					+"<td><a href='delete.do?no="+m.getNo()+"'>[삭제]</a></td>");			
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
