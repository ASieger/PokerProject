package poker;

public class PokerHandEvaluator {
	//YOUR IMPLEMENTATION HERE
	//THE METHODS MUST MATCH THE DESCRIPTIONS EXACTLY
	
	/* An example of a method whose signature satisfies the 
	 * Description provided to you in the documentation.
	 * 
	 * Naturally, you would replace the body of these methods with
	 * your logic ... that is, remove the exception and replace
	 * it with the appropriate logic that tests the incoming
	 * array of Cards for the desired property---in this
	 * case you would return true if and only if the array 
	 * of Cards represented a straight flush.
	 */
	public static boolean hasStraightFlush(Card[] cards) {	//sorts by value and by suit can checks for a straight and a flush
		sortHandByValue(cards);
		sortHandBySuit(cards);
		if(hasStraight(cards) && hasFlush(cards))
			return true;
		else
			return false;
	}
	
	public static boolean hasStraight(Card [] cards) {	//checks to see if the first card is an ace and does the
		sortHandByValue(cards);							//two possibilities to for a straight to occur,
		if(cards[0].getValue() == 1){					//otherwise checks the one other possibility
			if(cards[1].getValue() == 10 && cards[2].getValue() == 11 && cards[3].getValue() == 12 && cards[4].getValue() == 13)
				return true;
			else if(cards[1].getValue() == 2 && cards[2].getValue() == 3 && cards[3].getValue() == 4 && cards[4].getValue() == 5)
				return true;
			else
				return false;
		}
		else{
			int testNumber = cards[0].getValue();
			if(cards[1].getValue() == testNumber + 1 && cards[2].getValue() == testNumber + 2 && cards[3].getValue() == testNumber + 3 && cards[4].getValue() == testNumber + 4)
				return true;
			else
				return false;
		}
	}
	
	public static boolean hasFlush(Card[] cards) {	//checks to see if the suit value of the first card	
		sortHandBySuit(cards);						//equals the suit value of the last card
		if(cards[0].getSuit() == cards[4].getSuit())
			return true;
		else
			return false;
	}
	
	public static boolean hasFourOfAKind(Card[] cards) {	//checks the two possiblies for this to happen
		sortHandByValue(cards);
		if((cards[0].getValue() == cards[1].getValue()) && (cards[1].getValue() == cards[2].getValue()) && (cards[2].getValue() == cards[3].getValue()))
			return true;
		else if((cards[1].getValue() == cards[2].getValue()) && (cards[2].getValue() == cards[3].getValue()) && (cards[3].getValue() == cards[4].getValue()))
			return true;
		else 
			return false;
	}
	
	public static boolean hasFullHouse(Card[] cards) {	//checks the two possibilities for this to happen
		sortHandByValue(cards);
		if(((cards[0].getValue() == cards[1].getValue()) && (cards[1].getValue() == cards[2].getValue())) && (cards[3].getValue() == cards[4].getValue()))
			return true;
		else if(((cards[2].getValue() == cards[3].getValue()) && (cards[3].getValue() == cards[4].getValue())) && (cards[0].getValue() == cards[1].getValue()))
			return true;
		else
			return false;
	}
	
	public static boolean hasThreeOfAKind(Card[] cards) {	//checks the 3 possibilities for this to happen
		sortHandByValue(cards);
		if((cards[0].getValue() == cards[1].getValue()) && (cards[1].getValue() == cards[2].getValue()))
			return true;
		else if((cards[1].getValue() == cards[2].getValue()) && (cards[2].getValue() == cards[3].getValue()))
			return true;
		else if((cards[2].getValue() == cards[3].getValue()) && (cards[3].getValue() == cards[4].getValue()))
			return true;
		else
			return false;
		
	}
	
	public static boolean hasTwoPair(Card[] cards) {	//checks the 3 possibilities for this to happen
		sortHandByValue(cards);
		if((cards[0].getValue() == cards[1].getValue()) && (cards[2].getValue() == cards[3].getValue()) && (cards[0].getValue() != cards[2].getValue()))
			return true;
		else if((cards[0].getValue() == cards[1].getValue()) && (cards[3].getValue() == cards[4].getValue()) && (cards[0].getValue() != cards[3].getValue()))
			return true;
		else if((cards[1].getValue() == cards[2].getValue()) && (cards[3].getValue() == cards[4].getValue()) && (cards[1].getValue() != cards[3].getValue()))
			return true;
		else
			return false;
	}
	
	public static boolean hasPair(Card[] cards) {	//checks the 4 possibilities for this to happen
		sortHandByValue(cards);
		if(cards[0].getValue() == cards[1].getValue())
			return true;
		else if(cards[1].getValue() == cards[2].getValue())
			return true;
		else if(cards[2].getValue() == cards[3].getValue())
			return true;
		else if(cards[3].getValue() == cards[4].getValue())
			return true;
		else
			return false;
			
	}
	private static void sortHandBySuit(Card[] cards){	//does a selection sort based on the value of the suit
		int lowestSuit;
		for(int i = 0; i < cards.length; i++){
			lowestSuit = i;
			for(int j = i + 1; j < cards.length; j++){
				if(cards[j].getSuit() < cards[lowestSuit].getSuit()){
					lowestSuit = j;
				}
			}
			Card temp = cards[i];
			cards[i] = cards[lowestSuit];
			cards[lowestSuit] = temp;
		}
	}
	private static void sortHandByValue(Card[] cards){	//does a selection sort based on the value of the card
		int lowestValue;
		for(int i = 0; i < cards.length; i++){
			lowestValue = i;
			for(int j = i + 1; j < cards.length; j++){
				if(cards[j].getValue() < cards[lowestValue].getValue()){
					lowestValue = j;
				}
			}
			Card temp = cards[i];
			cards[i] = cards[lowestValue];
			cards[lowestValue] = temp;
		}
	}
	
}

