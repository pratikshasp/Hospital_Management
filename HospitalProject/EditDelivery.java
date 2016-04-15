package com.java.HospitalProject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Button;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;

public class EditDelivery extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField cast;
	private String gender;
	private int delId;
	private JTextField txtpatientId;
	private JTextField textName;
	private JTextField weight;
	Connection con=ConnectToDB.getCon();
	private JTextField hh;
	private JTextField mm;

	public EditDelivery() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(441, 5, 629, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditDelivery.class.getResource("/images/baby.png")));
		label.setBounds(891, 231, 351, 303);
		add(label);
		
		JLabel lblDateOfBirth = new JLabel("Delivery Date");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDateOfBirth.setBounds(174, 363, 235, 31);
		add(lblDateOfBirth);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTime.setBounds(174, 417, 235, 31);
		add(lblTime);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCast.setBounds(174, 468, 235, 31);
		add(lblCast);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Male";
			}
		});
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 28));
		rdbtnMale.setBounds(488, 556, 128, 43);
		add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 28));
		rdbtnFemale.setBounds(752, 556, 128, 43);
		add(rdbtnFemale);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Female";
			}
		});
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		
		cast = new JTextField();
		cast.setFont(new Font("Tahoma", Font.PLAIN, 21));
		cast.setColumns(10);
		cast.setBounds(488, 466, 379, 33);
		add(cast);
		cast.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
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
		
		Button button_1 = new Button("LogOut");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(1003, 130, 140, 49);
		add(button_1);
		
		hh = new JTextField();
		hh.setFont(new Font("Tahoma", Font.PLAIN, 21));
		hh.setColumns(10);
		hh.setBounds(488, 417, 74, 33);
		add(hh);
		
		mm = new JTextField();
		mm.setFont(new Font("Tahoma", Font.PLAIN, 21));
		mm.setColumns(10);
		mm.setBounds(599, 417, 74, 33);
		add(mm);
		
		String p[]=new String[]{"Am","Pm"};
		JComboBox<String> amPm = new JComboBox<String>(p);
		amPm.setFont(new Font("Tahoma", Font.PLAIN, 21));
		amPm.setBounds(703, 417, 68, 31);
		add(amPm);
		
		String option[]=new String[]{"Normal","Forceps","Vacuum","Caesarian"};
		JComboBox<String> Delivery = new JComboBox<String>(option);
		Delivery.setBackground(Color.WHITE);
		Delivery.setBounds(488, 518, 185, 31);
		add(Delivery);
		Delivery.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Delivery.getComponent(1).setVisible(false);
		
		JLabel lblDelivery = new JLabel("Mode of Delivery");
		lblDelivery.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDelivery.setBounds(174, 516, 304, 30);
		add(lblDelivery);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EditDelivery.class.getResource("/images/sidebar4.png")));
		label_1.setBounds(59, 206, 69, 353);
		add(label_1);
		JDateChooser date_of_birth = new JDateChooser();
		date_of_birth.setDateFormatString("ddMMMyyyy");
		date_of_birth.setBounds(488, 363, 147, 31);
		add(date_of_birth);
		date_of_birth.getDateEditor().setEnabled(false);
		date_of_birth.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnSubmit.setBounds(488, 619, 147, 49);
		add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().trim().length()==0||cast.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null,"Fill all the Fields.......");
					
				}
				else{
						try{
						String a=hh.getText()+":"+mm.getText()+" "+String.valueOf(amPm.getSelectedItem());
						String d1  = ((JTextField)date_of_birth.getDateEditor().getUiComponent()).getText();
						String n="update delivery_reg set delivery_date='"+d1+"',delivery_time='"+a+"',weight='"+weight.getText()+"',cast='"+cast.getText()+"',gender='"+gender+"',delivery_mode='"+String.valueOf(Delivery.getSelectedItem())+"' where delivery_id="+delId;
						PreparedStatement psmt=con.prepareStatement(n);
						psmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Record Updated...!");
						f.dispose();
						EditNextWindow.create();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Record is not updated correctly...!");
						e1.printStackTrace();
					}
				}
			}
		});
		
		Button button_2 = new Button("HOME");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(614, 130, 140, 49);
		add(button_2);
		
		JLabel label_2 = new JLabel("Gender");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_2.setBounds(174, 563, 235, 31);
		add(label_2);
		
		txtpatientId = new JTextField();
		txtpatientId.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtpatientId.setEditable(false);
		txtpatientId.setColumns(10);
		txtpatientId.setBounds(489, 236, 248, 40);
		add(txtpatientId);
		
		JLabel lblPatientid = new JLabel("Patient Id");
		lblPatientid.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPatientid.setBounds(174, 237, 235, 31);
		add(lblPatientid);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblname.setBounds(175, 301, 235, 31);
		add(lblname);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textName.setEditable(false);
		textName.setColumns(10);
		textName.setBounds(489, 300, 392, 40);
		add(textName);
		
		weight = new JTextField();
		weight.setFont(new Font("Tahoma", Font.PLAIN, 21));
		weight.setColumns(10);
		weight.setBounds(798, 363, 140, 33);
		add(weight);
		
		JLabel label_3 = new JLabel("Weight");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_3.setBounds(666, 363, 128, 31);
		add(label_3);

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		try {
			String s="select patient_id,patient_name,husband_name,father_name,surname from opd_reg where opd_id='"+EditPatient.oid+"'";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				txtpatientId.setText(rs1.getInt(1)+"");
				textName.setText(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));

				
			}
			s="select * from delivery_reg where opd_id='"+EditPatient.oid+"' and patient_id="+EditPatient.pid;
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				delId=rs1.getInt(1);
				date_of_birth.setDate(rs1.getDate(4));
				String o=rs1.getString(5);
				String[] n1=o.split(":");
				String[] n2=n1[1].split(" ");
				hh.setText(n1[0]);
				mm.setText(n2[0]);
				if(n2[1].equals("Am"))
					amPm.setSelectedIndex(0);
				else if(n2[1].equals("Pm"))
					amPm.setSelectedIndex(1);
				weight.setText(rs1.getString(6));
				cast.setText(rs1.getString(7));
				gender=rs1.getString(8);
				if(gender.equals("Male")){
					rdbtnMale.setSelected(true);
				}
				else if(gender.equals("Female"))
				{
					rdbtnFemale.setSelected(true);
				}
				Delivery.setSelectedItem(rs1.getString(9));
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
		f.getContentPane().add(new EditDelivery());
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
