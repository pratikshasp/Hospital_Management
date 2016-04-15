package com.java.HospitalProject;


import java.awt.Color;
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

public class Creators extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;

	
	public Creators() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("                      NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(0, 0, 1362, 76);
		lblNitaveHospital.setForeground(Color.BLACK);
		lblNitaveHospital.setBackground(Color.WHITE);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 63));
		add(lblNitaveHospital);
		
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setIcon(new ImageIcon(Creators.class.getResource("/images/c3.png")));
		button.setBounds(36, 351, 217, 210);
		add(button);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Creators.class.getResource("/images/c4.png")));
		button_1.setBounds(665, 87, 211, 204);
		add(button_1);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Creators.class.getResource("/images/c1.png")));
		button_2.setBounds(665, 347, 216, 210);
		add(button_2);
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Creators.class.getResource("/images/c2.png")));
		button_3.setBounds(36, 87, 211, 204);
		add(button_3);
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		
		JLabel lblMrAkshayGaikwad = new JLabel("Akshay Gaikwad");
		lblMrAkshayGaikwad.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMrAkshayGaikwad.setBounds(319, 87, 217, 37);
		add(lblMrAkshayGaikwad);
		
		JLabel lblMrSameerZilpilwar = new JLabel("Sameer Zilpilwar");
		lblMrSameerZilpilwar.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMrSameerZilpilwar.setBounds(319, 351, 230, 37);
		add(lblMrSameerZilpilwar);
		
		JLabel lblMsPratikshaParsewar = new JLabel("Pratiksha Parsewar");
		lblMsPratikshaParsewar.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMsPratikshaParsewar.setBounds(1003, 87, 265, 37);
		add(lblMsPratikshaParsewar);
		
		JLabel lblShivprasadJamdade = new JLabel("Shivprasad Jamdade");
		lblShivprasadJamdade.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblShivprasadJamdade.setBounds(1003, 365, 275, 37);
		add(lblShivprasadJamdade);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBounds(528, 586, 149, 54);
		add(btnBack);
		
		JLabel lblMobile = new JLabel("Mobile :  8308374934");
		lblMobile.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblMobile.setBounds(320, 395, 217, 37);
		add(lblMobile);
		
		JLabel lblMobile_1 = new JLabel("Mobile :  9404609954");
		lblMobile_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblMobile_1.setBounds(320, 145, 217, 37);
		add(lblMobile_1);
		
		JLabel lblMobile_2 = new JLabel("Mobile :  8626028332");
		lblMobile_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblMobile_2.setBounds(1003, 145, 217, 37);
		add(lblMobile_2);
		
		JLabel lblMobile_3 = new JLabel("Mobile :  9823353456");
		lblMobile_3.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblMobile_3.setBounds(1003, 413, 217, 37);
		add(lblMobile_3);
		
		JLabel lblEmail = new JLabel("Email : akshayakgaikwad@gmail.com");
		lblEmail.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblEmail.setBounds(319, 193, 318, 28);
		add(lblEmail);
		
		JLabel lblEmailzilpilwarsameergmailcom = new JLabel("Email :zilpilwar.sameer0@gmail.com");
		lblEmailzilpilwarsameergmailcom.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblEmailzilpilwarsameergmailcom.setBounds(319, 449, 319, 28);
		add(lblEmailzilpilwarsameergmailcom);
		
		JLabel lblEmailpratikshaparsewargmailcom = new JLabel("Email :pratiksha.parsewar20@gmail.com");
		lblEmailpratikshaparsewargmailcom.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblEmailpratikshaparsewargmailcom.setBounds(1003, 193, 318, 28);
		add(lblEmailpratikshaparsewargmailcom);
		
		JLabel lblEmailjshivprasadgmailcom = new JLabel("Email : jshivprasad007@gmail.com");
		lblEmailjshivprasadgmailcom.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblEmailjshivprasadgmailcom.setBounds(1003, 461, 295, 28);
		add(lblEmailjshivprasadgmailcom);
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new Creators());
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
