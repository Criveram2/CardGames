package com.crivera.cardGames.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crivea.cardGames.utils.BlackJackUtils;
import com.crivera.cardGames.model.Deck;
import com.crivera.cardGames.model.Deck.Card;
import com.crivera.cardGames.model.Hand;

public class BlackJackUtilsTest {

	@Test
	public void newDeckHaveFourAs() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		for (Card temp : deck.getDeck()) {
			if (BlackJackUtils.isA(temp)) {
				cards.add(temp);
			}
		}
		assertThat(cards.size(), is(4));
	}

	@Test
	public void theBetterOptionByAAAAisForteen() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		for (Card temp : deck.getDeck()) {
			if (BlackJackUtils.isA(temp)) {
				cards.add(temp);
			}
		}
		Hand hand = new Hand(cards);
		assertThat(BlackJackUtils.countPointsHand(hand), is(14));
	}
	
	@Test
	public void A_JisTwentyOne() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		cards.add(deck.getDeck().get(0));//A
		cards.add(deck.getDeck().get(10));//J
		Hand hand = new Hand(cards);
		assertThat(BlackJackUtils.countPointsHand(hand), is(21));
	}
	
	@Test
	public void A_NINEisTwenty() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		cards.add(deck.getDeck().get(0));//A
		cards.add(deck.getDeck().get(8));//9
		Hand hand = new Hand(cards);
		assertThat(BlackJackUtils.countPointsHand(hand), is(20));
	}
	
	@Test
	public void dobleAisTwelve() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		cards.add(deck.getDeck().get(0));//A
		cards.add(deck.getDeck().get(13));//A
		Hand hand = new Hand(cards);
		assertThat(BlackJackUtils.countPointsHand(hand), is(12));
	}
	
	@Test
	public void theBetterOptionByfourTwoisEight() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		for (Card temp : deck.getDeck()) {
			if (temp.getRank().toString() == "TWO") {
				cards.add(temp);
			}
		}
		Hand hand = new Hand(cards);
		assertThat(BlackJackUtils.countPointsHand(hand), is(8));
	}

}
