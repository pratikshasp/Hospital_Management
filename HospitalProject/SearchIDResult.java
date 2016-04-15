package com.java.HospitalProject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class SearchIDResult extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private static JFrame f;
	Connection con=ConnectToDB.getCon();


	public SearchIDResult() {
		setLayout(null);
		setSize(1375,768);
		
		//top label
				JLabel lblNitaveHospital = new JLabel("                      NITAVE HOSPITAL");
				lblNitaveHospital.setBounds(0, 21, 1362, 76);
				lblNitaveHospital.setForeground(Color.BLACK);
				lblNitaveHospital.setBackground(Color.WHITE);
				lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 65));
				add(lblNitaveHospital);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 300, 1263, 300);
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
		
		JButton btnEnterName = new JButton("Enter Name");
		btnEnterName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name=JOptionPane.showInputDialog(null, "Enter Name Of Patient");
					name=WindowUtil.capitalize(name);
					String s="select patient_id,opd_id,patient_name,husband_name,father_name,surname from opd_reg where patient_name='"+name+"' order by patient_id desc";
					PreparedStatement pst=con.prepareStatement(s);
					ResultSet rs1=pst.executeQuery();
					int count=0;
					while(rs1.next())
					{
						count=count+1;
					}
					if(count==0)
					{
						JOptionPane.showMessageDialog(null, "No Patient with name:"+name+" Exist....!");
						f.dispose();
						SearchNextWindow.create();
					}
					else if(count>=1)
					{
						ResultSet rs2=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs2));
					}
										
				} catch (Exception e1) {
				}
				
				
			}
		});
		btnEnterName.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnEnterName.setBounds(54, 175, 213, 47);
		add(btnEnterName);
		
		
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
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnNewButton.setBounds(610, 173, 138, 49);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				SearchNextWindow.create();
			}
		});
		JButton home = new JButton("HOME");
		home.setFont(new Font("Tahoma", Font.BOLD, 28));
		home.setBounds(894, 173, 138, 49);
		add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				AddEditSearch.create();
			}
		});
		JButton LogOut = new JButton("LogOut");
		LogOut.setFont(new Font("Tahoma", Font.BOLD, 28));
		LogOut.setBounds(1179, 173, 138, 49);
		add(LogOut);
		LogOut.addActionListener(new ActionListener() {
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
		f = new JFrame("Nitave Hospital");
		f.getContentPane().add(new SearchIDResult());
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
