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
import javax.swing.SwingConstants;

public class SearchNextWindow extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;

	
	public SearchNextWindow() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("                         NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(47, 3, 967, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBounds(711, 606, 171, 55);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		JButton button_5 = new JButton("Log out");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_5.setBounds(1105, 606, 176, 55);
		add(button_5);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				SearchPatient.create();
			}
		});
		button.setIcon(new ImageIcon(SearchNextWindow.class.getResource("/images/editRecord.png")));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBounds(499, 133, 364, 348);
		add(button);
		
		JLabel lblPatientSearch = new JLabel("Patient Search");
		lblPatientSearch.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPatientSearch.setBounds(542, 492, 301, 81);
		add(lblPatientSearch);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPanel.create();
			}
		});
		button_1.setIcon(new ImageIcon(SearchNextWindow.class.getResource("/images/edit.png")));
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(933, 133, 364, 348);
		add(button_1);
		
		JLabel lblRegisters = new JLabel("REGISTERS");
		lblRegisters.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblRegisters.setBounds(1005, 492, 240, 81);
		add(lblRegisters);
		
		JLabel lblFindId = new JLabel("Find ID");
		lblFindId.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindId.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblFindId.setBounds(114, 492, 301, 81);
		add(lblFindId);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				SearchIDResult.create();
			}
		});
		button_2.setIcon(new ImageIcon(SearchNextWindow.class.getResource("/images/idSearch.png")));
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setBounds(71, 133, 364, 348);
		add(button_2);
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new SearchNextWindow());
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
