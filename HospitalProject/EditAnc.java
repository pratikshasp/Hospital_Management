package com.java.HospitalProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import com.toedter.calendar.JDateChooser;

public class EditAnc extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField no_of_children;
	private int ancId;
	private JTextField textName;
	private JTextField txtpatientId;
	Connection con=ConnectToDB.getCon();
	
	public EditAnc() {
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("     NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(367, 5, 627, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditAnc.class.getResource("/images/Anc.png")));
		label.setBounds(882, 201, 360, 345);
		add(label);
		
		JLabel lblNoOfChildern = new JLabel("No. of Children");
		lblNoOfChildern.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNoOfChildern.setBounds(180, 376, 235, 31);
		add(lblNoOfChildern);
		
		JLabel lblFirstReportedDate = new JLabel("First Reported Date");
		lblFirstReportedDate.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblFirstReportedDate.setBounds(180, 452, 302, 31);
		add(lblFirstReportedDate);
		
		no_of_children = new JTextField();
		no_of_children.setFont(new Font("Tahoma", Font.PLAIN, 21));
		no_of_children.setColumns(10);
		no_of_children.setBounds(495, 375, 248, 40);
		add(no_of_children);
		no_of_children.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EditAnc.class.getResource("/images/sidebar9.png")));
		label_1.setBounds(69, 228, 88, 332);
		add(label_1);
		

		JDateChooser date_of_firstReport = new JDateChooser();
		date_of_firstReport.setDateFormatString("ddMMMyyyy");
		date_of_firstReport.setBounds(495, 443, 248, 40);
		add(date_of_firstReport);
		date_of_firstReport.getDateEditor().setEnabled(false);
		date_of_firstReport.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		Button button = new Button("BACK");
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(180, 126, 140, 49);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				EditNextWindow.create();
			}
		});
		
		Button button_1 = new Button("LogOut");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(953, 126, 140, 49);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		JButton button_2 = new JButton("SUBMIT");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(506, 557, 147, 49);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String d1  = ((JTextField)date_of_firstReport.getDateEditor().getUiComponent()).getText();
					String n="UPDATE anc_reg SET number_of_child='"+no_of_children.getText()+"',first_reported_date='"+d1+"'Where anc_id="+ancId;
					PreparedStatement psmt=con.prepareStatement(n);
					psmt.executeQuery();
					JOptionPane.showMessageDialog(null, "Record Updated...!");
					f.dispose();
					EditNextWindow.create();
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Record is not Inserted correctly...!");
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblName.setBounds(180, 305, 235, 31);
		add(lblName);
		
		textName = new JTextField();
		textName.setEditable(false);
		textName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textName.setColumns(10);
		textName.setBounds(495, 304, 392, 40);
		add(textName);
		
		JLabel lblPatientId = new JLabel("Patient Id");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPatientId.setBounds(180, 231, 235, 31);
		add(lblPatientId);
		
		txtpatientId = new JTextField();
		txtpatientId.setEditable(false);
		txtpatientId.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtpatientId.setColumns(10);
		txtpatientId.setBounds(495, 230, 248, 40);
		add(txtpatientId);
		
		Button home = new Button("HOME");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		home.setFont(new Font("Tahoma", Font.BOLD, 28));
		home.setBounds(598, 126, 140, 49);
		add(home);
		
		try {
			String s="select patient_id,patient_name,husband_name,father_name,surname from opd_reg where opd_id='"+EditPatient.oid+"'";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				txtpatientId.setText(rs1.getInt(1)+"");
				textName.setText(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));

				
			}
			s="select * from anc_reg where opd_id='"+EditPatient.oid+"' and patient_id="+EditPatient.pid;
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				ancId=rs1.getInt(1);
				no_of_children.setText(rs1.getString(4));
				date_of_firstReport.setDate(rs1.getDate(5));
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
		f.getContentPane().add(new EditAnc());
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
