package principle.ood.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTerminatorTestDrive {

	public static void main(String[] args) {
		Employee jack = new Employee("Jack", "001");
		Employee rose = new Employee("Ross", "002");
		Employee jed = new Employee("Jed", "007");
		
		List<Employee> employees = new ArrayList<>(Arrays.asList(jack, rose, jed));
		EmployeeTerminatorModel myModel = new EmployeeTerminatorModel();
		myModel.setEmployees(employees);
		EmployeeTerminatorDialog myDialog = new EmployeeTerminatorDialog(myModel);
		myModel.setMyView(myDialog);
	}

}
