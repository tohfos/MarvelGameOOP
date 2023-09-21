package views;

import java.awt.Color;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

import engine.Game;
import engine.Player;

import javax.swing.*;
import java.awt.event.*;

public class StarterPanel extends GameFrame {
	private JButton Start;
	private StarterPanel x;
	private GameFrame main;

	String firstPlayerName;
	String secondPlayerName;

	public Player firstPlayer = new Player(null);
	public Player secondPlayer = new Player(null);
	public Game game;

	public StarterPanel() throws IOException {

		super("MARVEL : ULTIMATE WAR", 1026, 580, null);


		Start = new JButton();

		Start.setFocusable(false);

		Start.setBounds(407, 420, 200, 100);
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstPlayerName = JOptionPane.showInputDialog("FIRST PLAYER ENTER YOUR NAME").toUpperCase();
				secondPlayerName = JOptionPane.showInputDialog("SECOND PLAYER ENTER YOUR NAME").toUpperCase();

				if (!firstPlayerName.isEmpty() && !secondPlayerName.isEmpty()) {
					firstPlayer = new Player(firstPlayerName);
					secondPlayer = new Player(secondPlayerName);
				} else {
					JOptionPane.showMessageDialog(null, "BOTH PLAYERS MUST ENTER THEIR NAMES", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					firstPlayerName = JOptionPane.showInputDialog("FIRST PLAYER ENTER YOUR NAME").toUpperCase();
					secondPlayerName = JOptionPane.showInputDialog("SECOND PLAYER ENTER YOUR NAME").toUpperCase();
					firstPlayer = new Player(firstPlayerName);
					secondPlayer = new Player(secondPlayerName);
				}

				try {
					game = new Game(firstPlayer, secondPlayer);
					new ChampionPanel1(game, game.getFirstPlayer(),game.getSecondPlayer());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}

			}
		});

		Start.setText("START GAME");
		Start.setFont(new Font("ITALIC", Font.BOLD, 18));

		Start.setBackground(Color.decode("#EC1D24"));
		Start.setForeground(Color.decode("#FFFFFF"));

		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("MarvelIntro.png")))));
		this.pack();
		this.add(Start);

		this.setVisible(true);
		// main.add(this);

	}

	public static void main(String[] args) throws IOException {
		StarterPanel x = new StarterPanel();
	}

	

}
