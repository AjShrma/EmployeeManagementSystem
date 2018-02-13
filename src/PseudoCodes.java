import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import infoStore.EmployeeDatabase;


public class PseudoCodes {

	
	public static void main(String[] args) {
		
		
		String [] employeeTypes= {"Full-Time","Contract"};
		// Setting Up JFrame
		JFrame firstFrame= new JFrame("Employee Management System");
		//set the close operation
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Creating Menu Bar
	//	menuBar= new JMenuBar();
		
		
		
		//Setting Up ContentPane (Panel)
		RootContentPane.initialize();
		
		//Connecting to DB
		EmployeeDatabase.connect();
		
//	Adding TextFieldWithLabels
		
		RootContentPane.addTextField("SIN: ","Enter your SIN",true,13,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("First Name: ","Enter First Name",true,13,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("Last Name: ","Enter Last Name",true,13,RootContentPane.rootContentPanel);
		RootContentPane.addDropDown("Sex: ",new String[] {"Male","Female","Other"}, false);
		RootContentPane.addTextField("Email Address: ","Enter your Email",true,18,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("Street Address: ","Address",true,15,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("City: ","Enter your current City",true,13,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("Province: ","Province",true,13,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("Country: ","Country",true,13,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("Postal Code: ","Postal Code",true,13,RootContentPane.rootContentPanel);
		RootContentPane.addTextField("Mobile: ","Enter your mobile No.",true,13,RootContentPane.rootContentPanel);
		
		RootContentPane.addDropDown("Employment Type: ",employeeTypes, false);
		RootContentPane.addSubmitButton();
		
		RootContentPane.restoreConstaints();
		RootContentPane.cTextField.gridy=3;
		RootContentPane.cLabel.gridy=3;
		RootContentPane.addTextField("Employee ID: ","Enter Employee ID", true,10,RootContentPane.payslipPanel);
		RootContentPane.addPrintButton();
		
		
	   // RootContentPane.addButton("Add",true);
	 //   RootContentPane.addButton("PrintPayStub",true);
		//Adding Components to Frame
	//	firstFrame.setJMenuBar(menuBar);
		firstFrame.setLayout(new BoxLayout(firstFrame.getContentPane(),BoxLayout.X_AXIS));
	//	firstFrame.setPreferredSize(new Dimension(760,480));
		
		firstFrame.add(RootContentPane.rootContentPanel);
		firstFrame.getContentPane().add(RootContentPane.payslipPanel);
		firstFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//firstFrame.setResizable(false);
		firstFrame.pack();
		firstFrame.setLocationRelativeTo(null);
		
		
		// setting the visibility 
		RootContentPane.createComponentMap();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		firstFrame.setVisible(true);

	}
	

	

}
