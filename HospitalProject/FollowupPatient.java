package com.java.HospitalProject;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingConstants;

public class FollowupPatient extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	public static int pid;
	public static String oid;

	
	public FollowupPatient() {
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("      NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(325, 5, 712, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FollowupPatient.class.getResource("/images/editRecord.png")));
		label.setBounds(116, 223, 398, 353);
		add(label);
		
		
		JLabel lblNewLabel = new JLabel("Enter OPD Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(615, 253, 273, 47);
		add(lblNewLabel);
		
		TextField textField = new TextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBounds(642, 357, 211, 54);
		add(textField);
		
		Button button = new Button("SUBMIT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
						String s="select patient_id,opd_id from opd_reg where opd_id=?";
						Connection con=ConnectToDB.getCon();
						PreparedStatement pst=con.prepareStatement(s);
						pst.setString(1,textField.getText());
						ResultSet rs1=pst.executeQuery(); 
						int count=0;
						while(rs1.next())
						{
							pid=rs1.getInt(1);
							oid=rs1.getString(2);
							count=count+1;
						}
						if(count==1)
						{
							f.dispose();
							FollowupOptionWindow.create();
						}
						else{
							JOptionPane.showMessageDialog(null,"opd id is not exist...!");
							
						}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Something went wrong.....SORRY!!");
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(683, 467, 123, 47);
		add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FollowupPatient.class.getResource("/images/sidebar1.png")));
		label_1.setBounds(1066, 190, 78, 413);
		add(label_1);
		
		Button button_1 = new Button("BACK");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(243, 107, 123, 47);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddTypeWindow.create();
			}
		});
		
		Button button_2 = new Button("LogOut");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(1021, 107, 123, 47);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FollowupPatient.class.getResource("/images/seperator.png")));
		label_2.setBounds(524, 189, 46, 427);
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FollowupPatient.class.getResource("/images/seperator.png")));
		label_3.setBounds(930, 189, 46, 427);
		add(label_3);
		
		Button button_3 = new Button("HOME");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_3.setBounds(661, 107, 123, 47);
		add(button_3);
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new FollowupPatient());
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
