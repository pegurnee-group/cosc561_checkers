package com.eddienicole.checkers;

import javax.swing.JButton;

public class PlayableSpace {
	
	char column;
	int row;
	boolean isOccupied;
	JButton button;
	
	public PlayableSpace(char column, int row) {
		this.column = column;
		this.row = row;
	}

	public void addActionListener(Controller controller) {
		button.addActionListener(controller);
		
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
