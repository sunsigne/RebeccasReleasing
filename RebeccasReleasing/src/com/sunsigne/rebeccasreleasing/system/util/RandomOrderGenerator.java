package com.sunsigne.rebeccasreleasing.system.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public final class RandomOrderGenerator {
	
	public int[] randomOrderGenerationFromOneTo(int max) {

		int[] randomOrder = new int[max];

		// creation of numbers from 1 to max
		LinkedList<Integer> numbers = new LinkedList<>();
		for (int i = 1; i < max + 1; i++) {
			numbers.add(i);
		}

		// shuffle of the numbers
		Random r = new Random();
		for (int i = 0; i < max; i++) {
			Collections.swap(numbers, i, r.nextInt(max));
		}

		// register of this new order into randomOrder.
		for (int i = 0; i < max; i++) {
			randomOrder[i] = numbers.get(0);
			numbers.remove(0);
		}

		return randomOrder;
	}
	
}
