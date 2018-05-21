package com.crivera.cardGames.controller;

import com.crivea.cardGames.utils.BlackJackUtils;
import com.crivea.cardGames.utils.MenuUtils;
import com.crivera.cardGames.api.CardsGames;
import com.crivera.cardGames.impl.BlackJackImpl;

import com.crivera.cardGames.model.Hand;

public class BlackJackController {

	public static void main(String[] args) {

		CardsGames blackJack = new BlackJackImpl();
		System.out.println("Game Start");
		blackJack.startGame();
		System.out.println("firts Hand");
		Hand player = new Hand(blackJack.takeTwoCardsToDeck());
		Hand dealer = new Hand(blackJack.takeTwoCardsToDeck());
		System.out.print(blackJack.viewHand(player));
		System.out.println("digite 1 si no deseas otra carta");
		int value = MenuUtils.ReadOption();
		boolean endGame = false;
		while (value != 1) {
			player = blackJack.addCardToHand(player, blackJack.takeFirstCardToDeck());
			System.out.print((blackJack.viewHand(player)));
			if (player.sumCards() < 21) {
				System.out.println("digite 1 si no deseas otra carta");
				value = MenuUtils.ReadOption();
			} else {
				value = 1;
				endGame = true;
			}
		}
		if (!endGame) {
			while (BlackJackUtils.countPointsHand(dealer) < 17) {
				dealer = blackJack.addCardToHand(dealer, blackJack.takeFirstCardToDeck());
			}
		}

		System.out.println("Player");
		System.out.print(blackJack.viewHand(player));
		System.out.println( BlackJackUtils.countPointsHand(player));
		System.out.println("Deleare");
		System.out.print(blackJack.viewHand(dealer));
		System.out.println( BlackJackUtils.countPointsHand(dealer));
		System.out.println("the winner is " + blackJack.defineTheWinner(player, dealer));

	}
}
