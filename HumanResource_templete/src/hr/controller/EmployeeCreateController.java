package hr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employee/create.do")
public class EmployeeCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HumanResourceService service = new HumanResourceServiceLogic();
		List<Employee> list = new ArrayList<>();
		List<Employee> reList = new ArrayList<>();
				
				
		list = service.findAllEmployee();
		String deptno;
		deptno = request.getParameter("deptNo");
		
		for(Employee e : list){
			if(e.getDeptNo().equals("부서 등록")){
				reList.add(e);
			}
		}
		
		request.setAttribute("emps", reList);
		request.setAttribute("deptNo", deptno);
		request.getRequestDispatcher("/views/addEmpToDept.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
		HumanResourceService service = new HumanResourceServiceLogic();
		
		Employee emp = new Employee();
		
		emp.setNo(request.getParameter("empNo"));
		emp.setName(request.getParameter("empName"));
		emp.setDeptNo("부서 등록");
		
		service.registEmployee(emp);
		
		response.sendRedirect(request.getContextPath() + "/employee/list.do");
		
		
	
	}

}
