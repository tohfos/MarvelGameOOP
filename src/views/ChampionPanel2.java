package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class ChampionPanel2 extends GameFrame{

	public ChampionPanel2(Game game, Player p,Player p2,ArrayList<Champion> UsedChamps) throws IOException {	
		super("MARVEL : ULTIMATE WAR",1920,1080,null);
		
		
		

		JLabel name = new JLabel(p2.getName() + " CHOOSE YOUR THREE CHAMPIONS!",SwingConstants.CENTER);
		name.setBounds(350,50,600,100);
		name.setFont(new Font("ITALIC",Font.BOLD,20));
		name.setBackground(Color.decode("#EC1D24"));
		name.setOpaque(true);
		
		
		JButton Choose = new JButton("CHOOSE CHAMPIONS");
		Choose.setBounds(250,400,800,125);
		Choose.setFocusable(false);
		
		Choose.setBackground(Color.decode("#b97d10"));
		
		

		
		
		Choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SelectionFrame2(game,p,p2,UsedChamps);
			
				
				Choose.setEnabled(false);
			}
		});
		
		
		
		
		
		
		
		
		
	   this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("shiiiss.png")))));
	   this.add(Choose);
	   
	   
		this.add(name);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		
		

	    
	    
	    
		
	}
	public static void main(String[] args) throws IOException {
		
	}

	

		
		
}
