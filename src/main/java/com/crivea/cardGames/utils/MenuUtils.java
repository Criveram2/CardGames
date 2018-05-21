package com.crivea.cardGames.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUtils {

	private static Scanner in;

	private MenuUtils() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}

	public static int ReadOption() {

		in = new Scanner(System.in);
		try {
			int num = in.nextInt();
			return num;
		} catch (InputMismatchException e) {
			return 0;
		}

	}

}
