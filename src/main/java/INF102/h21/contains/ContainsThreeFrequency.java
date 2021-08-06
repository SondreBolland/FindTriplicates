package INF102.h21.contains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Checks for duplicate triple of given element.
 * Saves the frequencies of all numbers. Proceeds to search through frequency list for the given
 * element and checks if the frequency is three (or higher).
 * 
 * Time complexity: O(n^2)
 * 
 * @author Sondre Bolland
 *
 */
public class ContainsThreeFrequency<T> implements IContainsThree<T> {

	@Override
	public boolean containsThree(List<T> list, T element) {
		Map<T, Integer> frequencies = new HashMap<>();
		// Record frequency of all integers in list
		for (T e: list) {
			if (frequencies.containsKey(e))
				frequencies.put(e, frequencies.get(e)+1);
			else
				frequencies.put(e, 1);
		}
		// Iterate map to find the element and check if frequency >= 3
		for (T key: frequencies.keySet()) {
			if (frequencies.get(key) >= 3 && key.equals(element))
				return true;
		}
		return false;
	}

}
