package principle.ood.java;

import java.awt.FlowLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class EmployeeTerminatorDialog implements EmployeeTerminatorView {
	private EmployeeTerminatorController myController;
	private JFrame frame;
	private JList<String> listBox;
	private JButton terminatorButton;
	
	
	public EmployeeTerminatorDialog(){
		super();
		initializeView();
	}

	public EmployeeTerminatorDialog(EmployeeTerminatorController myController){
		this.setMyController(myController);
		initializeView();
	}

	public EmployeeTerminatorController getMyController() {
		return myController;
	}

	public void setMyController(EmployeeTerminatorController myController) {
		this.myController = myController;
	}
	
	private void initializeView() {
		frame= new JFrame("Employee List");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().setSize(300, 600);
		if (myController!=null){
			listBox = new JList<String>(myController.getEmployees().stream().map(e->e.getName()).collect(Collectors.toList()).toArray(new String[0]));
			listBox.addListSelectionListener(e -> enableTerminate(true));
			frame.getContentPane().add(listBox);
		}
		terminatorButton = new JButton("Termination!");
		terminatorButton.setEnabled(false);
		terminatorButton.addActionListener(e -> terminatorButtonClicked());
		frame.getContentPane().add(terminatorButton);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void enableTerminate(Boolean enable) {
		terminatorButton.setEnabled(enable);		
	}

	@Override
	public void setEmployeeList(List<Employee> employees) {
		listBox = new JList<String>(
				employees.stream()
				.map(e->e.getName())
				.collect(Collectors.toList())
				.toArray(new String[0])
				);		
	}

	@Override
	public void clearSelection() {
		listBox.clearSelection();		
	}
	
	private void terminatorButtonClicked(){
		if (myController!=null) {
			List<String> pickedEmployee = listBox.getSelectedValuesList();
			myController.terminate(pickedEmployee);
			frame.paint(frame.getGraphics());
		}
	}

}
