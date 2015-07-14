package principle.ood.java;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTerminatorModel implements EmployeeTerminatorController {
	private List<Employee> employees;
	private EmployeeTerminatorView myView;
	
	public EmployeeTerminatorModel(){
		super();
	}
	
	public EmployeeTerminatorModel(EmployeeTerminatorView myView){
		this.setMyView(myView);
	}
	
	public EmployeeTerminatorModel(EmployeeTerminatorView myView, List<Employee> employees){
		this.setMyView(myView);
		this.setEmployees(employees);
	} 
	
	@Override
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public Employee getEmployee(String name) {
		for (Employee e:this.employees) {
			if (e.getName().equals(name)) return e;
		}
		return null;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void setEmployees(Employee employee){
		this.employees.add(employee);
	}

	public EmployeeTerminatorView getMyView() {
		return myView;
	}

	public void setMyView(EmployeeTerminatorView myView) {
		this.myView = myView;
	}

	@Override
	public void terminate(List<String> employees) {
		this.employees.removeAll(employees.stream().map(e->getEmployee(e)).collect(Collectors.toList()));
		myView.clearSelection();
		myView.setEmployeeList(this.employees);
		myView.enableTerminate(false);		
	}



}
