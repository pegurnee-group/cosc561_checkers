package com.eddienicole.checkers;

public class ImaginaryBoard implements Comparable<ImaginaryBoard> {
	private final PlayableSpaceInterface[][] playableSpaces;
	private final MoveInterface theMove;
	private double value;

	public ImaginaryBoard(ImaginaryBoard imaginaryBoard, MoveInterface theMove) {
		ImaginaryBoard instance = imaginaryBoard;
		this.playableSpaces = new PlayableSpaceInterface[8][4];
		for (int row = 0; row < this.playableSpaces.length; row++) {
			for (int column = 0; column < this.playableSpaces[row].length; column++) {
				this.playableSpaces[row][column] = new PlayableSpace((4 * row)
						+ column + 1);
				this.playableSpaces[row][column].setKing(instance.getSpace(row,
						column).isKing());
				this.playableSpaces[row][column].setState(instance.getSpace(
						row, column).getState());
			}
		}

		this.theMove = theMove;
	}

	public ImaginaryBoard(MoveInterface theMove) {
		CheckersBoard instance = CheckersBoard.getInstance();
		this.playableSpaces = new PlayableSpaceInterface[8][4];
		for (int row = 0; row < this.playableSpaces.length; row++) {
			for (int column = 0; column < this.playableSpaces[row].length; column++) {
				this.playableSpaces[row][column] = new PlayableSpace((4 * row)
						+ column + 1);
				this.playableSpaces[row][column].setKing(instance.getSpace(row,
						column).isKing());
				this.playableSpaces[row][column].setState(instance.getSpace(
						row, column).getState());
			}
		}

		this.theMove = theMove;
	}

	public ImaginaryBoard(PlayableSpaceInterface[][] playableSpaces,
			MoveInterface theMove) {
		this.playableSpaces = playableSpaces;

		this.theMove = theMove;
	}

	@Override
	public int compareTo(ImaginaryBoard o) {
		if (o == null) {
			return 1;
		}
		return new Double(this.value).compareTo(new Double(o.value));
	}

	public PlayableSpaceInterface[][] getPlayableSpaces() {
		return this.playableSpaces;
	}

	public PlayableSpaceInterface getSpaceByPosition(int positionNumber) {
		return this.playableSpaces[(positionNumber - 1) / 4][(positionNumber - 1) % 4];
	}

	public MoveInterface getTheMove() {
		return this.theMove;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	private PlayableSpaceInterface getSpace(int row, int column) {
		return this.playableSpaces[row][column];
	}

}
