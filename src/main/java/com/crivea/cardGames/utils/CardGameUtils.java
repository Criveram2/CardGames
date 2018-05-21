package com.crivea.cardGames.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.crivera.cardGames.model.Deck.Card;
import com.crivera.cardGames.model.Rank;
import com.google.common.base.Preconditions;

public final class CardGameUtils {

	private CardGameUtils() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}

	public static List<Card> changeTwoCardsInDeck(int indexOne, int indexTwo, List<Card> deck) {
		List<Card> newDeck = new ArrayList<Card>();
		newDeck.addAll(deck);

		Card firtsCard = newDeck.get(indexOne);
		Card secondCard = newDeck.get(indexTwo);
		newDeck.remove(indexOne);
		newDeck.add(indexOne, secondCard);
		newDeck.remove(indexTwo);
		newDeck.add(indexTwo, firtsCard);
		return newDeck;

	}

	public static int selectOneRandonPositionCardInDeck(List<Card> deck) {
		Preconditions.checkArgument((!deck.isEmpty()), "la lista no puede estar vacia");
		deck.size();
		Random rn = new Random();
		int numRandon = rn.nextInt(deck.size());
		return numRandon;
	}

	

	public static int valueRank(Rank rank) {
		switch (rank) {

		case TWO:
			return 2;

		case THREE:
			return 3;
		case FOUR:
			return 4;
		case FIVE:
			return 5;
		case SIX:
			return 6;
		case SEVEN:
			return 7;
		case EIGHT:
			return 8;
		case NINE:
			return 9;
		case A:
			return 1;
		case TEN:
			return 10;
		case J:
			return 10;
		case Q:
			return 10;
		case K:
			return 10;
		default:
			break;
		}

		return 0;

	}

}
