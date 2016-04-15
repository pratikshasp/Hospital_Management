package com.java.HospitalProject;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class SearchOldDetail extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JTable table;
	Connection con=ConnectToDB.getCon();
	
	
	public SearchOldDetail() {
		setLayout(null);
		setSize(1375,768);
		
		JButton btnOpd = new JButton("OPD");
		btnOpd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOpd.setBounds(54, 205, 167, 40);
		add(btnOpd);
		btnOpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select patient_id,opd_id,opd_date,patient_type,service_provided from opd_sub where patient_id='"+SearchPatient.pid+"' order by patient_id desc");  
					ResultSet rs1=stmt.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs1));  
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnIpd = new JButton("IPD");
		btnIpd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnIpd.setBounds(264, 205, 167, 40);
		add(btnIpd);
		btnIpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("Select * from ipd_reg where patient_id='"+SearchPatient.pid+"' order by patient_id desc");  
					ResultSet rs1=stmt.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs1));  
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnMtp = new JButton("MTP");
		btnMtp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select patient_id,opd_id,daughter_of,religion,date_admission as DateOfAdmission,date_discharge as DateOfDischarge,pregnancy_duration,result,remark from mtp_reg where patient_id= "+SearchPatient.pid+" order by patient_id desc");  
					ResultSet rs1=stmt.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs1));  
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnMtp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMtp.setBounds(492, 205, 167, 40);
		add(btnMtp);
		
		JButton btnAnc = new JButton("ANC");
		btnAnc.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnc.setBounds(705, 205, 167, 40);
		add(btnAnc);
		btnAnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select patient_id,opd_id,first_reported_date,number_of_child from anc_reg where patient_id= "+SearchPatient.pid+" order by patient_id desc");  
					ResultSet rs1=stmt.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs1));   
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnDelivery = new JButton("DELIVERY");
		btnDelivery.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelivery.setBounds(928, 205, 167, 40);
		add(btnDelivery);
		btnDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select patient_id,opd_id,delivery_date,delivery_time,cast,gender,weight,delivery_mode from delivery_reg where patient_id= "+SearchPatient.pid+" order by patient_id desc");  
					ResultSet rs1=stmt.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs1));   
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnOperation = new JButton("OPERATION");
		btnOperation.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOperation.setBounds(1150, 205, 167, 40);
		add(btnOperation);
		btnOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select patient_id,opd_id,operation_type,operation_date,operation_time,anaesthesia_type,surgeon,anaesthetise,operation_summary from opr_reg where patient_id= "+SearchPatient.pid+" order by patient_id desc");  
					ResultSet rs1=stmt.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs1));   
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 282, 1263, 421);
		add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY, Color.LIGHT_GRAY));
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.setRowSelectionAllowed(true);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
			private static final long serialVersionUID = 1L;

			@Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
		        return c;
		    }
		});
		
		JLabel label = new JLabel("     NITAVE HOSPITAL");
		label.setFont(new Font("Tahoma", Font.BOLD, 58));
		label.setBounds(296, 11, 627, 70);
		add(label);
		
		JTextArea textName = new JTextArea();
		textName.setEnabled(false);
		textName.setEditable(false);
		textName.setText("<dynamic>  <dynamic>  <dynamic>  <dynamic>");
		textName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		textName.setBounds(166, 155, 455, 27);
		add(textName);
		
		JTextArea txtpatientid = new JTextArea();
		txtpatientid.setEnabled(false);
		txtpatientid.setEditable(false);
		txtpatientid.setText("0");
		txtpatientid.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		txtpatientid.setBounds(166, 117, 139, 27);
		add(txtpatientid);
		
		JLabel id = new JLabel("Patient ID:");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		id.setBounds(54, 119, 102, 33);
		add(id);
		
		JLabel name = new JLabel("Name:");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		name.setBounds(49, 156, 70, 27);
		add(name);
		
		JButton home = new JButton("HOME");
		home.setFont(new Font("Tahoma", Font.BOLD, 28));
		home.setBounds(1177, 117, 140, 49);
		add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		
		
		
		try {
			String s="select patient_id,patient_name,husband_name,father_name,surname from opd_reg where opd_id= '"+SearchPatient.oid+"'";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery();
			while(rs1.next())
			{
				
				txtpatientid.setText(rs1.getInt(1)+"");
				textName.setText(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
				
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
		f.getContentPane().add(new SearchOldDetail());
		WindowUtil.setToCenter(f, WindowUtil.getScreenWidth(), WindowUtil.getScreenHeight());
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				f.dispose();
				SearchDetailType.create();
			}
		});
		f.setVisible(true);
	}
}
