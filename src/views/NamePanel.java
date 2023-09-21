package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/*package views;
import javax.swing.*;

import javax.swing.border.Border;

import engine.Game;
import engine.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public abstract class NamePanel extends GameFrame{

  public String firstPlayerName;
public  String secondPlayerName;

	
	public NamePanel() {
		super("MARVEL : ULTIMATE WAR",1920,1080,null);
		JLabel first = new JLabel("FIRST PLAYER ENTER YOUR NAME : ");
		first.setForeground(Color.decode("#e23636"));
		first.setBounds(2,0,300,50);
	
	    
	    JTextField firstName = new JTextField();
	    
	    firstName.setBounds(0,35,400,25);

	    
	    this.add(firstName);
	    
	    JLabel second = new JLabel("SECOND PLAYER ENTER YOUR NAME : ");
	    second.setForeground(Color.decode("#e23636"));
		second.setBounds(2,200,300,50);
	
	    second.setOpaque(true);
	    JTextField secondName = new JTextField();
	    
	    
	   
	    
	    secondName.setBounds(0,235,400,25);
	    this.add(secondName);
	    
	    JButton ready = new JButton ("CHOOSE YOUR CHAMPIONS ");
	    ready.setBounds(400,100,250,100);
	    ready.setForeground(Color.white);
	    ready.setBackground(Color.decode("#e23636"));
	    
	    
	    
	 
	    

			   
	    ready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstPlayerName = firstName.getText();
				
				secondPlayerName= secondName.getText();
				ready.setVisible(false);
				System.out.println(secondPlayerName);
				System.out.println(firstPlayerName);
			try {
				readyButtonPressed( new ChampionPanel() );
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
				
			}
		});
			   
		   
	    
	    
	    
	    
	    
	    
	    
	    
		this.add(first);
		this.add(second);
		this.add(ready);
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		
	    
		
		
		
		
		
		
		
				
		//startfor(int i = 0; i < game.getAvailableChampions().size(); i++) {
			
			if(!game.getFirstPlayer().getTeam().contains(champ) && !game.getSecondPlayer().getTeam().contains(champ)) {			
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(e);
						p.getTeam().add(champ);
				
						System.out.println(champ.getName());
						if(p.getTeam().size() == 3) {
							for(int  j = 0 ; j<3;j++) {
								UsedChamps.add(p.getTeam().get(j));
								
							}
							
						}
						close();
//					this.setVisible(false);
					}
				});
				this.add(button);
			}
			
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				p.getTeam().add(champ);
		
				System.out.println(champ.getName());
				if(p.getTeam().size() == 3) {
					for(int  j = 0 ; j<3;j++) {
						UsedChamps.add(p.getTeam().get(j));
						
					}
					
				}
				close();
//			this.setVisible(false);
			}
		});
		
		
		
		
		
		
	}//finish
	public static void main(String[] args) {
		
		//NamePanel x = new NamePanel();
		
		
	}
	public void readyButtonPressed(ChampionPanel y) {
		
		GameFrame x = new GameFrame("MARVEL : ULTIMATE WAR ", 1920,1080,null);
		x.add(y);
	}
	public String getfirstPlayerNames() {
		return firstPlayerName;
		
	}
	public String getSecondPlayerName() {
		return secondPlayerName;
	}

	
}
*/



	