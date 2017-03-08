package lecture.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.domain.Lecture;
import lecture.service.LectureService;
import lecture.service.LectureServiceLogic;
@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String lectureName = request.getParameter("lectureName");
		String instructorName = request.getParameter("instructorName");
		String lectureIntroduce = request.getParameter("lectureIntroduce");
		Lecture lecture = new Lecture(lectureName,instructorName,lectureIntroduce);
		LectureService service = new LectureServiceLogic();
		service.register(lecture);
		response.sendRedirect("list.do");
	}
}
