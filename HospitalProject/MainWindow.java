package com.java.HospitalProject;
//this main window file consist of login window button and creator window button with two main labels.

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;

	public MainWindow() {
		setSize(1375,768);
		setLayout(null);//this is for getting automatic frame size
		
		//top label
		JLabel lblNitaveHospital = new JLabel("                      NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(0, 21, 1362, 76);
		lblNitaveHospital.setForeground(Color.BLACK);
		lblNitaveHospital.setBackground(Color.WHITE);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 65));
		add(lblNitaveHospital);
		
		//bottom label
		
		JLabel lblMainLabel = new JLabel("     HOSPITAL MANAGEMENT SYSTEM");
		lblMainLabel.setBounds(0, 607, 1362, 79);
		lblMainLabel.setBackground(new Color(0, 255, 255));
		lblMainLabel.setFont(new Font("Tahoma", Font.BOLD, 65));
		add(lblMainLabel);
		
		//login label and button with login icon
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLogin.setBounds(320, 504, 100, 50);
		add(lblLogin);
		
		
		JButton logbutton = new JButton("");
		logbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				LoginWindow.create();
			}
		});
		logbutton.setIcon(new ImageIcon(MainWindow.class.getResource("/images/login.png")));
		logbutton.setBounds(177, 143, 393, 350);
		add(logbutton);
		
		
		//Creator label and button with creator icon
		
		JLabel lblCreators = new JLabel("CREATORS");
		lblCreators.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCreators.setBounds(914, 504, 170, 50);
		add(lblCreators);
		
		JButton creatorButton = new JButton("");
		creatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
					f.dispose();
					Creators.create();
				}
			}
		);
		creatorButton.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Creators.png")));
		creatorButton.setBounds(797, 143, 393, 350);
		add(creatorButton);
		
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new MainWindow());
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
