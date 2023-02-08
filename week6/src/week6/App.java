package week6;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instantiate a Deck and two Players
		Deck deck = new Deck();
		Player player1 = new Player("Bob");
		Player player2 = new Player("Joe");

		// Shuffle the deck
		deck.shuffle();

		// Deal the Cards evenly to the players
		for (int i = 0; i < 52; i++) {
			if (i % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}

		// print out player details
		System.out.println("Introducing Player 1: ");
		System.out.println(player1.describe());
		System.out.println();

		System.out.println("Introducing Player 2: ");
		System.out.println(player2.describe());
		System.out.println();

		// play game
		for (int i = 0; i < 26; i++) {
			System.out.println("Round: " + (i + 1));

			Card p1Card = player1.flip();
			System.out.println(player1.getName() + " played a " + p1Card.describe());

			Card p2Card = player2.flip();
			System.out.println(player2.getName() + " played a " + p2Card.describe());

			if (p1Card.getValue() > p2Card.getValue()) {
				// player 1 wins
				player1.incrementScore();
				System.out.println("Player 1, " + player1.getName() + ", wins the round");
			} else if (p1Card.getValue() < p2Card.getValue()) {
				// player 2 wins
				player2.incrementScore();
				System.out.println("Player 2, " + player2.getName() + ", wins the round");
			} else if (p1Card.getValue() == p2Card.getValue()) {
				// war condition
				// TODO - add war
			}

			System.out.println(CurrentPoints(player1, player2));

			// add white space
			System.out.println("\n-------------------------\n");
		}

		// check winner
		if (player1.getScore() > player2.getScore()) {
			// player 1 wins
			System.out.println("Player 1, " + player1.getName() + ", Wins\n");
		} else if (player1.getScore() < player2.getScore()) {
			// player 2 wins
			System.out.println("Player 2, " + player2.getName() + ", Wins\n");
		} else {
			// draw
			System.out.println("It's a Draw\n");
		}

		// describe players again
		System.out.println(player1.describe());
		System.out.println(player2.describe());

	}

	static String CurrentPoints(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			// player 1 has more points
			return "Player 1, " + player1.getName() + " currently has the lead with "
					+ (player1.getScore() - player2.getScore()) + " more points than " + player2.getName();
		} else if (player1.getScore() < player2.getScore()) {
			// player 2 has more points
			return "Player 2, " + player2.getName() + " currently has the lead with "
					+ (player2.getScore() - player1.getScore()) + " more points than " + player1.getName();
		} else {
			// tie
			return "Right now is anyone's game with a tie of " + player1.getScore() + " points";
		}
	}

}
