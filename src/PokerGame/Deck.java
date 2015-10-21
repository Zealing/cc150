package PokerGame;

import java.util.ArrayList;

public class Deck<T extends Card> {

	private ArrayList<T> cards;//all cards, deal or not
	private int dealtIndex = 0;
	
	public void setDeckOfCards (ArrayList<T> deckOfCards) {
		this.cards = deckOfCards;
	}
	
	public void setDeck() {
		cards = new ArrayList<T>();
	}
	
	public void shuffle() {
		
	}
	
	public void addCard(T card) {
		
	}
	
	public int remainingCard() {
		return cards.size() - dealtIndex;
		
	}
	
	public T[] dealHand (int number) {
		return null;
	}
	
	public T dealCard() {
		return null;
	}
	
	public void cards() {
		// TODO Auto-generated constructor stub
	}

}
