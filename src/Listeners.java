import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import empClasses.Employee;
import empClasses.FullTimeEmployee;
import empClasses.PartTimeEmployee;
import infoStore.EmployeeDatabase;

public class Listeners implements ActionListener{


	


	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton item=(JButton) e.getSource();
		switch(item.getName()) {
		case "Submit":
			
			
			
		{
			String type=((JComboBox<String>)(RootContentPane.getComponentByName("Employment Type: "))).getSelectedItem().toString();
			Employee Emp;
			if(type.equals("Full-Time")) {
			Emp=new FullTimeEmployee();
			}
			else {
			Emp=new PartTimeEmployee();
			}
			
			String firstName=((JTextField)(RootContentPane.getComponentByName("First Name: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("First Name: "))).setText("");
			String lastName=((JTextField)(RootContentPane.getComponentByName("Last Name: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("Last Name: "))).setText("");
			
			String empID="C"+(int)(Math.random()*100+Math.random()*100+1);
			
			String SIN=((JTextField)(RootContentPane.getComponentByName("SIN: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("SIN: "))).setText("");
			String email=((JTextField)(RootContentPane.getComponentByName("Email Address: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("Email Address: "))).setText("");
			String address=((JTextField)(RootContentPane.getComponentByName("Street Address: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("Street Address: "))).setText("");
			String city=((JTextField)(RootContentPane.getComponentByName("City: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("City: "))).setText("");
			String province=((JTextField)(RootContentPane.getComponentByName("Province: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("Province: "))).setText("");
			String country=((JTextField)(RootContentPane.getComponentByName("Country: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("Country: "))).setText("");
			String postal=((JTextField)(RootContentPane.getComponentByName("Postal Code: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("Postal Code: "))).setText("");
			String mobile=((JTextField)(RootContentPane.getComponentByName("Mobile: "))).getText();
			((JTextField)(RootContentPane.getComponentByName("Mobile: "))).setText("");
			String empType=((JComboBox<String>)(RootContentPane.getComponentByName("Employment Type: "))).getSelectedItem().toString();
			String sex=((JComboBox<String>)(RootContentPane.getComponentByName("Sex: "))).getSelectedItem().toString();
			Emp.setPersonalInfo(firstName, lastName, empID, empType, SIN, sex, email, address, city, province, country, postal, mobile);
			Emp.setAllowances();
			//Adding Employee to database
			if(EmployeeDatabase.addEmployee(Emp)==1)
			JOptionPane.showMessageDialog(RootContentPane.rootContentPanel.getRootPane(),"Employee Information Added- Employee ID is: "+empID);
			
			break;
			
			
		}
		case "Print" :
		{
						String empIdPay=((JTextField)(RootContentPane.getComponentByName("Employee ID: "))).getText().toString();
						if(empIdPay.equals("")) {
							JOptionPane.showMessageDialog(RootContentPane.payslipPanel.getRootPane(),"Please Enter a Value for Empolyee ID");
						}
						else if(EmployeeDatabase.findEmployee(empIdPay)==null) {
							JOptionPane.showMessageDialog(RootContentPane.payslipPanel.getRootPane(),"Employee Doesn't Exist.Enter a Valid Employee ID");
						}
						else {
						//JOptionPane.showMessageDialog(RootContentPane.payslipPanel.getRootPane(),"Employee PaySlip Call Function- Fname is: "+EmployeeDatabase.findEmployee(empIdPay).get(0));
						paySlipFormat p=new paySlipFormat();
						
						p.addLabels(EmployeeDatabase.findEmployee(empIdPay));
						
						RootContentPane.payslipPanel.revalidate();
						RootContentPane.payslipPanel.repaint();
						}
						break;
		}
			
	}	
			
 }
	}

