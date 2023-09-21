package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public  class GameFrame extends JFrame{
//private Color color;

//private Image backGround;
private int width=700;
private int height=700;
private ImageIcon GameLogo;
private String Title;




	public GameFrame(String Title,int width,int height,ImageIcon GameLogo) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.GameLogo=new ImageIcon("MarvelLogo.png");
		this.setIconImage(this.GameLogo.getImage());
		this.setSize(this.width,this.height);
		this.setTitle("MARVEL : ULTIMATE WAR");
		
		
		
				}

	
	
			


	
	

	

	   
	
	
	
	
	
	
	
}
