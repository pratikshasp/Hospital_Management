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

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	Connection con=ConnectToDB.getCon();
	
	
	public SearchPanel() {
		setLayout(null);
		setSize(1375,768);
		
		JButton btnOpd = new JButton("OPD");
		btnOpd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOpd.setBounds(54, 31, 167, 40);
		add(btnOpd);
		btnOpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select opd_reg.patient_id,opd_reg.opd_id,patient_name,husband_name,father_name,surname,opd_date,patient_type,service_provided from opd_reg,opd_sub where opd_reg.opd_id=opd_sub.opd_id order by opd_reg.patient_id desc");  
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
		btnIpd.setBounds(282, 31, 167, 40);
		add(btnIpd);
		btnIpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("Select ipd_reg.patient_id,ipd_reg.opd_id,ipd_id,patient_name,husband_name,father_name,surname,date_of_admission,date_of_discharge,diagnosis,treatment,discharge_summary from opd_reg,ipd_reg where opd_reg.opd_id=ipd_reg.opd_id order by ipd_reg.patient_id desc");  
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
					PreparedStatement stmt=con.prepareStatement("select  mtp_reg.patient_id,mtp_reg.opd_id,patient_name,husband_name,father_name,surname,daughter_of,religion,date_admission as DateOfAdmission,date_discharge as DateOfDischarge,pregnancy_duration,result,remark from opd_reg,mtp_reg where opd_reg.opd_id=mtp_reg.opd_id order by mtp_reg.patient_id desc");  
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
		btnMtp.setBounds(502, 31, 167, 40);
		add(btnMtp);
		
		JButton btnAnc = new JButton("ANC");
		btnAnc.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnc.setBounds(712, 31, 167, 40);
		add(btnAnc);
		btnAnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select anc_reg.patient_id,anc_reg.opd_id,patient_name,husband_name,father_name,surname,first_reported_date,number_of_child from opd_reg,anc_reg where opd_reg.opd_id=anc_reg.opd_id order by anc_reg.patient_id desc");  
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
		btnDelivery.setBounds(936, 31, 167, 40);
		add(btnDelivery);
		btnDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select delivery_reg.patient_id,delivery_reg.opd_id,patient_name,husband_name,father_name,surname,delivery_date,delivery_time,cast,gender,weight,delivery_mode from delivery_reg,opd_reg where opd_reg.opd_id=delivery_reg.opd_id order by delivery_reg.patient_id desc");  
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
		btnOperation.setBounds(1150, 31, 167, 40);
		add(btnOperation);
		btnOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement stmt=con.prepareStatement("select opr_reg.patient_id,opr_reg.opd_id,patient_name,husband_name,father_name,surname,operation_type,operation_date,operation_time,anaesthesia_type,surgeon,anaesthetise,operation_summary from opd_reg,opr_reg where opd_reg.opd_id=opr_reg.opd_id order by opr_reg.patient_id desc");  
					ResultSet rs1=stmt.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs1));   
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		table = new JTable();
		table.setEnabled(false);
	
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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 101, 1263, 602);
		scrollPane.setViewportView(table);
		add(scrollPane);
	}
	public static void main(String args[]){
		create();
		
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		JFrame f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new SearchPanel());
		WindowUtil.setToCenter(f, WindowUtil.getScreenWidth(), WindowUtil.getScreenHeight());
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				f.dispose();		
			}
		});
		f.setVisible(true);
	}
}
