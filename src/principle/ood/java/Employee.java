package principle.ood.java;

import java.time.LocalDate;

public class Employee {
	private String name;
	private LocalDate birthDate;
	private final String employeeID;
	
	public Employee(String name, String employeeID){
		this.setName(name);
		this.employeeID=employeeID;		
	}
	
	public Employee(String name, LocalDate birthDate, String employeeID){
		this.setName(name);
		this.setBirthDate(birthDate);
		this.employeeID=employeeID;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmployeeID() {
		return employeeID;
	}
	

}
