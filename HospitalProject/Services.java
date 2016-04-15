package com.java.HospitalProject;

import java.awt.event.WindowAdapter;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Services extends JPanel{

	private static final long serialVersionUID = 1L;
	private static JFrame f;
	private JCheckBox chckbxOther;
	private JCheckBox chckbxTreatment;
	private JCheckBox chckbxReference;
	private JCheckBox chckbxNone;
	private JCheckBox chckbxSonography;
	private JCheckBox chckbxInvestigation;
	private JCheckBox chckbxAdmission;
	private JCheckBox chckbxOperation;
	private JCheckBox chckbxConcultation;
	private JCheckBox chckbxGynac;
	static String s="";
	static String p="";
	private JButton btnSubmit;
	private JCheckBox chckbxPregnancy_1;
	
	public Services(){
		super();
		setSize(500,364);
		setLayout(null);
		
		JLabel lblNitaveHospital = new JLabel("NITAVE HOSPITAL");
		lblNitaveHospital.setHorizontalAlignment(SwingConstants.CENTER);
		lblNitaveHospital.setBounds(137, 11, 242, 35);
		lblNitaveHospital.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(lblNitaveHospital);
		
		JLabel lblTypeOfPatient = new JLabel("Type of Patient");
		lblTypeOfPatient.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTypeOfPatient.setBounds(42, 73, 157, 25);
		add(lblTypeOfPatient);
		
		JLabel lblServicesProvided = new JLabel("Services Provided");
		lblServicesProvided.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblServicesProvided.setBounds(42, 151, 173, 25);
		add(lblServicesProvided);
		
		chckbxGynac = new JCheckBox("Gynac");
		chckbxGynac.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxGynac.setBounds(193, 113, 89, 23);
		add(chckbxGynac);
		
		chckbxOther = new JCheckBox("Other");
		chckbxOther.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxOther.setBounds(335, 113, 120, 23);
		add(chckbxOther);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(197, 72, 18, 23);
		add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_1.setBounds(221, 149, 18, 23);
		add(label_1);
		
		chckbxConcultation = new JCheckBox("Concultation");
		chckbxConcultation.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxConcultation.setBounds(52, 191, 129, 23);
		add(chckbxConcultation);
		
		chckbxSonography = new JCheckBox("Sonography");
		chckbxSonography.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxSonography.setBounds(192, 191, 129, 23);
		add(chckbxSonography);
		
		chckbxInvestigation = new JCheckBox("Investigation");
		chckbxInvestigation.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxInvestigation.setBounds(335, 191, 139, 23);
		add(chckbxInvestigation);
		
		chckbxAdmission = new JCheckBox("Admission");
		chckbxAdmission.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxAdmission.setBounds(52, 223, 129, 23);
		add(chckbxAdmission);
		
		chckbxOperation = new JCheckBox("Operation");
		chckbxOperation.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxOperation.setBounds(192, 223, 129, 23);
		add(chckbxOperation);
		
		chckbxTreatment = new JCheckBox("Treatment");
		chckbxTreatment.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxTreatment.setBounds(335, 223, 139, 23);
		add(chckbxTreatment);
		
		chckbxReference = new JCheckBox("Reference");
		chckbxReference.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxReference.setBounds(52, 253, 129, 23);
		add(chckbxReference);
		
		chckbxNone = new JCheckBox("None");
		chckbxNone.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxNone.setBounds(192, 253, 129, 23);
		add(chckbxNone);
				
		chckbxPregnancy_1 = new JCheckBox("Pregnancy");
		chckbxPregnancy_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxPregnancy_1.setBounds(52, 113, 120, 23);
		add(chckbxPregnancy_1);
		
		s="";
		p="";
		
		String s1[]=OpdReg.ptype.split(" ");
		for(int i=0;i<s1.length;i++)
		{
			if(s1[i].equals("Pregnancy"))
				chckbxPregnancy_1.setSelected(true);
			if(s1[i].equals("Gynac"))
				chckbxGynac.setSelected(true);
			if(s1[i].equals("Other"))
				chckbxOther.setSelected(true);
		}
		String p1[]=OpdReg.pservice.split(" ");
		for(int i=0;i<p1.length;i++)
		{
			if(p1[i].equals("Concultation"))
				chckbxConcultation.setSelected(true);
			if(p1[i].equals("Sonography"))
				chckbxSonography.setSelected(true);
			if(p1[i].equals("Investigation"))
				chckbxInvestigation.setSelected(true);
			if(p1[i].equals("Admission"))
				chckbxAdmission.setSelected(true);
			if(p1[i].equals("Operation"))
				chckbxOperation.setSelected(true);
			if(p1[i].equals("Treatment"))
				chckbxTreatment.setSelected(true);
			if(p1[i].equals("Reference"))
				chckbxReference.setSelected(true);
			if(p1[i].equals("None"))
				chckbxNone.setSelected(true);
		}
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxPregnancy_1.isSelected()==true)
				{
					s=s+"Pregnancy ";
				}

				if(chckbxGynac.isSelected()==true)
				{
					s=s+"Gynac ";
				}
				if(chckbxOther.isSelected()==true)
				{
					s=s+"Other ";
				}
				if(chckbxConcultation.isSelected()==true)
				{
					p=p+"Concultation ";
				}
				if(chckbxSonography.isSelected()==true)
				{
					p=p+"Sonography ";
				}
				if(chckbxInvestigation.isSelected()==true)
				{
					p=p+"Investigation ";
				}
				if(chckbxAdmission.isSelected()==true)
				{
					p=p+"Admission ";
				}
				if(chckbxOperation.isSelected()==true)
				{
					p=p+"Operation ";
				}
				if(chckbxTreatment.isSelected()==true)
				{
					p=p+"Treatment ";
				}
				if(chckbxReference.isSelected()==true)
				{
					p=p+"Reference ";
				}
				if(chckbxNone.isSelected()==true)
				{
					p=p+"None ";
				}
				OpdReg.ptype=s;
				OpdReg.pservice=p;
				f.dispose();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubmit.setBounds(193, 303, 107, 35);
		add(btnSubmit);

	}
	
	public static void main(String args[]){
		create();
	}
	public static void create() {
		
		WindowUtil.setNativeLook();;
		f=new JFrame("Nitave Hospital");
		f.getContentPane().add(new Services());
		f.setBounds(500,200,700,700);
		f.setSize(600,400);
		f.getContentPane().setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				
				f.dispose();	
				
			}
		});
		f.setVisible(true);
	}
}
