package fr.pfrulio.game.tictactoe.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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

	public Fenetre() {
		setTitle("Tic Tac Toe");
		setSize(220, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Case[][] grid = new Case[3][3];
		Controller controller = new Controller();
		controller.init(grid);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				final int line = i;
				final int column = j;
				gridButton[i][j] = new JButton();
				gridButton[i][j].setPreferredSize(new DimensionUIResource(50, 50));

				gridButton[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) e.getSource();
						btn.setText(gamer.getDisplay());
						setLine(line);
						setColumn(column);
						grid[line][column] = gamer;
						if (controller.isFinish(grid))
							dispose();
						if (gamer == Case.ROND)
							gamer = Case.CROIX;
						else
							gamer = Case.ROND;
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

}
