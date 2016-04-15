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

import javax.swing.JTextField;

import java.awt.Button;

import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;

public class OpdReg1 extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTextField opd_id;
	private JTextField address_per;
	private JTextField address_m;
	private JTextField pname;
	private JTextField phname;
	private JTextField phfname;
	private JTextField psname;
	private JTextField address_p;
	private JTextField age;
	private JTextField phone_no;
	private Button button_2;
	private JTextField txtpatient_id;
	Connection con=ConnectToDB.getCon();
	int takeid;
	public static String ptype="";
	public static String pservice="";
	
	public OpdReg1() {
		
		
		setSize(1375,768);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("NITAVE HOSPITAL");
		lblNitaveHospital.setBounds(441, 5, 629, 70);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 58));
		add(lblNitaveHospital);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OpdReg1.class.getResource("/images/form1.png")));
		label.setBounds(983, 206, 379, 360);
		add(label);
		
		JLabel lblOpdId = new JLabel("OPD id");
		lblOpdId.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblOpdId.setBounds(514, 221, 108, 31);
		add(lblOpdId);
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDate.setBounds(133, 280, 140, 31);
		add(lblDate);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblName.setBounds(130, 336, 164, 31);
		add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAddress.setBounds(129, 391, 118, 31);
		add(lblAddress);
		
		opd_id = new JTextField();
		opd_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opd_id.setBounds(642, 222, 215, 33);
		add(opd_id);
		opd_id.setColumns(10);
		opd_id.setEditable(false);
		
		address_per = new JTextField();
		address_per.setEditable(false);
		address_per.setForeground(Color.BLACK);
		address_per.setHorizontalAlignment(SwingConstants.CENTER);
		address_per.addFocusListener(new FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				address_per.setText("");
				address_per.setForeground(Color.BLACK);
				address_per.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		address_per.setFont(new Font("Tahoma", Font.PLAIN, 20));
		address_per.setColumns(10);
		address_per.setBounds(275, 392, 692, 33);
		add(address_per);
		
		
		Button button = new Button("BACK");
		button.setFont(new Font("Tahoma", Font.BOLD, 28));
		button.setBounds(254, 103, 140, 49);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				FollowupOptionWindow.create();
			}
		});
		
		Button button_1 = new Button("LogOut");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(877, 103, 140, 49);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				MainWindow.create();
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(OpdReg1.class.getResource("/images/sidebar8.png")));
		label_1.setBounds(31, 232, 69, 353);
		add(label_1);
		
		address_m = new JTextField();
		address_m.setEditable(false);
		address_m.setForeground(Color.BLACK);
		address_m.setHorizontalAlignment(SwingConstants.CENTER);
		address_m.addFocusListener(new FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e1) {
				address_m.setText("");
				address_m.setForeground(Color.BLACK);
				address_m.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		address_m.setFont(new Font("Tahoma", Font.PLAIN, 20));
		address_m.setColumns(10);
		address_m.setBounds(275, 453, 692, 33);
		add(address_m);
		
		pname = new JTextField("");
		pname.setEditable(false);
		pname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				pname.setText("");
				pname.setForeground(Color.BLACK);
				pname.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		pname.setHorizontalAlignment(SwingConstants.CENTER);
		pname.setForeground(Color.BLACK);
		pname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pname.setColumns(10);
		pname.setBounds(276, 336, 170, 33);
		add(pname);
		pname.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		
		
		phname = new JTextField("");
		phname.setEditable(false);
		phname.addFocusListener(new FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				phname.setText("");
				phname.setForeground(Color.BLACK);
				phname.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		phname.setHorizontalAlignment(SwingConstants.CENTER);
		phname.setForeground(Color.BLACK);
		phname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phname.setColumns(10);
		phname.setBounds(468, 337, 164, 33);
		add(phname);
		phname.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		
		phfname = new JTextField("");
		phfname.setEditable(false);
		phfname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				phfname.setText("");
				phfname.setForeground(Color.BLACK);
				phfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		phfname.setHorizontalAlignment(SwingConstants.CENTER);
		phfname.setForeground(Color.BLACK);
		phfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phfname.setColumns(10);
		phfname.setBounds(642, 337, 147, 33);
		add(phfname);
		phfname.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		
		psname = new JTextField("");
		psname.setEditable(false);
		psname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				psname.setText("");
				psname.setForeground(Color.BLACK);
				psname.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		psname.setHorizontalAlignment(SwingConstants.CENTER);
		psname.setForeground(Color.BLACK);
		psname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		psname.setColumns(10);
		psname.setBounds(799, 337, 164, 33);
		add(psname);
		psname.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		
		address_p = new JTextField();
		address_p.setEditable(false);
		address_p.setForeground(Color.BLACK);
		address_p.setHorizontalAlignment(SwingConstants.CENTER);
		address_p.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				address_p.setText("");
				address_p.setForeground(Color.BLACK);
				address_p.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		address_p.setFont(new Font("Tahoma", Font.PLAIN, 20));
		address_p.setColumns(10);
		address_p.setBounds(275, 510, 692, 33);
		add(address_p);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAge.setBounds(129, 566, 95, 31);
		add(lblAge);
		
		age = new JTextField();
		age.setEditable(false);
		age.setFont(new Font("Tahoma", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(204, 567, 118, 33);
		add(age);
		age.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		
		JLabel lblPhoneNo = new JLabel("Phone no.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPhoneNo.setBounds(360, 566, 140, 31);
		add(lblPhoneNo);
		
		phone_no = new JTextField();
		phone_no.setEditable(false);
		phone_no.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
		phone_no.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phone_no.setColumns(10);
		phone_no.setBounds(514, 567, 164, 33);
		add(phone_no);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getDateEditor().setEnabled(false);
		dateChooser.getDateEditor().getUiComponent().setFont(new Font("Tahoma", Font.PLAIN, 24));
		dateChooser.setDateFormatString("ddMMMyyy");
		dateChooser.setBounds(279, 279, 215, 31);
		add(dateChooser);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnSubmit.setBounds(531, 628, 147, 49);
		add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try{
							String s="select opd_id from opd_reg where opd_id=?";
							PreparedStatement pst=con.prepareStatement(s);
							pst.setString(1,FollowupPatient.oid);
							ResultSet rs1=pst.executeQuery(); 
							int count=0;
							while(rs1.next())
							{
								count=count+1;
							}
							if(count!=0)
							{
								if(!FollowupPatient.oid.equals(opd_id.getText()))
								{ 
									PreparedStatement psmt=con.prepareStatement("insert into opd_reg values(?,?,?,?,?,?,?,?,?,?,?)");
									psmt.setInt(1, FollowupPatient.pid);
									psmt.setString(2,opd_id.getText());
									psmt.setString(3,pname.getText());
									psmt.setString(4,phname.getText());
									psmt.setString(5,phfname.getText());
									psmt.setString(6,psname.getText());
									psmt.setString(7,address_per.getText());
									psmt.setString(8,address_p.getText());
									psmt.setString(9,address_m.getText());
									psmt.setInt(10,Integer.parseInt(age.getText()));
									psmt.setString(11,phone_no.getText());
									psmt.executeQuery();
									String d1  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); 
									psmt=con.prepareStatement("insert into opd_sub values(?,?,?,?,?,?)");
									psmt.setInt(1,takeid);
									psmt.setInt(2,Integer.parseInt(txtpatient_id.getText()));
									psmt.setString(3,opd_id.getText());
									psmt.setString(4,d1);
									psmt.setString(5,Services1.s);
									psmt.setString(6,Services1.p);
									psmt.executeQuery();
									JOptionPane.showMessageDialog(null, "Record Inserted...!");
									f.dispose();
									FollowupPatient.create();
								}	
								else {
									String d1  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); 
									PreparedStatement psmt=con.prepareStatement("insert into opd_sub values(?,?,?,?,?,?)");
									psmt.setInt(1,takeid);
									psmt.setInt(2,Integer.parseInt(txtpatient_id.getText()));
									psmt.setString(3,opd_id.getText());
									psmt.setString(4,d1);
									psmt.setString(5,Services1.s);
									psmt.setString(6,Services1.p);
									psmt.executeQuery();
									JOptionPane.showMessageDialog(null, "Record Inserted...!");
									f.dispose();
									FollowupOptionWindow.create();
								}
							}
							else{
								JOptionPane.showMessageDialog(null,"opd id is already exist......");	
							}							
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Record is not Inserted correctly...!");
						e1.printStackTrace();
					}
				}
		});
		
		button_2 = new Button("HOME");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_2.setBounds(584, 103, 140, 49);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		JLabel lblPatientId = new JLabel("Patient Id");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPatientId.setBounds(133, 221, 140, 31);
		add(lblPatientId);
		
		txtpatient_id = new JTextField();
		txtpatient_id.setEditable(false);
		txtpatient_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpatient_id.setColumns(10);
		txtpatient_id.setBounds(277, 221, 215, 33);
		add(txtpatient_id);
		
		JButton button_3 = new JButton("Type and Services");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services1.create();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 26));
		button_3.setBounds(554, 273, 303, 38);
		add(button_3);
		txtpatient_id.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE))
				{
					getToolkit().beep();;
					e.consume();
				}
			}
		});
	
		
		try {
			String s="select * from opd_reg where opd_id='"+FollowupPatient.oid+"'";
			String p="select max(opdsub_id) from opd_sub";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				txtpatient_id.setText(rs1.getInt(1)+"");
				opd_id.setText(rs1.getString(2)+"");
				pname.setText(rs1.getString(3));
				phname.setText(rs1.getString(4));
				phfname.setText(rs1.getString(5));
				psname.setText(rs1.getString(6));
				address_per.setText(rs1.getString(7));
				address_p.setText(rs1.getString(9));
				address_m.setText(rs1.getString(8));
				age.setText(rs1.getInt(10)+"");
				phone_no.setText(rs1.getString(11));
				
			}
			pst=con.prepareStatement(p);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				takeid=rs1.getInt(1)+1;
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
		f.getContentPane().add(new OpdReg1());
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
