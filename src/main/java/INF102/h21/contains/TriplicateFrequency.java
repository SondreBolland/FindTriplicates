package INF102.h21.contains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Checks for triplicate of given element. Saves the frequencies of all
 * numbers. Proceeds to search through frequency list for the given element and
 * checks if the frequency is three (or higher).
 * 
 * Time complexity: O(n^2)
 * 
 * @author Sondre Bolland
 *
 */
public class TriplicateFrequency<T> implements ITriplicate<T> {

	@Override
	public T findTriplicate(List<T> list) {
		Set<T> visited = new HashSet<>();
		// Record frequency of all integers in list
		for (int i = 0; i < list.size(); i++) {
			T e = list.get(i);
			if (visited.contains(e))
				continue;
			visited.add(e);
			int count = 0;
			for (int j = i; j < list.size(); j++) {
				if (list.get(j).equals(e))
					count++;
				if (count >= 3)
					return e;
			}
		}
		return null;
	}

}
