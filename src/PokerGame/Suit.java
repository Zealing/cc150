package PokerGame;

public enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;
	
	private Suit(int v) {
		// TODO Auto-generated constructor stub
		this.value = v;
	}
	public int getValue() {
		return value;
	}
	
	public static Suit getSuitFromValue(int v) {
		Suit res = null;
		switch(v) {
			case 0:
				res = Club;
			case 1:
				res = Diamond;
			case 2:
				res = Heart;
			case 3:
				res = Spade;
		}
		return res;
	}

}
