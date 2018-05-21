package com.crivera.cardGames.impl;

import java.util.ArrayList;
import java.util.List;

import com.crivea.cardGames.utils.BlackJackUtils;
import com.crivera.cardGames.api.CardsGames;
import com.crivera.cardGames.model.Deck;
import com.crivera.cardGames.model.Deck.Card;
import com.crivera.cardGames.model.Hand;

public class BlackJackImpl implements CardsGames {

	private static final int PERFECT_GAME = 21;
	private Deck deck;

	@Override
	public void startGame() {
		Deck orderdeck = new Deck();
		deck = orderdeck.mixDeck();

	}

	@Override
	public Card takeFirstCardToDeck() {
		List<Card> carts = deck.getDeck();
		Card firtsCard = carts.get(0);
		this.deck = deleateFirtsCardDeck();
		return firtsCard;
	}

	@Override
	public List<Card> takeTwoCardsToDeck() {
		List<Card> firtsHand = new ArrayList<Card>();
		for (int i = 1; i <= 2; i++) {
			Card card = takeFirstCardToDeck();
			firtsHand.add(card);
		}
		return firtsHand;
	}

	@Override
	public Hand addCardToHand(Hand hand, Card card) {
		Hand newHand = new Hand(hand.getCards());
		newHand.addCart(card);
		return newHand;
	}

	@Override
	public String viewHand(Hand hand) {
		return hand.toString();
	}

	@Override
	public String defineTheWinner(Hand player, Hand dealer) {
		int pointPlayer = BlackJackUtils.countPointsHand(player);
		int pointDealer = BlackJackUtils.countPointsHand(dealer);
		if (pointPlayer > 21) {
			return "dealer";
		} else {
			if (pointDealer > 21) {
				return "Player";
			}
			int valuePlayer = difereceToPerfectGame(pointPlayer);
			int valueDealer = difereceToPerfectGame(pointDealer);
			return defineTheWinnerByPoints(valuePlayer, valueDealer);
		}
	}

	private String defineTheWinnerByPoints(int valuePlayer, int valueDealer) {
		if (valuePlayer == valueDealer)
			return "tied";
		if (valuePlayer < valueDealer)
			return "Player";
		else
			return "Dealer";
	}

	private int difereceToPerfectGame(int pointPlayer) {
		return PERFECT_GAME - pointPlayer;
	}

	private Deck deleateFirtsCardDeck() {
		List<Card> carts = deck.getDeck();
		carts.remove(0);
		Deck newDeck = new Deck(carts);
		return newDeck;
	}

}
