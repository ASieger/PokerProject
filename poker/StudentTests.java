package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	@Test
	public void testSingleTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(5,1);
		//assertFalse(PokerHandEvaluator.hasPair(testHand));
	}
	@Test
	public void testPair(){			//tests the hasPair method using a hand with a pair
		Card[] cards = new Card[5]; //and a hand without a pair
		cards[0] = new Card(1,1);
		cards[1] = new Card(1,1);
		cards[2] = new Card(3,1);
		cards[3] = new Card(4,1);
		cards[4] = new Card(5,1);
		assertTrue(PokerHandEvaluator.hasPair(cards));
		cards[0] = new Card(2, 1);
		assertFalse(PokerHandEvaluator.hasPair(cards));
	}
	@Test
	public void testTwoPair(){		//tests the hasTwoPair method using a hand with two pairs
		Card[] cards = new Card[5]; //and a hand with a four of a kind, and a hand with no
		cards[0] = new Card(1,1);	//pairs
		cards[1] = new Card(1,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(2,1);
		cards[4] = new Card(5,1);
		assertTrue(PokerHandEvaluator.hasTwoPair(cards));
		cards[0] = new Card(2, 1);
		cards[1] = new Card(2 ,1);
		assertFalse(PokerHandEvaluator.hasTwoPair(cards));
		cards[0] = new Card(1, 1);
		assertFalse(PokerHandEvaluator.hasTwoPair(cards));
	}
	@Test
	public void testThreeKind(){		//tests the hasThreeOfAKind method using two different hands with three
		Card[] cards = new Card[5]; //of a kind, and a hand with no three of a kind
		cards[0] = new Card(1,1);
		cards[1] = new Card(1,1);
		cards[2] = new Card(1,1);
		cards[3] = new Card(2,1);
		cards[4] = new Card(5,1);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(cards));
		cards[0] = new Card(2, 1);
		cards[1] = new Card(2 ,1);
		cards[3] = new Card(1, 1);
		cards[4] = new Card(1, 1);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(cards));
		cards[4] = new Card(5, 1);
		cards[3] = new Card(3, 1);
		cards[0] = new Card(4, 1);
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(cards));
	}
	@Test
	public void testFullHouse(){		//tests the hasFullHouse method using a hand with a different
		Card[] cards = new Card[5]; 	//combination of a pair and three of a kind, and one hand with
		cards[0] = new Card(1,1);		//no full house
		cards[1] = new Card(1,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(2,1);
		cards[4] = new Card(2,1);
		assertTrue(PokerHandEvaluator.hasFullHouse(cards));
		cards[0] = new Card(2, 1);
		cards[1] = new Card(2, 1);
		cards[2] = new Card(1, 1);
		cards[3] = new Card(1, 1);
		cards[4] = new Card(1, 1);
		assertTrue(PokerHandEvaluator.hasFullHouse(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(4, 1);
		assertFalse(PokerHandEvaluator.hasFullHouse(cards));
	}
	@Test
	public void testFourKind(){			//tests the hasFourOfAKind method using a hand with a different
		Card[] cards = new Card[5]; 	//combination of a four of kind, and one hand with
		cards[0] = new Card(1,1);		//no four of kind
		cards[1] = new Card(2,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(2,1);
		cards[4] = new Card(2,1);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(1, 1);
		cards[2] = new Card(1, 1);
		cards[3] = new Card(1, 1);
		cards[4] = new Card(2, 1);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(4, 1);
		assertFalse(PokerHandEvaluator.hasFourOfAKind(cards));
	}
	@Test
	public void testFlush(){			//tests the hasFlush method using a hand with a flush
		Card[] cards = new Card[5]; 	//and a hand without a flush
		cards[0] = new Card(1,1);
		cards[1] = new Card(2,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(2,1);
		cards[4] = new Card(2,1);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(1, 2);
		cards[2] = new Card(1, 1);
		cards[3] = new Card(1, 1);
		cards[4] = new Card(2, 1);
		assertFalse(PokerHandEvaluator.hasFlush(cards));
	}
	@Test
	public void testStraight(){			//tests the hasStraight method using a hand with a normal
		Card[] cards = new Card[5]; 	//straight, a hand with a straight and an ace, and a hand with
		cards[0] = new Card(3, 1);		//straight
		cards[1] = new Card(4, 1);
		cards[2] = new Card(5, 1);
		cards[3] = new Card(6, 1);
		cards[4] = new Card(7, 1);
		assertTrue(PokerHandEvaluator.hasStraight(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(10, 1);
		cards[2] = new Card(11, 1);
		cards[3] = new Card(12, 1);
		cards[4] = new Card(13, 1);
		assertTrue(PokerHandEvaluator.hasStraight(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(4, 1);
		assertFalse(PokerHandEvaluator.hasStraight(cards));
	}
	@Test
	public void testStraightFlush(){	//tests the hasStraightFLush method using a hand with a normal
		Card[] cards = new Card[5]; 	//straight flush, a hand with a royal flush, and a hand with
		cards[0] = new Card(3, 1);		//no straight flush
		cards[1] = new Card(4, 1);
		cards[2] = new Card(5, 1);
		cards[3] = new Card(6, 1);
		cards[4] = new Card(7,1 );
		assertTrue(PokerHandEvaluator.hasStraightFlush(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(10, 1);
		cards[2] = new Card(11, 1);
		cards[3] = new Card(12, 1);
		cards[4] = new Card(13, 1);
		assertTrue(PokerHandEvaluator.hasStraightFlush(cards));
		cards[0] = new Card(1, 1);
		cards[1] = new Card(4, 1);
		assertFalse(PokerHandEvaluator.hasStraightFlush(cards));
	}




}
