package Swissbank;

import java.util.ArrayList;
import java.util.List;

public class Board { 
	
	public static final int SQUARE_BOUNDARY = 3;
	private Square[] squaresList = new Square[SQUARE_BOUNDARY*SQUARE_BOUNDARY];

	private Square[][] squaresSquare = new Square[SQUARE_BOUNDARY][SQUARE_BOUNDARY];

	private Player[] players = new Player[2];

	private int currentPalerIdx = 0;
	private Player currentPlayer = null;

	public Board() {
		for (int i = 0; i < 9; i++) {
			Square square = new Square(i, i / SQUARE_BOUNDARY, i % SQUARE_BOUNDARY);
			this.squaresList[i] = square;
			this.squaresSquare[i / SQUARE_BOUNDARY][i % SQUARE_BOUNDARY] = square;
		}

		players[0] = new Player("X");
		players[1] = new Player("O");

	}

	public Player checkWinner() {
		Player winner = null;

		winner = crossGetWinner(0, 0, 0, 1);

		if (winner == null) {
			winner = crossGetWinner(1, 0, 0, 1);
		}
		if (winner == null) {
			winner = crossGetWinner(2, 0, 0, 1);
		}

		if (winner == null) {
			winner = crossGetWinner(0, 0, 1, 0);
		}
		if (winner == null) {
			winner = crossGetWinner(0, 1, 1, 0);
		}

		if (winner == null) {
			winner = crossGetWinner(0, 2, 1, 0);
		}

		if (winner == null) {
			winner = crossGetWinner(0, 0, 1, 1);
		}

		if (winner == null) {
			winner = crossGetWinner(0, 2, 1, -1);
		}

		return winner;
	}

	public Player crossGetWinner(int px, int py, int mx, int my) {

		int i = px, j = py;
		Player winner = this.squaresSquare[i][j].getPlayer();
		for (int k = 1; k < 3; k++) {
			if (winner == null)
				break;
			else {
				i += mx;
				j += my;
				Player p = this.squaresSquare[i][j].getPlayer();
				
				if (winner == p) {
					continue;
				} else {
					winner = null;
					break;
				}

			}
		}

		return winner;
	}

	public List<Square> notOccupiedSquares() {
		List<Square> list = new ArrayList<Square>();
		for (Square s : squaresList) {
			if (s.getPlayer() == null) {
				list.add(s);
			}
		}
		return list;
	}

	public Player getPlayerByName(String name) {
		Player p = null;
		for (Player p1 : players) {
			if (p1.getName().equals(name)) {
				p = p1;
				break;
			}
		}
		return p;
	}

	public Player getPlayerByNO(String NO) {
		Player p = null;
		for (Player p1 : players) {
			if (p1.getNO().equals(NO)) {
				p = p1;
				break;
			}
		}
		return p;
	}

	public void startFromPlayerByName(String name) {

		for (int i = 0; i < this.players.length; i++) {
			Player p1 = this.players[i];
			if (p1.getName().equals(name)) {
				this.currentPalerIdx = i;
				this.currentPlayer = p1;
				break;
			}
		}

	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public void startFromPlayerByNO(String NO) {

		for (int i = 0; i < this.players.length; i++) {
			Player p1 = this.players[i];
			if (p1.getNO().equals(NO)) {
				this.currentPalerIdx = i;
				this.currentPlayer = p1;
				break;
			}
		}

	}

	public void switch2NextPlayer() {
		this.currentPalerIdx++;
		this.currentPlayer = this.players[this.currentPalerIdx % this.players.length];

	}

	public void lowerTheChessPiece(char poNO) {
		this.squaresList[BoardUtils.squareNO2Index(poNO)].setPlayer(currentPlayer);

	}

	public boolean isOccupied(char poNO) {
		return this.squaresList[BoardUtils.squareNO2Index(poNO)].getPlayer() != null;
	}

	public boolean isFullHouse() {
		boolean f = true;
		for (Square s : this.squaresList) {
			if (s.getPlayer() == null) {
				f = false;
				break;
			}
		}
		return f;
	}

	public boolean isLegalPosNo(String po) {
		if (po.length() != 1)
			return false;
		for (int i = 1; i <= 9; i++) {
			if (po.equals(i + ""))
				return true;
		}
		return false;
	}
	
	public void displayBoard() {
		for(int i=0;i<this.squaresList.length;i++) {
			Square s=this.squaresList[i];
			Player p=s.getPlayer();
			System.out.print((p!=null?p.getNO():s.getNO())+"|");
			if(i%3==2) {
				System.out.println();
			}
		}
	}
}
