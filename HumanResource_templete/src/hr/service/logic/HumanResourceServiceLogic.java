package hr.service.logic;

import java.util.List;

import hr.domain.Department;
import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.store.DepartmentStore;
import hr.store.EmployeeStore;
import hr.store.logic.DepartmentStoreLogic;
import hr.store.logic.EmployeeStoreLogic;

public class HumanResourceServiceLogic implements HumanResourceService {

	private DepartmentStore deptStore;
	private EmployeeStore empStore;

	public HumanResourceServiceLogic() {
		deptStore = new DepartmentStoreLogic();
		empStore = new EmployeeStoreLogic();
	}

	@Override
	public List<Department> findAllDepartment() {

		return deptStore.retrieveAll();
	}

	@Override
	public void registeDepartment(Department department) {
		deptStore.create(department);

	}

	@Override
	public Department findDepartment(String deptNo) {

		Department dept = deptStore.retrieve(deptNo);
		List<Employee> list = empStore.retrieveByDeptNo(deptNo);
		dept.setEmployees(list);

		return dept;
	}

	@Override
	public List<Employee> findAllEmployee() {
		return empStore.retrieveAll();
	}

	@Override
	public void registEmployee(Employee employee) {
		empStore.create(employee);
	}

	@Override
	public void removeDepartment(String deptNo) {
		deptStore.delete(deptNo);

	}

	@Override
	public Employee findEmployee(String empNo) {
		return empStore.retrieve(empNo);
	}

	@Override
	public void modify(Employee employee) {

		empStore.update(employee);
	}

}
