package week6;

import java.util.List;
import java.util.ArrayList;

public class Player {
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;

	Player(String name) {
		setName(name);
		setScore(0);
	}

	Player() {
		setScore(0);
	}

	public String describe() {
		// TODO - prints out information about the player and calls the describe method
		// for each card in the Hand List
		StringBuilder message = new StringBuilder();
		message.append(name).append(" has a score of ").append(score).append(" and has ").append(hand.size()).append(" cards.\n");
		
		//Only describe their cards if there are some left in their hand
		if (hand.size() > 0) {
			message.append("Their cards are:\n");
			
			//loop through and describe every card
			for (int i = 0; i < hand.size(); i++) {
				message.append((i + 1) + "). " + hand.get(i).describe());
			}
		}

		return message.toString();
	}

	public Card flip() {
		// removes and returns the top card of the Hand
		Card topCard = hand.get(0);
		hand.remove(0);
		return topCard;
	}

	public void draw(Deck deck) {
		// Takes a Deck as an argument and calls the draw method on the deck,
		// adding the returned Card to the hand field
		hand.add(deck.draw());
	}

	public void incrementScore() {
		// adds 1 to the Player’s score field
		score++;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
