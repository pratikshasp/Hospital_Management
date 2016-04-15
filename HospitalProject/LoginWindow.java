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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JPasswordField passwordField;
	private JTextField user;

	
	public LoginWindow() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("               NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(216, 5, 930, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginWindow.class.getResource("/images/form1.png")));
		label.setBounds(23, 160, 360, 349);
		add(label);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUserName.setBounds(449, 222, 175, 58);
		add(lblUserName);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 23));
		user.setBounds(713, 222, 359, 58);
		add(user);
		//user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(458, 366, 153, 58);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passwordField.setBounds(713, 366, 359, 58);
		add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnLogin.setBounds(640, 579, 175, 58);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(user.getText().trim().length()==0 || passwordField.getText().length()==0){
					JOptionPane.showMessageDialog(null,"Fill Both the Fields.......");
				}
				else{           
					try
					{
						String s="select * from login_tab where username=? and pass_word=?";
						Connection con=ConnectToDB.getCon();
						PreparedStatement pst=con.prepareStatement(s);
						pst.setString(1,user.getText());
						pst.setString(2,passwordField.getText());
						ResultSet rs1=pst.executeQuery(); 
						int count=0;
						while(rs1.next())
						{
							count=count+1;
						}
						if(count==1)
						{
							f.dispose();
							AddEditSearch.create();
						}
						else{
							JOptionPane.showMessageDialog(null,"username and pasword is incorrect try again....");
							
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
		}
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnBack.setBounds(985, 579, 175, 58);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new LoginWindow());
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
