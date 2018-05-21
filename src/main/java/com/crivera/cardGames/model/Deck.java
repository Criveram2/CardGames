package com.crivera.cardGames.model;

import java.util.ArrayList;
import java.util.List;

import com.crivea.cardGames.utils.CardGameUtils;

public final class Deck {
	private static final int NUM_CHANGES = 100;
	private static final int NUMBER_CARDS = 52;
	List<Card> deck;

	public Deck() {
		List<Card> deck = createDeck();

		this.deck = deck;
	}

	public Deck(List<Card> deck) {
		this.deck = deck;
	}

	public List<Card> createDeck() {

		List<Card> deck = new ArrayList<Card>(NUMBER_CARDS);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card card = new Card(r, s);
				deck.add(card);
			}
		}

		return deck;
	}

	public Deck mixDeck() {
		List<Card> newListCard = this.deck;
		for (int i = 1; i < NUM_CHANGES; i++) {
			int indexOne = CardGameUtils.selectOneRandonPositionCardInDeck(newListCard);
			int indexTwo = CardGameUtils.selectOneRandonPositionCardInDeck(newListCard);
			newListCard = CardGameUtils.changeTwoCardsInDeck(indexOne, indexTwo, newListCard);
		}

		Deck newdeck = new Deck(newListCard);
		return newdeck;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deck == null) ? 0 : deck.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (deck == null) {
			if (other.deck != null)
				return false;
		} else if (!deck.equals(other.deck))
			return false;
		return true;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public class Card {
		private Rank rank;
		private Suit suit;

		public Card(Rank rank, Suit suit) {
			this.rank = rank;
			this.suit = suit;
		}

		
		public Rank getRank() {
			return rank;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((rank == null) ? 0 : rank.hashCode());
			result = prime * result + ((suit == null) ? 0 : suit.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Card other = (Card) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (rank != other.rank)
				return false;
			if (suit != other.suit)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[ " + rank.value(rank) + " " + suit + "]";
		}

		private Deck getOuterType() {
			return Deck.this;
		}

	}

}
