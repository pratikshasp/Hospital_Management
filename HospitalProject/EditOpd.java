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
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;

public class EditOpd extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField opd_id;
	private JTextField address_per;

	private JTextField address_m;
	private JTextField pname;
	private JTextField phname;
	private JTextField phfname;
	private JTextField psname;
	private JTextField address_p;
	private JTextField age;
	private JTextField phone_no;
	private Button button_2;
	private JTextField textpatientid;
	Connection con=ConnectToDB.getCon();
	private int subid;
	public static String ptype="";
	public static String pservice="";

	
	public EditOpd() {
		
		
		setSize(1375,768);
		setLayout(null);
				
		JLabel lblNitaveHospital = new JLabel("NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(441, 5, 629, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditOpd.class.getResource("/images/form1.png")));
		label.setBounds(927, 206, 379, 360);
		add(label);
		
		JLabel lblDateOfBirth = new JLabel("OPD id");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDateOfBirth.setBounds(581, 210, 131, 31);
		add(lblDateOfBirth);
		
		JLabel lblTime = new JLabel("Name");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTime.setBounds(165, 332, 102, 31);
		add(lblTime);
		
		JLabel lblCast = new JLabel("Address");
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCast.setBounds(165, 395, 131, 31);
		add(lblCast);
		
		opd_id = new JTextField();
		opd_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opd_id.setBounds(739, 208, 189, 33);
		add(opd_id);
		opd_id.setColumns(10);
		
		address_per = new JTextField();
		address_per.setFont(new Font("Tahoma", Font.PLAIN, 20));
		address_per.setColumns(10);
		address_per.setBounds(323, 393, 605, 33);
		add(address_per);
		
		Button button = new Button("BACK");
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(254, 103, 140, 49);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				EditNextWindow.create();
			}
		});
		
		Button button_1 = new Button("LogOut");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(877, 103, 140, 49);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EditOpd.class.getResource("/images/sidebar8.png")));
		label_1.setBounds(37, 236, 69, 353);
		add(label_1);
		
		address_m = new JTextField();
		address_m.setFont(new Font("Tahoma", Font.PLAIN, 20));
		address_m.setColumns(10);
		address_m.setBounds(323, 454, 605, 33);
		add(address_m);
		
		pname = new JTextField();
		pname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pname.setColumns(10);
		pname.setBounds(323, 332, 146, 33);
		add(pname);
		
		phname = new JTextField();
		phname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phname.setColumns(10);
		phname.setBounds(479, 332, 140, 33);
		add(phname);
		
		phfname = new JTextField();
		phfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phfname.setColumns(10);
		phfname.setBounds(627, 332, 147, 33);
		add(phfname);
		
		psname = new JTextField();
		psname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		psname.setColumns(10);
		psname.setBounds(781, 332, 147, 33);
		add(psname);
		
		address_p = new JTextField();
		address_p.setFont(new Font("Tahoma", Font.PLAIN, 20));
		address_p.setColumns(10);
		address_p.setBounds(323, 511, 605, 33);
		add(address_p);
		
		JLabel label_2 = new JLabel("Age");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_2.setBounds(165, 568, 69, 31);
		add(label_2);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(323, 566, 118, 33);
		add(age);
		
		JLabel label_3 = new JLabel("Phone no.");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_3.setBounds(573, 568, 165, 31);
		add(label_3);
		
		phone_no = new JTextField();
		phone_no.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phone_no.setColumns(10);
		phone_no.setBounds(748, 566, 180, 33);
		add(phone_no);
		
		button_2 = new Button("HOME");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(584, 103, 140, 49);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		textpatientid = new JTextField();
		textpatientid.setEditable(false);
		textpatientid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textpatientid.setColumns(10);
		textpatientid.setBounds(323, 213, 170, 33);
		add(textpatientid);
		
		JLabel label_4 = new JLabel("Patient Id");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_4.setBounds(165, 212, 165, 31);
		add(label_4);
		
		JLabel label_5 = new JLabel("Date ");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_5.setBounds(165, 274, 140, 31);
		add(label_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		dateChooser.setDateFormatString("ddMMMyyy");
		dateChooser.setBounds(323, 274, 215, 31);
		add(dateChooser);
		
		JButton btnTypeAndServices = new JButton("Type and Services");
		btnTypeAndServices.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTypeAndServices.setBounds(614, 270, 303, 38);
		add(btnTypeAndServices);
		btnTypeAndServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditServices.create();
			}
		});
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnSubmit.setBounds(479, 681, 147, 49);
		add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						try{
						PreparedStatement psmt=con.prepareStatement("UPDATE opd_reg SET patient_name='"+pname.getText()+"',husband_name='"+phname.getText()+"',father_name ='"+ phfname.getText()+"',surname ='"+ psname.getText()+"',permanant='"+address_per.getText()+"',paternal='"+address_m.getText()+"',maternal ='"+address_p.getText()+"',age="+ age.getText()+",phone='"+ phone_no.getText()+"' WHERE opd_id='"+EditPatient.oid+"' AND patient_id="+EditPatient.pid);
						psmt.executeQuery();
						String d1 = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); 
						psmt=con.prepareStatement("UPDATE opd_sub SET opd_date='"+ d1 +"',patient_type='"+ EditServices.s +"',service_provided='"+ EditServices.p +"' WHERE opdsub_id="+subid);
						psmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Record Updated...!");
						
						f.dispose();
						EditNextWindow.create();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Record is not Updated correctly...!");
						e1.printStackTrace();
					}
				}
				
			
		});
		
		
		
		try{
			String p="select * from Opd_Reg where opd_id='"+EditPatient.oid+"'";
			PreparedStatement stm=con.prepareStatement(p);
			ResultSet rs=stm.executeQuery();
			while(rs.next())
			{
				textpatientid.setText(EditPatient.pid+"");
				opd_id.setText(EditPatient.oid+"");
				pname.setText(rs.getString(3));
				phname.setText(rs.getString(4));
				phfname.setText(rs.getString(5));
				psname.setText(rs.getString(6));
				address_per.setText(rs.getString(7));
				address_p.setText(rs.getString(9));
				address_m.setText(rs.getString(8));
				age.setText(rs.getString(10));
				phone_no.setText(rs.getString(11)+"");
			}
			String p1="select * from opd_sub where opd_id='"+EditPatient.oid+"' order by opdsub_id desc";
			PreparedStatement stm1=con.prepareStatement(p1);
			ResultSet rs1=stm1.executeQuery();
			while(rs1.next())
			{
				subid=rs1.getInt(1);
				dateChooser.setDate(rs1.getDate(4));
				ptype=rs1.getString(5);
				pservice=rs1.getString(6);
			}
		}
		catch(Exception e){
			
		}
		
		
	}
	public static void main(String args[]){
		create();
		
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new EditOpd());
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
