package com.crivera.cardGames.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crivea.cardGames.utils.CardGameUtils;
import com.crivera.cardGames.model.Deck;
import com.crivera.cardGames.model.Deck.Card;

public class CardGameUtilsTest {

	@Test
	public void changeTwoCardsInDeck() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		cards = deck.getDeck(); 
		List<Card> newCards = CardGameUtils.changeTwoCardsInDeck(0, 1, cards);
		assertThat(newCards.get(0).toString(), is(cards.get(1).toString()));
	}
}
