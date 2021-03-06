package com.java.HospitalProject;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTypeWindow extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;

	
	public AddTypeWindow() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("                         NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(10, 11, 967, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		
		JButton addbtn = new JButton("");
		addbtn.setIcon(new ImageIcon(AddTypeWindow.class.getResource("/images/add.png")));
		addbtn.setBounds(197, 135, 364, 348);
		add(addbtn);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				OpdReg.create();
			}
		});
		addbtn.setFocusPainted(false);
		addbtn.setContentAreaFilled(false);
		
		JButton searchbtn = new JButton("");
		searchbtn.setIcon(new ImageIcon(AddTypeWindow.class.getResource("/images/editRecord.png")));
		searchbtn.setBounds(793, 135, 364, 348);
		add(searchbtn);
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				FollowupPatient.create();
			}
		});
		searchbtn.setFocusPainted(false);
		searchbtn.setContentAreaFilled(false);
		
		
		JLabel lblAddRecord = new JLabel("NEW RECORD");
		lblAddRecord.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblAddRecord.setBounds(243, 494, 282, 81);
		
		add(lblAddRecord);
		
		JLabel lblSearchRecord = new JLabel("FOLLOWUP");
		lblSearchRecord.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSearchRecord.setBounds(874, 494, 240, 81);
		add(lblSearchRecord);
		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setBounds(1148, 629, 176, 55);
		add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		
		
		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 30));
		backbtn.setBounds(858, 629, 176, 55);
		add(backbtn);
		
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new AddTypeWindow());
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
