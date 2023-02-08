package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// list of all cards in the deck
	private List<Card> cards = new ArrayList<Card>();

	// used to create all the cards in the deck
	final String[] cardValueNames = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
			"Queen", "King", "Ace" };

	Deck() {
		// fills the deck with new cards
		resetDeck();
	}

	private void resetDeck() {
		// make sure there are no remaining cards from the old deck
		cards.clear();

		// Create a deck of cards
		for (int i = 0; i < 13; i++) {
			cards.add(new Card(i + 2, cardValueNames[i] + " of Diamonds"));
			cards.add(new Card(i + 2, cardValueNames[i] + " of Hearts"));
			cards.add(new Card(i + 2, cardValueNames[i] + " of Spades"));
			cards.add(new Card(i + 2, cardValueNames[i] + " of Clubs"));
		}
	}

	void shuffle() {
		Collections.shuffle(cards);
	}

	Card draw() {
		Card topCard = cards.get(0);
		cards.remove(0);
		return topCard;
	}

}
