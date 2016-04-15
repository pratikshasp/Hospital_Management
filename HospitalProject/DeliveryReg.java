package com.java.HospitalProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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

import javax.swing.JComboBox;

public class DeliveryReg extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField cast;
	private String gender;
	private int delId;
	private JTextField txtpatientId;
	private JTextField name;
	private JTextField textFieldWeight;
	Connection con=ConnectToDB.getCon();
	private JTextField hh;
	private JTextField mm;
	

	public DeliveryReg() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(441, 5, 629, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeliveryReg.class.getResource("/images/baby.png")));
		label.setBounds(891, 231, 351, 303);
		add(label);
		
		JLabel lblDateOfBirth = new JLabel("Delivery Date");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDateOfBirth.setBounds(174, 360, 235, 31);
		add(lblDateOfBirth);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTime.setBounds(174, 417, 235, 31);
		add(lblTime);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCast.setBounds(174, 473, 235, 31);
		add(lblCast);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="Male";
			}
		});
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 28));
		rdbtnMale.setBounds(488, 569, 128, 43);
		add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 28));
		rdbtnFemale.setBounds(752, 569, 128, 43);
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
		cast.setBounds(488, 471, 379, 33);
		add(cast);
		
		
		Button button = new Button("BACK");
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(256, 130, 140, 49);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				FollowupOptionWindow.create();
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
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DeliveryReg.class.getResource("/images/sidebar4.png")));
		label_1.setBounds(59, 206, 69, 353);
		add(label_1);
		JDateChooser date_of_birth = new JDateChooser();
		date_of_birth.setDateFormatString("ddMMMyyyy");
		date_of_birth.setBounds(488, 360, 147, 31);
		add(date_of_birth);
		date_of_birth.getDateEditor().setEnabled(false);
		date_of_birth.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		
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
		Delivery.setBounds(488, 528, 185, 31);
		add(Delivery);
		Delivery.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Delivery.getComponent(1).setVisible(false);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnSubmit.setBounds(488, 619, 147, 49);
		add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						String d1  = ((JTextField)date_of_birth.getDateEditor().getUiComponent()).getText();
						PreparedStatement psmt=con.prepareStatement("insert into delivery_reg values(?,?,?,?,?,?,?,?,?)");
						psmt.setInt(1,delId);
						psmt.setInt(2,FollowupPatient.pid);
						psmt.setString(3,FollowupPatient.oid);
						psmt.setString(4,d1);
						psmt.setString(5,hh.getText()+":"+mm.getText()+" "+String.valueOf(amPm.getSelectedItem()));
						psmt.setString(6,textFieldWeight.getText());
						psmt.setString(7,cast.getText());
						psmt.setString(8,gender);
						psmt.setString(9,String.valueOf(Delivery.getSelectedItem()));
						psmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Record Inserted...!");
						f.dispose();
						FollowupOptionWindow.create();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Record is not Inserted correctly...!");
						System.out.println(gender);
						e1.printStackTrace();
					}
				}
	
		});
		
		Button button_2 = new Button("HOME");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(614, 130, 140, 49);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		
		
		JLabel label_2 = new JLabel("Gender");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_2.setBounds(174, 576, 235, 31);
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
		lblname.setBounds(174, 298, 235, 31);
		add(lblname);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 21));
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(489, 297, 392, 40);
		add(name);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWeight.setBounds(662, 360, 128, 31);
		add(lblWeight);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textFieldWeight.setColumns(10);
		textFieldWeight.setBounds(794, 360, 140, 33);
		add(textFieldWeight);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_3.setBounds(572, 415, 18, 31);
		add(label_3);
		
		JLabel lblDelivery = new JLabel("Mode of Delivery");
		lblDelivery.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDelivery.setBounds(174, 526, 304, 30);
		add(lblDelivery);
		
		try {
			String s="select max(delivery_id) from delivery_reg";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery(); 
			rs1.next();
			delId=rs1.getInt(1)+1;
			s="select patient_id,patient_name,husband_name,father_name,surname from opd_reg where opd_id='"+FollowupPatient.oid+"'";
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				txtpatientId.setText(rs1.getInt(1)+"");
				name.setText(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
				
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
		f.getContentPane().add(new DeliveryReg());
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
