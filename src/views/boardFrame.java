package views;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class boardFrame extends GameFrame {

	Object selectedCell;
	Game g;
	Boolean attacking = false;
	Boolean CastingAbility = false;

	public boardFrame(Game game) {
		super("MARVEL : ULTIMATE WAR", 1920, 1080, null);
		this.g = game;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.g.placeChampions();
		this.g.prepareChampionTurns();

		JPanel m = new JPanel(new GridLayout(1, 2));
		JPanel boardmap = new JPanel(new GridLayout(5, 5));
		JPanel boarddetails = new JPanel(new GridLayout(3, 1));

		JPanel directions = new JPanel(new GridLayout(1, 4));
		boarddetails.add(directions);

		JPanel turnHolder = new JPanel(new GridLayout(6, 1));

		handleGameHelper(boardmap, m, turnHolder);

		boarddetails.add(turnHolder);

		JButton attack = new JButton("ATTACK");
		attack.setBackground(Color.decode("#40E0D0"));
		boarddetails.add(attack);

		JButton castAbilitybutton = new JButton("CAST ABILITY");
		boarddetails.add(castAbilitybutton);

		JButton endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.endTurn();
				handleGameHelper(boardmap, m, turnHolder);
				
			}
		});
		boarddetails.add(endTurn);

		JButton leaderAbility = new JButton("Leader Ability");
		leaderAbility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					g.useLeaderAbility();
					handleGameHelper(boardmap, m, turnHolder);
				} catch (LeaderAbilityAlreadyUsedException | LeaderNotCurrentException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		boarddetails.add(leaderAbility);

		castAbilitybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> abilities = new ArrayList<String>(); 
				for(int ab = 0; ab < g.getCurrentChampion().getAbilities().size(); ab++) {
					abilities.add(g.getCurrentChampion().getAbilities().get(ab).getName());
				}
				int idk = JOptionPane.showOptionDialog(null, "CHOOSE ABILITY", g.getCurrentChampion().getName(),
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, abilities.toArray(), 0);

				if(idk == -1) {
					return;
				}
				Ability a = g.getCurrentChampion().getAbilities().get(idk);
				if (a.getCastArea().equals(AreaOfEffect.SINGLETARGET)) {

					JTextField xCor = new JTextField();
					JTextField yCor = new JTextField();

					Object[] fields = { "Enter X Coordinate:", xCor, "Enter Y Coordinate:", yCor };
					JOptionPane.showConfirmDialog(null, fields, "CHOOSE YOUR TARGET LOCATION",
							JOptionPane.WARNING_MESSAGE);

					int x = Integer.parseInt(xCor.getText());
					int y = Integer.parseInt(yCor.getText());

					try {
						g.castAbility(a, x, y);
						handleGameHelper(boardmap, m, turnHolder);
					} catch (AbilityUseException | NotEnoughResourcesException | InvalidTargetException
							| CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}

				}

				else if (a.getCastArea().equals(AreaOfEffect.DIRECTIONAL)) {
					ArrayList<String> directions = new ArrayList<String>(); 
					directions.add(Direction.UP + "");
					directions.add(Direction.DOWN + "");
					directions.add(Direction.LEFT + "");
					directions.add(Direction.RIGHT + "");

					int direc = JOptionPane.showOptionDialog(null, "CHOOSE Direction", g.getCurrentChampion().getName(),
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, directions.toArray(), 0);

					if(direc == -1) {
						return;
					} else {
						Direction dir = Direction.valueOf(directions.get(direc));
						helperDirection(dir, boardmap, m, turnHolder, a);
					}
				}

				else {
					try {
						g.castAbility(a);
						handleGameHelper(boardmap, m, turnHolder);
					} catch (AbilityUseException | NotEnoughResourcesException | CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});

		for (int z = 0; z < game.getCurrentChampion().getAbilities().size(); z++) {
			int j = z + 1;
			// JButton castAbilitybutton = new JButton( " ABILITY " + j+" :"
			// +game.getCurrentChampion().getAbilities().get(z).getName());
			castAbilitybutton.setFont(new Font("ITALIC", Font.BOLD, 8));
			castAbilitybutton.setBackground(Color.decode("#EC1D24"));

		}

		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attacking = true;
			}
		});

		JButton up = new JButton("Down");
		up.setBackground(Color.decode("#FF7F50"));
		JButton down = new JButton("Up");
		down.setBackground(Color.decode("#FF7F50"));
		JButton left = new JButton("left");
		left.setBackground(Color.decode("#FF7F50"));
		JButton right = new JButton("right");
		right.setBackground(Color.decode("#FF7F50"));

		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helperDirection(Direction.UP, boardmap, m, turnHolder, null);
			}
		});
		down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helperDirection(Direction.DOWN, boardmap, m, turnHolder, null);
			}
		});
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helperDirection(Direction.LEFT, boardmap, m, turnHolder, null);
			}
		});
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helperDirection(Direction.RIGHT, boardmap, m, turnHolder, null);
			}
		});

		directions.add(up);
		directions.add(down);
		directions.add(left);
		directions.add(right);

		this.setLayout(new GridLayout(1, 1));
		this.reDrawBoard(boardmap, m);

		m.add(boarddetails);
		m.add(boardmap);
		m.revalidate();
		this.add(m);
		this.setVisible(true);
	}

	public void reDrawBoard(JPanel boardmap, JPanel m) {
		boardmap.removeAll();
		boardmap.revalidate();
		boardmap.repaint();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Object cell = this.g.getBoard()[i][j];
				JButton x = new JButton();
				if (cell instanceof Cover) {
					x = new JButton("Cover");
					x.setBackground(Color.black);
					x.setForeground(Color.white);
					x.setToolTipText("COVER CURRENT HP : " + CoverInfo((Cover) cell));
				} else if (cell instanceof Champion) {
					x = new JButton(((Champion) cell).getName());
					ShowInfo(x, (Champion) cell);

					for (int p = 0; p < g.getFirstPlayer().getTeam().size(); p++) {
						if (x.getText().equals(g.getFirstPlayer().getTeam().get(p).getName())) {
							if(x.getText().equals(g.getCurrentChampion().getName())) {
								x.setBackground(Color.green);
								
							}
							else {
								x.setBackground(Color.red);

							}
							x.setFocusable(false);
							
						} else if (x.getText().equals(g.getSecondPlayer().getTeam().get(p).getName())) {
							if(x.getText().equals(g.getCurrentChampion().getName())) {
								x.setBackground(Color.green);
								x.setForeground(Color.white);
								x.setFocusable(false);
							}
							else {
								x.setBackground(Color.blue);
								x.setForeground(Color.white);
								x.setFocusable(false);
							}
							
						}
					}
				} else {
					x = new JButton("");
				}
				x.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedCell = cell;
					}
				});
				boardmap.add(x);
				boardmap.revalidate();
			}
		}
	}

	public void helperDirection(Direction d, JPanel boardmap, JPanel m, JPanel turnHolder, Ability a) {
		try {
			if(this.CastingAbility || a != null) {
				this.g.castAbility(a, d);
			} else if (this.attacking) {
//				System.out.println("attacking");
				this.attacking = false;
				this.g.attack(d);
			} else {
				this.g.move(d);
			}

			handleGameHelper(boardmap, m, turnHolder);

		} catch (UnallowedMovementException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		} catch (NotEnoughResourcesException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		} catch (ChampionDisarmedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		} catch (InvalidTargetException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		} catch (AbilityUseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		} catch (CloneNotSupportedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void handleGameHelper( JPanel boardmap, JPanel m, JPanel turnHolder) {

		if (this.g.getCurrentChampion().getCurrentActionPoints() == 0 || this.g.getCurrentChampion().getMana() == 0) {
			this.g.endTurn();
		}
		turnHolder.removeAll();
		turnHolder.repaint();
		Player CurrentPlayer = null;
		if(g.getFirstPlayer().getTeam().contains(g.getCurrentChampion())) {
			CurrentPlayer = g.getFirstPlayer();
		} else {
			CurrentPlayer = g.getSecondPlayer();
		}
		turnHolder.add(new JLabel(CurrentPlayer.getName() + "'s turn"));
		turnHolder.add(new JLabel(this.g.getCurrentChampion().getName()));
		turnHolder.add(new JLabel("Current HP: " + this.g.getCurrentChampion().getCurrentHP()));
		turnHolder.add(new JLabel("Current Action Points: " + this.g.getCurrentChampion().getCurrentActionPoints()));
		turnHolder.add(new JLabel("Current Mana: " + this.g.getCurrentChampion().getMana()));
		turnHolder.revalidate();
		
		Object winner = this.g.checkGameOver();
		if(winner != null) {
			int exit = JOptionPane.showConfirmDialog(null, ((Player)winner).getName() + " is a winner","Game Winner", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(exit != 1010) {
				this.removeAll();
				this.repaint();
				this.revalidate();
				this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			}
		}
		this.reDrawBoard(boardmap, m);
	}
	
	public void ShowInfo(JButton x,Champion y) {
		x.setToolTipText(ChampInfo((Champion) y));
	}
	
	public String ChampInfo(Champion x) {
		String s = "<html>" + "NAME :" + x.getName() +"<br>" + "ATTACK DAMAGE: "  +  x.getAttackDamage() +"<br>" + "CURRENT HP :" + x.getCurrentHP() + "<br>" + "MAX HP :" + x.getMaxHP() + "<br>" + "ATTACK RANGE :" + x.getAttackRange() + "<br>" + "MANA : " +  x.getMana() + "<br>" + x.getAbilities().get(0).getName() + "<br>" + x.getAbilities().get(1).getName() +"<br>" + x.getAbilities().get(2).getName() ;  
		return s;
	}

	
	public String CoverInfo(Cover x) {
		String s = " " + x.getCurrentHP();
		return s;
	}
}
