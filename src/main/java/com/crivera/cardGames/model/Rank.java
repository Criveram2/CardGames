package com.crivera.cardGames.model;

public enum Rank {
	A, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K;

	public String value(Rank rank) {

		switch (rank) {

		case TWO:
			return "2";

		case THREE:
			return "3";
		case FOUR:
			return "4";
		case FIVE:
			return "5";
		case SIX:
			return "6";
		case SEVEN:
			return "7";
		case EIGHT:
			return "8";
		case NINE:
			return "9";
		case TEN:
			return "10";
		default:
			break;
		}

		return rank.toString();

	}

}
