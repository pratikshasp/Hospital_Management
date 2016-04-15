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

import javax.swing.JButton;

public class FollowupOptionWindow extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;

	
	public FollowupOptionWindow() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("                         NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(47, 3, 967, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBounds(1155, 640, 176, 55);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				FollowupPatient.create();
			}
		});

		JButton btnHome= new JButton("HOME");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnHome.setBounds(1155, 549, 176, 55);
		add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				IpdReg.create();
			}
		});
		button.setIcon(new ImageIcon(FollowupOptionWindow.class.getResource("/images/indoor1.png")));
		button.setBounds(443, 79, 274, 274);
		
		add(button);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(FollowupOptionWindow.class.getResource("/images/opd1.png")));
		button_1.setBounds(90, 78, 274, 274);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				OpdReg1.create();
			}
		});
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(FollowupOptionWindow.class.getResource("/images/mtp1.png")));
		button_2.setBounds(807, 79, 274, 274);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MTP_Reg.create();
			}
		});
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(FollowupOptionWindow.class.getResource("/images/ANC1.png")));
		button_3.setBounds(90, 397, 274, 274);
		add(button_3);
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AncReg.create();
			}
		});
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(FollowupOptionWindow.class.getResource("/images/baby.png")));
		button_4.setBounds(443, 397, 274, 274);
		add(button_4);
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				DeliveryReg.create();
			}
		});
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		
		JButton button_5 = new JButton("Log out");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_5.setBounds(1155, 448, 176, 55);
		add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		
		JLabel lblIpd = new JLabel("IPD");
		lblIpd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIpd.setBounds(551, 357, 52, 29);
		add(lblIpd);
		
		JLabel lblOpd = new JLabel("OPD");
		lblOpd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOpd.setBounds(192, 357, 52, 29);
		add(lblOpd);
		
		JLabel lblMtp = new JLabel("MTP");
		lblMtp.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMtp.setBounds(922, 357, 52, 29);
		add(lblMtp);
		
		JLabel lblAnc = new JLabel("ANC");
		lblAnc.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAnc.setBounds(177, 678, 52, 29);
		add(lblAnc);
		
		JLabel lblBirthRecord = new JLabel("DELIVERY");
		lblBirthRecord.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBirthRecord.setBounds(499, 679, 130, 29);
		add(lblBirthRecord);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(FollowupOptionWindow.class.getResource("/images/ot1.png")));
		button_6.setFocusPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setBounds(807, 402, 274, 274);
		add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				OT_Reg.create();
			}
		});
		
		JLabel label = new JLabel("OPERATION");
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(867, 678, 153, 29);
		add(label);
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new FollowupOptionWindow());
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
