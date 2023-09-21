package views;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;

import engine.Game;
import engine.Player;
import model.world.Champion;


public class SelectionFrame extends GameFrame  {
	JButton button;
	Champion champ;
	ArrayList<JButton> AvailableButtons = new ArrayList<JButton>();
	ArrayList<Champion> AvailableChamps = new ArrayList<Champion>();
	ArrayList<Champion> UsedChamps ;

	public SelectionFrame(Game game, Player p,Player p2 ,ArrayList<Champion> UsedChamps) {
		

		super("MARVEL : ULTIMATE WAR", 1920, 1080, null);
		this.UsedChamps = new ArrayList<Champion>();

		
		this.setLayout(new GridLayout(3, 5));
		
			for(int k = 0 ; k<game.getAvailableChampions().size();k++) { 
		    champ = game.getAvailableChampions().get(k);
			button = new JButton(champ.getName());
			AvailableChamps.add(champ);
			AvailableButtons.add(button);
			this.add(button);
			
			ShowInfo(button,champ);
			
			
			
			
			
			
		}
			
			for(int g = 0 ; g<AvailableButtons.size();g++) {
				AvailableButtons.get(g).setFocusable(false);
			}
			JButton proceed = new JButton("PROCEED");
			this.add(proceed);
			proceed.setBackground(Color.decode("#EC1D24"));
			proceed.setOpaque(true);
			proceed.setFocusable(false);
			
			
	
			for(int i = 0 ;i<AvailableButtons.size();i++) {
				JButton x = AvailableButtons.get(i);
				Champion y = AvailableChamps.get(i);
				//Champion c =AvailableChamps.get(i);
				
		
				x.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						//System.out.println(c.getName());
						
						if(p.getTeam().size()<3) {
							
							p.getTeam().add(y);
							AvailableChamps.remove(y);
						    UsedChamps.add(y);
							
						    
						
							
							
							x.setEnabled(false);
							if(p.getTeam().size()==3) {
								proceed.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
											new ChampionPanel2(game,p,p2,UsedChamps);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
							
										
									
									}
								});
							}
						
						}
						
						
						
					
                     
					
                        
                        
						
						
						
					}
				});
				
				
				
			}
	
		
		
		
		
		
		
		



		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);

	}
	
	public void close() {
		this.dispose();
	}

	public static void main(String[] args) {
		Player p = new Player("b");
		Player p2 = new Player("a");
		Game game = new Game(p,p2);
   ArrayList<Champion> UsedChamps = new ArrayList<Champion>();
		new SelectionFrame(game,p,p2,UsedChamps);
	}

	
	public void ShowInfo(JButton x,Champion y) {
		
		x.setToolTipText(ChampInfo(y));
	}
	public String ChampInfo(Champion x) {
  String s = "<html>" + "NAME :" + x.getName() +"<br>" + "ATTACK DAMAGE: "  +  x.getAttackDamage() +"<br>" + "MAX HP :" + x.getMaxHP() + "<br>" + "ATTACK RANGE :" + x.getAttackRange() + "<br>" + "MANA : " +  x.getMana() + "<br>" + x.getAbilities().get(0).getName() + "<br>" + x.getAbilities().get(1).getName() +"<br>" + x.getAbilities().get(2).getName() ;  
		return s;
	}
}
