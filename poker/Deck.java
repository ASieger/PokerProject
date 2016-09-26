package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		cards = new Card[52];
		int counter = 0;
		for(int i = 0; i < 4; i++)
			for(int j = 1; j < 14; j++){
				cards[counter] = new Card(j, i);
				counter++;
			}
	}

	public Deck(Deck other) {
		cards = new Card[other.getNumCards()];
		for(int i = 0; i < other.getNumCards(); i++)
			cards[i] = other.getCardAt(i);
	}

	public Card getCardAt(int position) {
		return cards[position];
	}

	public int getNumCards() {
		return cards.length;
	}

	/* hint: even and odd */
	public void shuffle() {
		if(this.getNumCards() % 2 == 1){
			int counter = 0;
			Card[] top = new Card[this.getNumCards() / 2 + 1];
			Card[] bottom = new Card[this.getNumCards() / 2];
			
			for(int i = 0; i < top.length; i++){
				top[i] = this.getCardAt(i);
				counter++;
			}
			for(int i = 0; i < bottom.length; i++){
				bottom[i] = this.getCardAt(counter);
				counter++;
			}
			counter = 0;
			for(int i = 0; i < this.getNumCards(); i++){
				if(i % 2 == 0){
					if(i == this.getNumCards() - 2)
						cards[i] = top[counter + 1];
					else
						cards[i] = top[counter];
				}
				else{
					cards[i] = bottom[counter];
					counter++;
				}
			}
		}
		else{
			int counter = 0;
			Card[] top = new Card[this.getNumCards() / 2];
			Card[] bottom = new Card[this.getNumCards() / 2];
			
			for(int i = 0; i < top.length; i++){
				top[i] = this.getCardAt(i);
				counter++;
			}
			
			for(int i = 0; i < bottom.length; i++){
				bottom[i] = this.getCardAt(counter);
				counter++;
			}
			counter = 0;
			for(int i = 0; i < this.getNumCards(); i++){
				if(i % 2 == 0)
					cards[i] = top[counter];
				else{
					cards[i] = bottom[counter];
					counter++;
				}
			}
		}
			
	}

	public void cut(int position) {
		int counter = 0;
		Card[] top = new Card[position];
		Card[] bottom = new Card[this.getNumCards() - position];
		for(int i = 0; i < position; i++){
			top[i] = cards[i];
			counter++;
		}
		for(int i = 0; i < this.getNumCards() - position; i++){
			bottom[i] = cards[counter];
			counter++;
		}
		counter = 0;
		for(int i = 0; i < this.getNumCards(); i++){
			if(i >= this.getNumCards() - position){
				cards[i] = top[counter];
				counter++;
			}
			else
				cards[i] = bottom[i];
		}
			
	}

	public Card[] deal(int numCards) {
		Card[] hand = new Card[numCards];
		Card[] smaller = new Card[this.getNumCards() - numCards];
		for(int i = 0; i < numCards; i++)
			hand[i] = cards[i];
		for(int i = numCards; i < this.getNumCards(); i++)
			smaller[i - numCards] = cards[i];
		cards = smaller;
		return hand;
	}
 
}
