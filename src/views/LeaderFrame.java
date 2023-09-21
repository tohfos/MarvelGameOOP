package views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class LeaderFrame extends GameFrame {
	
	public LeaderFrame(Game game) {
		super("MARVEL : ULTIMATE WAR",1920,1080,null);
		
		
		JLabel firstLeader = new JLabel (game.getFirstPlayer().getName() + " CHOOSE YOUR LEADER");
		firstLeader.setBackground(Color.black);
		firstLeader.setBounds(20,25,700,200);
		firstLeader.setFont(new Font("ITALIC", Font.BOLD, 18));
		
		
			
			JButton firstChamp = new JButton(game.getFirstPlayer().getTeam().get(0).getName());
			firstChamp.setBounds(20,150,100,100);
			firstChamp.setFont(new Font("ITALIC", Font.BOLD, 10));
			firstChamp.setBackground(Color.decode("#EC1D24"));
			JButton secondChamp = new JButton(game.getFirstPlayer().getTeam().get(1).getName());
			secondChamp.setBounds(170,150,100,100);
			secondChamp.setFont(new Font("ITALIC", Font.BOLD, 10));
			secondChamp.setBackground(Color.decode("#EC1D24"));
			JButton thirdChamp = new JButton(game.getFirstPlayer().getTeam().get(2).getName());
			thirdChamp.setBounds(320,150,100,100);
			thirdChamp.setFont(new Font("ITALIC", Font.BOLD, 10));
			thirdChamp.setBackground(Color.decode("#EC1D24"));
			ArrayList <JButton> cleanup =  new ArrayList<JButton>();
			cleanup.add(firstChamp);
		cleanup.add(secondChamp);
		cleanup.add(thirdChamp);
			for(int i = 0 ; i<3;i++) {
				cleanup.get(i).setFocusable(false);
			}
			ArrayList<Champion> haha = new ArrayList<Champion>();
			for(int i = 0 ; i<game.getFirstPlayer().getTeam().size();i++) {
				haha.add(game.getFirstPlayer().getTeam().get(i));
				
			}
			ArrayList<JButton> keke = new ArrayList<JButton>();
			keke.add(firstChamp);
			keke.add(secondChamp);
			keke.add(thirdChamp);
		
			for(int w =0;w<haha.size();w++) { 
				
				Champion dah = haha.get(w);
				JButton x = keke.get(w);
				
				x.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						game.getFirstPlayer().setLeader(dah);
					 
						firstChamp.setEnabled(false);
						secondChamp.setEnabled(false);
						thirdChamp.setEnabled(false);
						x.setVisible(false);
		
					
						
					}
				});
				
			}
			 
			
			
			
			JLabel secondLeader = new JLabel (game.getSecondPlayer().getName() + " CHOOSE YOUR LEADER");
			secondLeader.setBackground(Color.black);
			secondLeader.setBounds(20,370,700,200);
			secondLeader.setFont(new Font("ITALIC", Font.BOLD, 18));
			
			
			
			JButton firstChamp2 = new JButton(game.getSecondPlayer().getTeam().get(0).getName());
			firstChamp2.setBounds(20,500,100,100);
			firstChamp2.setFont(new Font("ITALIC", Font.BOLD, 10));
			firstChamp2.setBackground(Color.blue);
			firstChamp2.setForeground(Color.white);
			JButton secondChamp2 = new JButton(game.getSecondPlayer().getTeam().get(1).getName());
			secondChamp2.setBounds(170,500,100,100);
			secondChamp2.setFont(new Font("ITALIC", Font.BOLD, 10));
			secondChamp2.setBackground(Color.blue);
			secondChamp2.setForeground(Color.white);
			JButton thirdChamp2 = new JButton(game.getSecondPlayer().getTeam().get(2).getName());
			thirdChamp2.setBounds(320,500,100,100);
			thirdChamp2.setFont(new Font("ITALIC", Font.BOLD, 10));
			thirdChamp2.setBackground(Color.blue);
			thirdChamp2.setForeground(Color.white);
			firstChamp.setFocusable(false);
			secondChamp.setFocusable(false);
			thirdChamp.setFocusable(false);
			firstChamp2.setFocusable(false);
			secondChamp2.setFocusable(false);
			thirdChamp2.setFocusable(false);
		

			ArrayList<Champion> hehe = new ArrayList<Champion>();
			for(int f = 0 ; f<game.getSecondPlayer().getTeam().size();f++) {
				hehe.add(game.getSecondPlayer().getTeam().get(f));
				
			}
			ArrayList<JButton> keke2 = new ArrayList<JButton>();
			keke2.add(firstChamp2);
			keke2.add(secondChamp2);
			keke2.add(thirdChamp2);
			
		
			for(int w =0;w<hehe.size();w++) { 
				
				Champion dah = hehe.get(w);
				JButton button = keke2.get(w);
				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						game.getSecondPlayer().setLeader(dah);
						firstChamp2.setEnabled(false);
						secondChamp2.setEnabled(false);
						thirdChamp2.setEnabled(false);
						button.setVisible(false);
					
						
						
					}
				});
				
			}

JButton goToGame = new JButton("READY TO FIGHT");
			
			goToGame.setBackground(Color.decode("#EC1D24"));
			goToGame.setBounds(500,275,200,200);
		
			goToGame.setFocusable(false);
			
				goToGame.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(game.getFirstPlayer().hasLeader()&& game.getSecondPlayer().hasLeader()) {
						new boardFrame(game);
						}
						
					}
				});
		
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		 try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("hehe.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.add(firstChamp);
		 this.add(secondChamp);
		 this.add(thirdChamp);
		 this.add(firstLeader);
		 this.add(firstChamp2);
		 this.add(secondChamp2);
		 this.add(thirdChamp2);
		 this.add(secondLeader);
		this.add(goToGame);
		 
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		
	}
	public static void main(String[] args) {
		new LeaderFrame(new Game(new Player("ahmed"),new Player("hussien")));
	}

}
