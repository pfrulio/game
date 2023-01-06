package fr.pfrulio.game.tictactoe.model;

public enum Case {
	VIDE(" "), ROND("O"), CROIX("X");

	private String display;

	private Case(String display) {
		this.display = display;
	}

	public String getDisplay() {
		return this.display;
	}
}
