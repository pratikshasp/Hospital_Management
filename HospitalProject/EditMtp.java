package com.java.HospitalProject;

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

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;

public class EditMtp extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField duration;
	private JTextField result;
	private JTextField remark;
	private JTextField religion;
	private int mtpId;
	private JTextField DaughterOf;
	private JTextField textName;
	private JTextField txtpatientid;
	Connection con=ConnectToDB.getCon();
	
	public EditMtp() {
		
		
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
		
		JLabel lblNameOfChild = new JLabel("Date of Admit");
		lblNameOfChild.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNameOfChild.setBounds(160, 339, 235, 31);
		add(lblNameOfChild);
		
		JLabel lblTime = new JLabel("Date of Discharge");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTime.setBounds(160, 392, 269, 33);
		add(lblTime);
		
		JLabel lblCast = new JLabel("Duration of Pregency");
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCast.setBounds(160, 443, 320, 31);
		add(lblCast);
		
		duration = new JTextField();
		duration.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duration.setColumns(10);
		duration.setBounds(490, 446, 266, 33);
		add(duration);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MTP_Reg.class.getResource("/images/sidebar10.png")));
		label_1.setBounds(44, 231, 69, 353);
		add(label_1);
		
		JLabel lblTreatment = new JLabel("Result");
		lblTreatment.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTreatment.setBounds(160, 553, 235, 31);
		add(lblTreatment);
		
		JLabel lblDateOfTermination = new JLabel("Date of Termination");
		lblDateOfTermination.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDateOfTermination.setBounds(160, 500, 308, 31);
		add(lblDateOfTermination);
		
		result = new JTextField();
		result.setFont(new Font("Tahoma", Font.PLAIN, 20));
		result.setColumns(10);
		result.setBounds(490, 551, 429, 33);
		add(result);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRemark.setBounds(160, 606, 235, 31);
		add(lblRemark);
		
		remark = new JTextField();
		remark.setFont(new Font("Tahoma", Font.PLAIN, 20));
		remark.setColumns(10);
		remark.setBounds(490, 601, 429, 33);
		add(remark);
		
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblReligion.setBounds(160, 295, 235, 31);
		add(lblReligion);
		
		religion = new JTextField("");
		religion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		religion.setColumns(10);
		religion.setBounds(490, 295, 266, 33);
		add(religion);
		
		
		
		JDateChooser date_of_admit = new JDateChooser();
		date_of_admit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		date_of_admit.setDateFormatString("ddMMMyyyy");
		date_of_admit.setBounds(490, 339, 266, 31);
		add(date_of_admit);
		date_of_admit.getDateEditor().setEnabled(false);
		date_of_admit.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JDateChooser date_of_discharge = new JDateChooser();
		date_of_discharge.setDateFormatString("ddMMMyyyy");
		date_of_discharge.setBounds(490, 392, 266, 31);
		add(date_of_discharge);
		date_of_discharge.getDateEditor().setEnabled(false);
		date_of_discharge.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JDateChooser date_of_termi = new JDateChooser();
		date_of_termi.setDateFormatString("ddMMMyyyy");
		date_of_termi.setBounds(490, 500, 266, 31);
		add(date_of_termi);
		date_of_termi.getDateEditor().setEnabled(false);
		date_of_termi.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		Button button = new Button("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				EditNextWindow.create();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(160, 101, 140, 49);
		add(button);
		
		Button button_1 = new Button("Log Out");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(1015, 101, 140, 49);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		JButton button_2 = new JButton("SUBMIT");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(601, 648, 147, 49);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
						try{
						String d1  = ((JTextField)date_of_admit.getDateEditor().getUiComponent()).getText();
						String d2  = ((JTextField)date_of_discharge.getDateEditor().getUiComponent()).getText();
						String d3  = ((JTextField)date_of_termi.getDateEditor().getUiComponent()).getText();
						String n="UPDATE mtp_reg SET daughter_of='"+DaughterOf.getText()+"',religion='"+religion.getText()+"',date_admission='"+d1+"',date_discharge='"+d2+"',pregnancy_duration='"+duration.getText()+"',date_termination='"+d3+"',result='"+result.getText()+"',remark='"+remark.getText()+"' Where mtp_id="+mtpId;
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
		button_3.setBounds(608, 101, 140, 49);
		add(button_3);
		
		JLabel lblDaughterOf = new JLabel("Daughter of");
		lblDaughterOf.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDaughterOf.setBounds(160, 248, 235, 31);
		add(lblDaughterOf);
		
		DaughterOf = new JTextField("");
		DaughterOf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DaughterOf.setColumns(10);
		DaughterOf.setBounds(490, 248, 266, 33);
		add(DaughterOf);
		DaughterOf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		
		textName = new JTextField("");
		textName.setEditable(false);
		textName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textName.setColumns(10);
		textName.setBounds(490, 204, 429, 33);
		add(textName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblName.setBounds(160, 204, 235, 31);
		add(lblName);
		
		txtpatientid = new JTextField("");
		txtpatientid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpatientid.setEditable(false);
		txtpatientid.setColumns(10);
		txtpatientid.setBounds(490, 160, 266, 33);
		add(txtpatientid);
		
		JLabel lblPatientId = new JLabel("Patient Id");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPatientId.setBounds(160, 160, 235, 31);
		add(lblPatientId);
		

		button_3.addActionListener(new ActionListener() {
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
				
				txtpatientid.setText(rs1.getInt(1)+"");
				textName.setText(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));

				
			}
			s="select * from mtp_reg where opd_id='"+EditPatient.oid+"' and patient_id="+EditPatient.pid;
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				mtpId=rs1.getInt(1);
				DaughterOf.setText(rs1.getString(4));
				religion.setText(rs1.getString(5));
				date_of_admit.setDate(rs1.getDate(6));
				date_of_discharge.setDate(rs1.getDate(7));
				duration.setText(rs1.getString(8));
				date_of_termi.setDate(rs1.getDate(9));
				result.setText(rs1.getString(10));
				remark.setText(rs1.getString(11));
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
		f.getContentPane().add(new EditMtp());
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
