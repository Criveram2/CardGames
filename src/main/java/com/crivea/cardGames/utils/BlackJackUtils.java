package com.crivea.cardGames.utils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.crivera.cardGames.model.Deck.Card;
import com.crivera.cardGames.model.Hand;

public final class BlackJackUtils {

	private BlackJackUtils() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}

	public static int countPointsHand(Hand hand) {
		int count = countAinHand(hand);
		if (count == 0) {
			return hand.sumCards();
		} else {
			Set<Integer> optionHand = countAllOptions(hand.getCards(), count);
			return selectBetterOption(optionHand);

		}

	}
	
	public static boolean isA(Card card) {
		if (card.getRank().toString() == "A") {
			return true;
		}
		return false;
	}

	private static int selectBetterOption(Set<Integer> options) {
		LinkedHashSet<Integer> optiorsInOrder = (LinkedHashSet<Integer>) options;
		int betterOption = 0;
		for (Integer temp : optiorsInOrder) {
			int value = temp.intValue();
			if (value <= 21) {
				betterOption = value;
			}

		}
		return betterOption;
	}


	private static Set<Integer> countAllOptions(List<Card> cards, int countsA) {
		Set<Integer> opcionHand = new LinkedHashSet<>();
		for (int i = 0; i <= countsA; i++) {
			Integer result = 0;
			int cardChange = 0;
			for (Card temp : cards) {
				int value = takeValueCard(i, temp, cardChange);
				cardChange++;
				result += value;
			}
			opcionHand.add(result);
		}
		return opcionHand;
	}

	private static int takeValueCard(int countAtoChange, Card temp, int countAtoChanged) {
		if (isA(temp)) {
			return changedAtoEleven(countAtoChange, countAtoChanged);
		} else {
			return CardGameUtils.valueRank(temp.getRank());
		}

	}

	private static int changedAtoEleven(int countAtoChange, int countAtoChanged) {

		if (countAtoChange > countAtoChanged) {
			return 11;
		} else {
			return 1;

		}
	}

	private static int countAinHand(Hand hand) {
		int count = 0;
		for (Card temp : hand.getCards()) {
			if (isA(temp)) {
				count++;
			}
		}
		return count;
	}


}
