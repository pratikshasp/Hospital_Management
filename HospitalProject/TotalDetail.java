package com.java.HospitalProject;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TotalDetail extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFrame f;
	Connection con=ConnectToDB.getCon();
	private JTable table;
	private JTable table_1;

	public TotalDetail() {
		setLayout(null);
		setSize(1338,723);
		
		JLabel lblNitaveHospital = new JLabel("Nitave Hospital");
		lblNitaveHospital.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 22));
		lblNitaveHospital.setHorizontalAlignment(SwingConstants.CENTER);
		lblNitaveHospital.setBounds(559, 11, 405, 34);
		add(lblNitaveHospital);
		
		JLabel lblOpd = new JLabel("OPD");
		lblOpd.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		lblOpd.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpd.setBounds(95, 87, 719, 24);
		add(lblOpd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 122, 719, 263);
		add(scrollPane);
		
		JTextArea textopd = new JTextArea();
		textopd.setBackground(Color.WHITE);
		textopd.setEditable(false);
		textopd.setAutoscrolls(true);
		textopd.setLineWrap(true); 
		textopd.setWrapStyleWord(true);
		textopd.setLineWrap(true);
		textopd.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		scrollPane.setViewportView(textopd);
		JLabel lblIpd = new JLabel("IPD");
		lblIpd.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		lblIpd.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpd.setBounds(836, 85, 486, 26);
		add(lblIpd);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(826, 122, 486, 263);
		add(scrollPane_1);
		
		JTextArea textipd = new JTextArea();
		textipd.setEditable(false);
		textipd.setAutoscrolls(true);
		textipd.setLineWrap(true); 
		textipd.setWrapStyleWord(true);
		textipd.setLineWrap(true);
		textipd.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		scrollPane_1.setViewportView(textipd);
		
		JLabel lblMtp = new JLabel("MTP");
		lblMtp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtp.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		lblMtp.setBounds(85, 406, 351, 24);
		add(lblMtp);
		
		JLabel lblAns = new JLabel("ANC");
		lblAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblAns.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		lblAns.setBounds(456, 560, 348, 24);
		add(lblAns);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(85, 447, 351, 257);
		add(scrollPane_2);
		
		JTextArea textmtp = new JTextArea();
		textmtp.setEditable(false);
		textmtp.setAutoscrolls(true);
		textmtp.setLineWrap(true); 
		textmtp.setWrapStyleWord(true);
		textmtp.setLineWrap(true);
		textmtp.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		scrollPane_2.setViewportView(textmtp);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(456, 595, 349, 107);
		add(scrollPane_3);
		
		JTextArea textanc = new JTextArea();
		textanc.setEditable(false);
		textanc.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		scrollPane_3.setViewportView(textanc);
		
		JLabel lblDeliveryDetails = new JLabel("Delivery Details");
		lblDeliveryDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryDetails.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		lblDeliveryDetails.setBounds(826, 560, 473, 24);
		add(lblDeliveryDetails);
		
		JLabel lblOperationDetails = new JLabel("Operation Details");
		lblOperationDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperationDetails.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		lblOperationDetails.setBounds(456, 406, 843, 24);
		add(lblOperationDetails);
		
		JLabel lblOpdId = new JLabel("Name:");
		lblOpdId.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblOpdId.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpdId.setBounds(20, 52, 78, 24);
		add(lblOpdId);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientId.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblPatientId.setBounds(20, 21, 105, 24);
		add(lblPatientId);
		
		JTextArea txtopdid = new JTextArea();
		txtopdid.setEditable(false);
		txtopdid.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		txtopdid.setBounds(131, 18, 137, 27);
		add(txtopdid);
		
		JTextArea txtname = new JTextArea();
		txtname.setEditable(false);
		txtname.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		txtname.setBounds(131, 49, 405, 27);
		add(txtname);
		
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(826, 595, 473, 109);
		add(scrollPane_4);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane_4.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY, Color.LIGHT_GRAY));
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(456, 442, 843, 107);
		add(scrollPane_5);
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		scrollPane_5.setViewportView(table_1);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY, Color.LIGHT_GRAY));
		table_1.setFillsViewportHeight(true);
		table_1.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		table_1.setRowHeight(30);
		table_1.setRowSelectionAllowed(true);
		
		try {
			String s="select * from opd_reg where opd_id='"+SearchPatient.oid+"'";
			PreparedStatement pst=con.prepareStatement(s);
			ResultSet rs1=pst.executeQuery();
			String p="select * from opd_sub where opd_id='"+SearchPatient.oid+"'";
			PreparedStatement pst1=con.prepareStatement(p);
			ResultSet rs=pst1.executeQuery();
			rs1.next();
			String opd="  Patient ID: "+rs1.getInt(1)+"\n";
			opd=opd+"  OPD ID: "+rs1.getString(2)+"\n";
			opd=opd+"  Name : "+rs1.getString(3)+"  "+rs1.getString(4)+"  "+rs1.getString(5)+"  "+rs1.getString(6)+"\n \n";
			opd=opd+"  Type	Date	Service	\n";
			while(rs.next()){
				String[] d=rs.getString(4).split(" ");
				opd=opd+"  "+rs.getString(5)+"	"+d[0]+"	"+rs.getString(6)+"\n";
			}
			opd=opd+"\n";
			opd=opd+"  Permanant Address: "+rs1.getString(7)+"\n";
			opd=opd+"  Paternal Address: "+rs1.getString(8)+"\n";
			opd=opd+"  Maternal Address: "+rs1.getString(9)+"\n";
			opd=opd+"  Age : "+rs1.getInt(10)+"\n";
			opd=opd+"  Phone : "+rs1.getString(11)+"\n";
			textopd.setText(opd);
			txtname.setText(rs1.getString(3)+"  "+rs1.getString(4)+"  "+rs1.getString(5)+"  "+rs1.getString(6));
			txtopdid.setText(rs1.getInt(1)+"");

			
			s="select * from ipd_reg where opd_id='"+SearchPatient.oid+"' order by ipd_id desc";
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			rs1.next();
			String ipd="  IPD ID: "+rs1.getString(1)+"\n";
			String[] d=rs1.getString(4).split(" ");
			ipd=ipd+"  Admited on: "+d[0]+"\n";
			d=rs1.getString(5).split(" ");
			ipd=ipd+"  Discharged on: "+d[0]+"\n";
			ipd=ipd+"  Dignosis: "+rs1.getString(6)+"\n";
			ipd=ipd+"  Treatement: "+rs1.getString(7)+"\n";
			ipd=ipd+"  Discharge Summary: "+rs1.getString(8)+"\n";
			textipd.setText(ipd);
			
			s="select * from mtp_reg where opd_id='"+SearchPatient.oid+"' order by mtp_id desc";
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			rs1.next();
			String mtp="  Daughter of: "+rs1.getString(4)+"\n";
			mtp=mtp+"  Religion: "+rs1.getString(5)+"\n";
			d=rs1.getString(6).split(" ");
			mtp=mtp+"  Admited on: "+d[0]+"\n";
			d=rs1.getString(7).split(" ");
			mtp=mtp+"  Discharged on: "+d[0]+"\n";
			mtp=mtp+"  Duration: "+rs1.getString(8)+"\n";
			d=rs1.getString(9).split(" ");
			mtp=mtp+"  Terminated on: "+d[0]+"\n";
			mtp=mtp+"  Result: "+rs1.getString(10)+"\n";
			mtp=mtp+"  Remark: "+rs1.getString(11);
			textmtp.setText(mtp);
			
			
			
			s="select * from anc_reg where opd_id='"+SearchPatient.oid+"' order by anc_id desc";
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			rs1.next();
			String anc="  Number of Child: "+rs1.getString(4)+"\n";
			d=rs1.getString(5).split(" ");
			anc=anc+"  First Reported Date: "+d[0]+"\n";
			textanc.setText(anc);
			
			
			s="select delivery_date,delivery_time,gender,weight,delivery_mode from delivery_reg where opd_id='"+SearchPatient.oid+"' order by delivery_id desc";
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs1));
			
			s="select operation_date,operation_type,anaesthesia_type,operation_time,surgeon,anaesthetise,operation_summary from opr_reg where opd_id='"+SearchPatient.oid+"' order by opr_id desc";
			pst=con.prepareStatement(s);
			rs1=pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs1));
			
			
		} catch (Exception e) {
		}
		
	}
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f = new JFrame("Nitave Hospital");
		f.getContentPane().add(new TotalDetail());
		WindowUtil.setToCenter(f, WindowUtil.getScreenWidth(), WindowUtil.getScreenHeight());
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				f.dispose();
			}
		});
		f.setVisible(true);
	}
}