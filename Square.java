package Swissbank;

public class Square {
	private int index;
	private int px, py;

	private Player player;

	private char NO;

	public Square(int index, int px, int py) {
		this.index = index;
		this.px = px;
		this.py = py;
		this.NO = BoardUtils.squareIndex2No(index);
	}

	public int getIndex() {
		return index;
	}

	public char getNO() {
		return NO;
	}

	public Player getPlayer() {
		return player;
	}

	public int getPx() {
		return px;
	}

	public int getPy() {
		return py;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setNO(char nO) {
		NO = nO;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public void setPy(int py) {
		this.py = py;
	}
}
