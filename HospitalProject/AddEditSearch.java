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

public class AddEditSearch extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;

	
	public AddEditSearch() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("                         NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(47, 8, 967, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JButton editbtn = new JButton("");
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				f.dispose();
				EditPatient.create();
			}
		});
		editbtn.setIcon(new ImageIcon(AddEditSearch.class.getResource("/images/edit.png")));
		editbtn.setBounds(502, 130, 364, 353);
		add(editbtn);
		editbtn.setFocusPainted(false);
		editbtn.setContentAreaFilled(false);
		
		
		JButton addbtn = new JButton("");
		addbtn.setIcon(new ImageIcon(AddEditSearch.class.getResource("/images/add.png")));
		addbtn.setBounds(47, 135, 364, 348);
		add(addbtn);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddTypeWindow.create();
			}
		});
		addbtn.setFocusPainted(false);
		addbtn.setContentAreaFilled(false);
		
		JButton searchbtn = new JButton("");
		searchbtn.setIcon(new ImageIcon(AddEditSearch.class.getResource("/images/search.png")));
		searchbtn.setBounds(962, 135, 364, 348);
		add(searchbtn);
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				SearchNextWindow.create();
			}
		});
		searchbtn.setFocusPainted(false);
		searchbtn.setContentAreaFilled(false);
		
		JLabel lblEdit = new JLabel("EDIT RECORD");
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblEdit.setBounds(554, 513, 288, 81);
		add(lblEdit);
		
		
		JLabel lblAddRecord = new JLabel("ADD RECORD");
		lblAddRecord.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblAddRecord.setBounds(102, 513, 282, 81);
		
		add(lblAddRecord);
		
		JLabel lblSearchRecord = new JLabel("SEARCH RECORD");
		lblSearchRecord.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSearchRecord.setBounds(962, 513, 347, 81);
		add(lblSearchRecord);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setBounds(1150, 643, 176, 55);
		add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
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
		f.getContentPane().add(new AddEditSearch());
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
