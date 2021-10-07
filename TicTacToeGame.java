package Swissbank;

import java.util.Scanner;

public class TicTacToeGame {

	public static Scanner s;

	public static void main(String[] args) throws Exception {
		s = new Scanner(System.in);
		do {
			TicTacToeGame tic = new TicTacToeGame();
			tic.startGame();

			System.out.print("try again input Y, otherwise quite? ");

			String line = s.nextLine();

			if (!"Y".equalsIgnoreCase(line)) {
				break;
			}
		} while (true);

		System.out.println("See you next time!");
		s.close();
	}

	public void startGame() {
		Board bd = new Board();

		System.out.print("Enter player X name:");
		String name = s.nextLine();
		Player p1 = bd.getPlayerByNO("X");
		p1.setName(name);

		System.out.print("Enter player Y name:");
		name = s.nextLine();
		Player p2 = bd.getPlayerByNO("O");
		p2.setName(name);

		bd.startFromPlayerByNO("X");

		Player currentPlayer = bd.getCurrentPlayer();

		System.out.println("start from player NO " + currentPlayer.getNO());

		Player winner = bd.checkWinner();
		while (winner == null) {
			bd.displayBoard();
			if (bd.isFullHouse()) {
				System.out.println("all positions are occupied, no winner!");
				break;
			} else {
				System.out.println(
						"Player " + currentPlayer.getNO() + " is your turn now, please input a position form 1 to 9 ");

				do {
					String posNO = s.nextLine();
					if (!bd.isLegalPosNo(posNO)) {
						System.out.println("Player " + currentPlayer.getNO()
								+ " is your turn now, please input a legal position form 1 to 9 ");

						continue;
					}

					if (bd.isOccupied(posNO.charAt(0))) {
						System.out.println("Player " + currentPlayer.getNO()
								+ " is your turn now, please input a not occupied position form 1 to 9 ");

						continue;
					}

					bd.lowerTheChessPiece(posNO.charAt(0));

					break;
				} while (true);

				winner = bd.checkWinner();
				bd.switch2NextPlayer();
				currentPlayer = bd.getCurrentPlayer();

			}
		}

		bd.displayBoard();

		if (winner != null)
			System.out.println("palyer NO " + winner.getNO() + " name " + winner.getName() + " is winner!");
		else {
			System.out.println("no winner!");
		}

	}
}
