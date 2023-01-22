package fr.pfrulio.game.tictactoe.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import fr.pfrulio.game.tictactoe.controller.Controller;
import fr.pfrulio.game.tictactoe.model.Case;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	private JButton[][] gridButton = new JButton[3][3];
	private JPanel content = new JPanel();

	private Case gamer = Case.ROND;

	private int line;

	private int column;

	private Case[][] grid;

	private Controller controller;

	public Fenetre() {
		this.setTitle("Tic Tac Toe");
		this.setSize(220, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.grid = new Case[3][3];
		this.controller = new Controller();

		controller.init(grid);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				final int line = i;
				final int column = j;
				gridButton[i][j] = new JButton();
				gridButton[i][j].setPreferredSize(new DimensionUIResource(50, 50));

				gridButton[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) e.getSource();
						btn.setEnabled(false);
						btn.setText(gamer.getDisplay());
						setLine(line);
						setColumn(column);
						grid[line][column] = gamer;
						if (controller.isFinish(grid)) {
							int response = JOptionPane.showConfirmDialog(null, "Voulez-vous rejouer ?", "Rejouer",
									JOptionPane.YES_NO_OPTION);
							if (response == JOptionPane.NO_OPTION)
								dispose();
							else {
								controller.init(grid);
								for (int i = 0; i < 3; i++) {
									for (int j = 0; j < 3; j++) {
										gridButton[i][j].setText("");
										gridButton[i][j].setEnabled(true);
									}
								}

							}
						} else {
							if (gamer == Case.ROND) {
								gamer = Case.CROIX;
								playComputer();
							} else
								gamer = Case.ROND;

						}

					}
				});
				content.add(gridButton[i][j]);
			}
		}
		setContentPane(content);
		setVisible(true);
	}

	public void setGamer(Case gamer) {
		this.gamer = gamer;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	private void playComputer() {
		int line;
		int column;
		do {
			line = controller.getNbAleatoire();
			column = controller.getNbAleatoire();
			System.out.println(line);
			System.out.println(column);
		} while (!gridButton[line][column].isEnabled());
		gridButton[line][column].doClick();
	}
}
