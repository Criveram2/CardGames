package com.crivera.cardGames.api;

import com.crivera.cardGames.model.Deck.Card;

import java.util.List;

import com.crivera.cardGames.model.Hand;

public interface CardsGames {

	public void startGame();

	public Card takeFirstCardToDeck();

	public Hand addCardToHand(Hand hand, Card card);

	public String viewHand(Hand hand);

	public List<Card> takeTwoCardsToDeck();

	public String defineTheWinner(Hand player, Hand dealer);
}
