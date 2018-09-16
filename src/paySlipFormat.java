import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class paySlipFormat {

	public void addLabels(ArrayList<String> data) {
		GridBagConstraints cPaySlip=new GridBagConstraints();
		cPaySlip.gridx=4;
		cPaySlip.gridy=4;
		cPaySlip.anchor=GridBagConstraints.ABOVE_BASELINE_LEADING;

		String FullName=data.get(2)+"\t"+data.get(3);
		RootContentPane.payslipPanel.add(new JLabel(FullName),cPaySlip);
	
		cPaySlip.gridx=4;
		cPaySlip.gridy=5;
		cPaySlip.weighty=1;

		RootContentPane.payslipPanel.add(new JLabel(data.get(6)),cPaySlip);
		
		cPaySlip.gridy++;
		
		
		RootContentPane.payslipPanel.add(new JLabel(data.get(7)),cPaySlip);
		cPaySlip.gridy=7;
	
		RootContentPane.payslipPanel.add(new JLabel(data.get(1)),cPaySlip);
		cPaySlip.gridx=cPaySlip.gridx+5;
		cPaySlip.gridy=4;
		cPaySlip.anchor=GridBagConstraints.ABOVE_BASELINE_LEADING;
		
		RootContentPane.payslipPanel.add(new JLabel("TGS Technologies"),cPaySlip);
		cPaySlip.gridy++;
	
		RootContentPane.payslipPanel.add(new JLabel("1920 Yonge St, Suite 200"),cPaySlip);
		
		cPaySlip.gridy++;
		RootContentPane.payslipPanel.add(new JLabel("Tornoto,Ontario-M1J3N4"),cPaySlip);
		
		cPaySlip.gridy++;

		RootContentPane.payslipPanel.add(new JLabel("Phone: 416-939-0813 "),cPaySlip);
		cPaySlip.gridy++;
		
	
		final String[] columnNames= {"Descripition","QTES.","Rate/hr","Total"};
		final Object[][] tableData= {{"Base Pay","40","50",data.get(12)},
									{"","","Allowances",data.get(13)},
									{"","","Total",Integer.toString((Integer.parseInt(data.get(12))+Integer.parseInt(data.get(13))))}
									
		
						};
		JTable payInfo=new JTable(tableData,columnNames);
		payInfo.setRowHeight(20);
		JScrollPane tbal=new JScrollPane(payInfo);
		tbal.setPreferredSize(new Dimension(640,300));
		cPaySlip.insets=new Insets(10, 0, 10, 0);
		cPaySlip.gridx=2;
		cPaySlip.gridy=11;
		cPaySlip.gridwidth=10;
		cPaySlip.fill=GridBagConstraints.HORIZONTAL;
		cPaySlip.fill=GridBagConstraints.VERTICAL;
		RootContentPane.payslipPanel.add(tbal,cPaySlip);
		cPaySlip.gridx=3;
		cPaySlip.gridy=13;
		cPaySlip.gridwidth=2;
		cPaySlip.insets=new Insets(0, 0, 0, 0);
		RootContentPane.payslipPanel.add(new JLabel("Approved By:-"),cPaySlip);
		cPaySlip.gridy++;
		RootContentPane.payslipPanel.add(new JLabel("Kevin Adam"),cPaySlip);
		cPaySlip.gridy++;
		RootContentPane.payslipPanel.add(new JLabel("Payroll Manager"),cPaySlip);
		cPaySlip.gridy++;
		RootContentPane.payslipPanel.add(new JLabel("Branch: Montreal"),cPaySlip);
		cPaySlip.gridy++;
		RootContentPane.payslipPanel.add(new JLabel("Canada-M1J2N2"),cPaySlip);
		cPaySlip.gridy++;
		RootContentPane.payslipPanel.add(new JLabel("Phone: 416-939-0813 Ext.418"),cPaySlip);
		RootContentPane.payslipPanel.revalidate();
		RootContentPane.payslipPanel.repaint();
	}
}
