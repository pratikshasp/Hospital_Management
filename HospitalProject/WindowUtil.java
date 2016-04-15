package com.java.HospitalProject;


import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class WindowUtil {

	public static int getScreenWidth(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		return gd.getDisplayMode().getWidth();
	}
	public static int getScreenHeight(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		return gd.getDisplayMode().getHeight();
	}
	public static void setToCenter(Container c,int w,int h){
		c.setBounds(getScreenWidth()/2-w/2, getScreenHeight()/2-h/2, w, h);
	}
	public static ImageIcon getScaledImage(Image srcImg, int w, int h) {
		  int s=0;
		 BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	      Graphics2D g2 = resizedImg.createGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	      g2.setColor(Color.black);
	      g2.drawImage(srcImg, s, s, w-s, h-s, null);
	      for(int i=0;i<s;i++)
	    	  g2.drawRect(i, i, w-i, h-i);
	      g2.dispose();
	      return new ImageIcon(resizedImg);
	}
	public static void setNimbusLook(){
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//javax.swing.plaf.nimbus.NimbusLookAndFeel
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public static void setNativeLook(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//javax.swing.plaf.nimbus.NimbusLookAndFeel
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public static String capitalize(final String line) {
		   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
		}

}
	