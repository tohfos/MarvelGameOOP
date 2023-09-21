package views;
import javax.imageio.ImageIO;
import java.util.*;
import model.world.*;

import javax.swing.*;

import engine.Game;
import engine.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ChampionPanel1 extends GameFrame {
	
public ChampionPanel1(Game game, Player p,Player p2) throws IOException {	
	super("MARVEL : ULTIMATE WAR",1920,1080,null);
	

	JLabel name = new JLabel(game.getFirstPlayer().getName() + " CHOOSE YOUR THREE CHAMPIONS!",SwingConstants.CENTER);
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
			ArrayList<Champion> a  = new ArrayList<Champion>();
			 new SelectionFrame(game,p,p2,a);
			
			
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
