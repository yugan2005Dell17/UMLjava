package principle.ood.java;

import java.util.List;

public interface EmployeeTerminatorView {
	
	public void enableTerminate(Boolean enable);
	
	public void setEmployeeList(List<Employee> employees);
	
	public void clearSelection();

}
