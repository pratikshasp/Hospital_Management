package com.java.HospitalProject;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;

public class MTP_Reg extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField txtpatientid;
	private JTextField textName;
	private JTextField DaughterOf;
	private JTextField religion;
	private JTextField duration;
	private JTextField result;
	private JTextField remark;
	private int mtpId;
	Connection con=ConnectToDB.getCon();
	
	public MTP_Reg() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(441, 5, 629, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MTP_Reg.class.getResource("/images/Mtp.png")));
		label.setBounds(909, 206, 360, 353);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MTP_Reg.class.getResource("/images/sidebar10.png")));
		label_1.setBounds(44, 231, 69, 353);
		add(label_1);
		
		JLabel label_2 = new JLabel("Patient Id");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_2.setBounds(159, 162, 235, 31);
		add(label_2);
		
		txtpatientid = new JTextField("");
		txtpatientid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpatientid.setEditable(false);
		txtpatientid.setColumns(10);
		txtpatientid.setBounds(489, 162, 266, 33);
		add(txtpatientid);
		
		textName = new JTextField("");
		textName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textName.setEditable(false);
		textName.setColumns(10);
		textName.setBounds(489, 206, 429, 33);
		add(textName);
		
		DaughterOf = new JTextField("");
		DaughterOf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DaughterOf.setColumns(10);
		DaughterOf.setBounds(489, 250, 266, 33);
		add(DaughterOf);
		
		religion = new JTextField("");
		religion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		religion.setColumns(10);
		religion.setBounds(489, 297, 266, 33);
		add(religion);
		
		JDateChooser date_of_admit = new JDateChooser();
		date_of_admit.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		date_of_admit.setDateFormatString("ddMMMyyyy");
		date_of_admit.getDateEditor().setEnabled(false);
		date_of_admit.setBounds(489, 341, 266, 31);
		add(date_of_admit);
		
		JDateChooser date_of_discharge = new JDateChooser();
		date_of_discharge.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		date_of_discharge.setDateFormatString("ddMMMyyyy");
		date_of_discharge.getDateEditor().setEnabled(false);
		date_of_discharge.setBounds(489, 394, 266, 31);
		add(date_of_discharge);
		
		duration = new JTextField();
		duration.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duration.setColumns(10);
		duration.setBounds(489, 448, 266, 33);
		add(duration);
		
		JDateChooser date_of_termi = new JDateChooser();
		date_of_termi.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		date_of_termi.setDateFormatString("ddMMMyyyy");
		date_of_termi.setBounds(489, 502, 266, 31);
		date_of_termi.getDateEditor().setEnabled(false);
		add(date_of_termi);
		
		result = new JTextField();
		result.setFont(new Font("Tahoma", Font.PLAIN, 20));
		result.setColumns(10);
		result.setBounds(489, 553, 429, 33);
		add(result);
		
		remark = new JTextField();
		remark.setFont(new Font("Tahoma", Font.PLAIN, 20));
		remark.setColumns(10);
		remark.setBounds(489, 603, 429, 33);
		add(remark);
		
		JLabel label_3 = new JLabel("Remark");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_3.setBounds(159, 608, 235, 31);
		add(label_3);
		
		JLabel label_4 = new JLabel("Result");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_4.setBounds(159, 555, 235, 31);
		add(label_4);
		
		JLabel label_5 = new JLabel("Date of Termination");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_5.setBounds(159, 502, 308, 31);
		add(label_5);
		
		JLabel label_6 = new JLabel("Duration of Pregency");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_6.setBounds(159, 445, 320, 31);
		add(label_6);
		
		JLabel label_7 = new JLabel("Date of Discharge");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_7.setBounds(159, 394, 269, 33);
		add(label_7);
		
		JLabel label_8 = new JLabel("Date of Admit");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_8.setBounds(159, 341, 235, 31);
		add(label_8);
		
		JLabel label_9 = new JLabel("Religion");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_9.setBounds(159, 297, 235, 31);
		add(label_9);
		
		JLabel label_10 = new JLabel("Daughter of");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_10.setBounds(159, 250, 235, 31);
		add(label_10);
		
		JLabel label_11 = new JLabel("Name");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_11.setBounds(159, 206, 235, 31);
		add(label_11);
		
		JButton button_2 = new JButton("SUBMIT");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(600, 647, 147, 49);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
							
						String d1  = ((JTextField)date_of_admit.getDateEditor().getUiComponent()).getText();
						String d2  = ((JTextField)date_of_discharge.getDateEditor().getUiComponent()).getText();
						String d3  = ((JTextField)date_of_termi.getDateEditor().getUiComponent()).getText();
						PreparedStatement psmt=con.prepareStatement("insert into Mtp_Reg values(?,?,?,?,?,?,?,?,?,?,?)");
						psmt.setInt(1,mtpId);
						psmt.setInt(2,FollowupPatient.pid);
						psmt.setString(3,FollowupPatient.oid);
						psmt.setString(4,WindowUtil.capitalize(DaughterOf.getText()));
						psmt.setString(5,WindowUtil.capitalize(religion.getText()));
						psmt.setString(6,d1);
						psmt.setString(7,d2);
						psmt.setString(8,duration.getText());
						psmt.setString(9,d3);
						psmt.setString(10,result.getText());
						psmt.setString(11,remark.getText());
						psmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Record Inserted...!");
						f.dispose();
						FollowupOptionWindow.create();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Record is not Inserted correctly...!");
						e1.printStackTrace();
					}
				}
		});
		
		Button button_3 = new Button("HOME");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_3.setBounds(607, 96, 140, 49);
		add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		Button button = new Button("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				FollowupOptionWindow.create();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(159, 96, 140, 49);
		add(button);
		
		Button button_1 = new Button("Log Out");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(1014, 96, 140, 49);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		try {
			String s="select max(mtp_id) from mtp_reg";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery(); 
			rs1.next();
			mtpId=rs1.getInt(1)+1;
			s="select patient_id,patient_name,husband_name,father_name,surname from opd_reg where opd_id='"+FollowupPatient.oid+"'";
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				txtpatientid.setText(rs1.getInt(1)+"");
				textName.setText(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
				
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
		f.getContentPane().add(new MTP_Reg());
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
