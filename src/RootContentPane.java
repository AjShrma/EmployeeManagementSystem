
import java.awt.Color;
import java.awt.Component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class RootContentPane {

	public static HashMap<String, Component> componentMap;
	static JPanel rootContentPanel,payslipPanel;
	static Border border = BorderFactory.createLineBorder(Color.BLACK);
    static CompoundBorder compoundBorder=BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5,5));
    static GridBagConstraints cLabel,cTextField,cHeaders;
	public static void initialize() {
		
		
		GridBagLayout layout=new GridBagLayout();
		rootContentPanel= new JPanel(layout);
		payslipPanel=new JPanel(layout);
	//	rootContentPanel.setSize(930, 480);
		restoreConstaints();
		rootContentPanel.add(new JLabel("New Employee Registration Form"),cHeaders);
	
		payslipPanel.add(new JLabel("PaySlip Generator"),cHeaders);
	
		//rootContentPanel.set
		payslipPanel.setBorder(compoundBorder);
		rootContentPanel.setBorder(compoundBorder);
	}
	public static void addDropDown(String Label,String []options,boolean isEditable) {
		JLabel label=new JLabel(Label);
        rootContentPanel.add(label,cLabel);
        cLabel.gridy++;
		
		JComboBox<String>  dropDown= new JComboBox<String>(options);
		dropDown.setMaximumSize(dropDown.getMaximumSize());
		dropDown.setEditable(isEditable);
		dropDown.setName(Label);
		
		rootContentPanel.add(dropDown,cTextField);
		cTextField.gridy++;
		
	}
	
	public static void addTextField( String Label,String title,boolean isEditable,int cols,JPanel rootContentPanel) {
        JLabel label=new JLabel(Label);
     
        rootContentPanel.add(label,cLabel);
        cLabel.gridy++;
        
		JTextField textField=new JTextField();
		textField.setEditable(isEditable);
		textField.setColumns(cols);
		textField.setToolTipText(title);
		textField.setName(Label);
		textField.setBorder(compoundBorder);
		
		rootContentPanel.add(textField,cTextField);
		cTextField.gridy++;
	}
	
	public static void createComponentMap() {
        componentMap = new HashMap<String,Component>();
        Component[] formComponents = rootContentPanel.getComponents();
        
        for (int i=0; i < formComponents.length; i++) {
                componentMap.put(formComponents[i].getName(), formComponents[i]);
        }
        Component[] payComponents = payslipPanel.getComponents();
        for (int i=formComponents.length,j=0; j < payComponents.length; i++,j++) {
            componentMap.put(payComponents[j].getName(), payComponents[j]);
    }
}

public static Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else 
        	return null;
}

public static void addSubmitButton() {
	cTextField.gridy++;
	JButton submit=new JButton("Submit");
	submit.setName("Submit");
	submit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Listeners().actionPerformed(e);
			refreshForm();
		}
	});
	rootContentPanel.add(submit,cTextField);
}
public static void addPrintButton() {
	
	cTextField.gridx++;
	cTextField.gridx++;
	cTextField.gridy--;
	//cTextField.weighty=0;
	JButton print=new JButton("Show PayStub");
	print.setName("Print");
	print.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Listeners().actionPerformed(e);
		}
	});
	payslipPanel.add(print,cTextField);
	cTextField.gridx++;
	JButton refresh=new JButton("Clear");
	refresh.setName("Refresh");
	 payslipPanel.add(refresh,cTextField);
   refresh.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			payslipPanel.removeAll();
			restoreConstaints();
			payslipPanel.add(new JLabel("PaySlip Generator"),cHeaders);
			cTextField.gridy=3;
			cLabel.gridy=3;
			addTextField("Employee ID: ","Enter Employee ID", true,10,RootContentPane.payslipPanel);
			addPrintButton();
			payslipPanel.revalidate();
			payslipPanel.repaint();
			restoreConstaints();
			componentMap.clear();
			createComponentMap();
		}
	});
  
	restoreConstaints();
}
public static void restoreConstaints() {
	cHeaders=new GridBagConstraints();
	cHeaders.gridx=5;
	cHeaders.gridy=2;
	cHeaders.weighty=0;
	cHeaders.anchor=GridBagConstraints.FIRST_LINE_START;
	cHeaders.insets=new Insets(-4,0,10,0);
	cLabel=new GridBagConstraints();
	cLabel.insets=new Insets(7,3, 7, 3);
	cLabel.gridx=4;
	cLabel.gridy=3;
	cLabel.weighty=1;
	cLabel.anchor=GridBagConstraints.BASELINE_TRAILING;
	cTextField=new GridBagConstraints();
	cTextField.gridx=5;
	cTextField.gridy=3;
	cTextField.weighty=0;
	cTextField.insets=new Insets(7,3,7,3);
	
	cTextField.anchor=GridBagConstraints.BASELINE_LEADING;
}

public static void refreshForm() {
	
	((JTextField)(RootContentPane.getComponentByName("First Name: "))).setText("");
	((JTextField)(RootContentPane.getComponentByName("Last Name: "))).setText("");
	((JTextField)(RootContentPane.getComponentByName("Email Address: "))).setText("");
	((JTextField)(RootContentPane.getComponentByName("City: "))).setText("");
}

}
