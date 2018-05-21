package com.crivera.cardGames.model;

import java.util.List;

import com.crivea.cardGames.utils.CardGameUtils;
import com.crivera.cardGames.model.Deck.Card;

public class Hand {
	private List<Card> cards;

	public Hand(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCart(Card card) {
		cards.add(card);
	}

	public int sumCards() {
		int sum = 0;
		for (Card temp : cards) {
			int num = CardGameUtils.valueRank(temp.getRank());
			sum += num;
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card temp : this.cards) {
			sb.append(temp.toString()).append("\n");
		}
		return sb.toString();
	}

}
