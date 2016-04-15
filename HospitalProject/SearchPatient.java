package com.java.HospitalProject;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import javax.swing.SwingConstants;

public class SearchPatient extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	public static int pid;
	public static String oid;
	Connection con=ConnectToDB.getCon();
	
	public SearchPatient() {
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("          NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(265, 11, 712, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SearchPatient.class.getResource("/images/editRecord.png")));
		label.setBounds(50, 226, 398, 353);
		add(label);
		
		JLabel lblNewLabel = new JLabel("Enter OPD Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(611, 253, 273, 47);
		add(lblNewLabel);
		
		TextField textField = new TextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField.setBounds(646, 367, 196, 54);
		add(textField);
		
		Button button = new Button("SEARCH");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String s="select patient_id,opd_id from opd_reg where opd_id=?";
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
						SearchDetailType.create();
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
		button.setBounds(680, 495, 131, 47);
		add(button);
		
		Button button_1 = new Button("BACK");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(226, 125, 123, 47);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				SearchNextWindow.create();
			}
		});
		
		Button button_2 = new Button("LogOut");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(1032, 125, 123, 47);
		add(button_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SearchPatient.class.getResource("/images/sidebar7.png")));
		label_1.setBounds(1062, 197, 75, 408);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchPatient.class.getResource("/images/seperator.png")));
		label_2.setBounds(475, 182, 46, 427);
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(SearchPatient.class.getResource("/images/seperator.png")));
		label_3.setBounds(975, 182, 46, 427);
		add(label_3);
		
		Button button_3 = new Button("HOME");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_3.setBounds(661, 125, 123, 47);
		add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new SearchPatient());
		WindowUtil.setToCenter(f, WindowUtil.getScreenWidth(), WindowUtil.getScreenHeight());
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//int ret=JOptionPane.showConfirmDialog(f, "Are you sure?");
				f.setVisible(false);
				f.dispose();
			}
		});
		f.setVisible(true);
	}
}
