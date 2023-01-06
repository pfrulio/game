package fr.pfrulio.game.tictactoe;

import java.util.Scanner;

import fr.pfrulio.game.tictactoe.model.Case;

public class Launch {

	public static void main(String[] args) {
		System.out.println("start");
		Case[][] grid = new Case[3][3];
		init(grid);
		Case gamer = Case.ROND;
		do {
			if (gamer.equals(Case.ROND))
				gamer = Case.CROIX;
			else
				gamer = Case.ROND;

			displayGrid(grid);
			play(grid, gamer);
		} while (!isFinish(grid));
		System.out.println("fin du jeu");

	}

	@SuppressWarnings("resource")
	private static Case[][] play(Case[][] grid, Case gamer) {
		boolean playIsOk = true;
		do {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Sur quelle ligne voulez-vous jouer ?");
			int line = keyboard.nextInt();
			System.out.println("Sur quelle colonne voulez-vous jouer ?");
			int column = keyboard.nextInt();
			if (!grid[line - 1][column - 1].equals(Case.VIDE))
				playIsOk = false;
			else
				grid[line - 1][column - 1] = gamer;

		} while (!playIsOk);
		return grid;

	}

	private static void init(Case[][] grid) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = Case.VIDE;
			}
		}
	}

	private static boolean isFinish(Case[][] grid) {
		if (isNul(grid))
			return true;
		else if (isWin(grid, Case.ROND))
			return true;
		else if (isWin(grid, Case.CROIX))
			return true;
		else
			return false;
	}

	private static boolean isWin(Case[][] grid, Case player) {
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

	private static boolean isNul(Case[][] grid) {
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

	private static void displayGrid(Case[][] grid) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("  ");
				System.out.print(grid[i][j].getDisplay());
				System.out.print("  ");
				if (j != 2)
					System.out.print("| ");
			}
			System.out.println("\n-----------------");

		}

	}
}
