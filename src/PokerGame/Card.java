package PokerGame;

public abstract class Card {
	private boolean available = true;
	
	protected int faceValue;
	protected Suit suit;
	
	public Card(int c, Suit s) {
		// TODO Auto-generated constructor stub
		this.suit = s;
		this.faceValue = c;
	}
	
	public abstract int value();
	
	public Suit suit() {
		return suit;
	}
	
	public boolean isAvailable () {
		return available;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailable() {
		available = true;
	}
	
	public void setCard(Suit suit, int value) {
	}

}
