package com.java.HospitalProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Button;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextArea;

public class EditIpd extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField ipd_id;
	private JTextField diagnosis;
	private JTextField treatment;
	private JTextField txtpatientid;
	private JTextField textName;
	Connection con=ConnectToDB.getCon();
	
	
	public EditIpd() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(441, 5, 629, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditIpd.class.getResource("/images/indoor.png")));
		label.setBounds(909, 206, 360, 353);
		add(label);
		
		JLabel lblipdno = new JLabel("IPD No.");
		lblipdno.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblipdno.setBounds(629, 228, 109, 31);
		add(lblipdno);
		
		JLabel lblNameOfChild = new JLabel("Date of Admit");
		lblNameOfChild.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNameOfChild.setBounds(205, 335, 235, 31);
		add(lblNameOfChild);
		
		JLabel lblTime = new JLabel("Date of Discharge");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTime.setBounds(205, 392, 269, 31);
		add(lblTime);
		
		JLabel lblCast = new JLabel("Diagnosis");
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCast.setBounds(205, 445, 235, 31);
		add(lblCast);
		
		ipd_id = new JTextField("");
		ipd_id.setEditable(false);
		ipd_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ipd_id.setBounds(765, 229, 134, 33);
		add(ipd_id);
		ipd_id.setColumns(10);
		
		diagnosis = new JTextField();
		diagnosis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		diagnosis.setColumns(10);
		diagnosis.setBounds(495, 443, 404, 33);
		add(diagnosis);
		
		JLabel lbldischarge = new JLabel("Discharge Summary");
		lbldischarge.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbldischarge.setBounds(205, 555, 269, 31);
		add(lbldischarge);
		
		JDateChooser date_of_admit = new JDateChooser();
		date_of_admit.setDateFormatString("ddMMMyyyy");
		date_of_admit.setBounds(495, 332, 189, 31);
		date_of_admit.getDateEditor().setEnabled(false);
		date_of_admit.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(date_of_admit);
		
		JDateChooser date_of_discharge = new JDateChooser();
		date_of_discharge.setDateFormatString("ddMMMyyyy");
		date_of_discharge.setBounds(495, 389, 189, 31);
		date_of_discharge.getDateEditor().setEnabled(false);
		date_of_discharge.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(date_of_discharge);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EditIpd.class.getResource("/images/sidebar5.png")));
		label_1.setBounds(66, 234, 69, 353);
		add(label_1);
		
		JLabel lblTreatment = new JLabel("Treatment");
		lblTreatment.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTreatment.setBounds(205, 504, 235, 31);
		add(lblTreatment);
		
		treatment = new JTextField();
		treatment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		treatment.setColumns(10);
		treatment.setBounds(495, 502, 404, 33);
		add(treatment);
		
		JTextArea dischargeSummary = new JTextArea(5,10);
		dischargeSummary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dischargeSummary.setAutoscrolls(true);
		dischargeSummary.setLineWrap(true); 
		dischargeSummary.setWrapStyleWord(true);
		dischargeSummary.setLineWrap(true);
		dischargeSummary.setBounds(495, 555, 404, 70);
		add(dischargeSummary);
		JScrollPane scrollPane = new JScrollPane( dischargeSummary );
		scrollPane.setViewportView(dischargeSummary);
		scrollPane.setBounds(495, 555, 404, 70);
		add(scrollPane);
		
		
		JButton button_2 = new JButton("SUBMIT");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(571, 645, 147, 49);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ipd_id.getText().trim().length()==0 ){
					JOptionPane.showMessageDialog(null,"Fill IPD ID.......");
					
				}
				else{
						try{
						String d1 = ((JTextField)date_of_admit.getDateEditor().getUiComponent()).getText(); 
						String d2 = ((JTextField)date_of_discharge.getDateEditor().getUiComponent()).getText(); 
						String n="UPDATE ipd_reg SET date_of_admission='"+ d1 +"',date_of_discharge='"+d2 +"',diagnosis='"+diagnosis.getText()+"',treatment='"+treatment.getText()+"',discharge_summary='"+dischargeSummary.getText()+"' WHERE ipd_id='"+ipd_id.getText()+"'"; 
						PreparedStatement psmt=con.prepareStatement(n);
						psmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Record Updated...!");
						f.dispose();
						EditNextWindow.create();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Record is not get Updated correctly...!");
						e1.printStackTrace();
					}
				}	
			}
		});
		
		Button button_3 = new Button("HOME");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_3.setBounds(571, 130, 140, 49);
		add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		Button button = new Button("BACK");
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(256, 130, 140, 49);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				EditNextWindow.create();
			}
		});
		
		Button button_1 = new Button("Log Out");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(874, 130, 140, 49);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		JLabel lblpatientid = new JLabel("Patient ID:");
		lblpatientid.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblpatientid.setBounds(205, 228, 175, 31);
		add(lblpatientid);
		
		txtpatientid = new JTextField();
		txtpatientid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpatientid.setEditable(false);
		txtpatientid.setBounds(364, 228, 134, 31);
		add(txtpatientid);
		txtpatientid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblName.setBounds(205, 280, 117, 31);
		add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textName.setEditable(false);
		textName.setBounds(495, 277, 404, 31);
		add(textName);
		
		
		
		try {
			String s="select patient_id,patient_name,husband_name,father_name,surname from opd_reg where opd_id='"+EditPatient.oid+"'";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				txtpatientid.setText(rs1.getInt(1)+"");
				textName.setText(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));

				
			}
			s="select * from ipd_reg where opd_id='"+EditPatient.oid+"' and patient_id="+EditPatient.pid;
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				ipd_id.setText(rs1.getString(1)+"");
				date_of_admit.setDate(rs1.getDate(4));
				date_of_discharge.setDate(rs1.getDate(5));
				diagnosis.setText(rs1.getString(6));
				treatment.setText(rs1.getString(7));
				dischargeSummary.setText(rs1.getString(8));
			}

		} catch (Exception e) {
		}
		
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new EditIpd());
		WindowUtil.setToCenter(f, WindowUtil.getScreenWidth(), WindowUtil.getScreenHeight());
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int result = JOptionPane.showConfirmDialog(f, "Do you want to Exit ?", "Exit Confirmation : ", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION)               
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				else if (result == JOptionPane.NO_OPTION)   
					f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		f.setVisible(true);
	}
}
