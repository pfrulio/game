package fr.pfrulio.game.tictactoe.controller;

import fr.pfrulio.game.tictactoe.model.Case;

public class Controller {

	public void init(Case[][] grid) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = Case.VIDE;
			}
		}
	}

	/**
	 * 
	 * @param grid
	 * @return true si le jeu est fini
	 */
	public boolean isFinish(Case[][] grid) {
		if (isNul(grid))
			return true;
		else if (isWin(grid, Case.ROND))
			return true;
		else if (isWin(grid, Case.CROIX))
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param grid
	 * @param player
	 * @return true si le joueur a gagné
	 */
	private boolean isWin(Case[][] grid, Case player) {
		if (grid[0][0].equals(player) && grid[0][1].equals(player) && grid[0][2].equals(player))
			return true;
		else if (grid[1][0].equals(player) && grid[1][1].equals(player) && grid[1][2].equals(player))
			return true;
		else if (grid[2][0].equals(player) && grid[2][1].equals(player) && grid[2][2].equals(player))
			return true;
		else if (grid[0][0].equals(player) && grid[1][0].equals(player) && grid[2][0].equals(player))
			return true;
		else if (grid[0][1].equals(player) && grid[1][1].equals(player) && grid[2][1].equals(player))
			return true;
		else if (grid[1][2].equals(player) && grid[1][2].equals(player) && grid[2][2].equals(player))
			return true;
		else if (grid[0][0].equals(player) && grid[1][1].equals(player) && grid[2][2].equals(player))
			return true;
		else if (grid[0][2].equals(player) && grid[1][1].equals(player) && grid[2][0].equals(player))
			return true;
		return false;
	}

	/**
	 * 
	 * @param grid
	 * @return true si match nul
	 */
	private boolean isNul(Case[][] grid) {
		// Changer avec des do / while sachant que dès que on trouve une case vide le
		// jeu n'est pas "match nul" !!!
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j].equals(Case.VIDE))
					return false;

			}
		}
		return true;
	}

}
