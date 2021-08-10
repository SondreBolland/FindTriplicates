package INF102.h21.contains;

import java.util.Collections;
import java.util.List;

/**
 * Checks for duplicate triple of given element. Sorts the list and searches for
 * the given element followed by (at least) two consecutive equal elements.
 * 
 * Time complexity: O(n*log(n))
 * 
 * @author Sondre Bolland
 *
 */
public class ContainsThreeSorting<T extends Comparable<T>> implements IContainsThree<T> {

	@Override
	public T containsThree(List<T> list) {
		Collections.sort(list);
		// Iterate list to find element. Check if it followed by >= 3 equal elements
		for (int i = 0; i < list.size() - 2; i++) {
			T one = list.get(i);
			T two = list.get(i + 1);
			T three = list.get(i + 2);
			if (one.equals(two) && two.equals(three))
				return one;
		}
		return null;
	}

}
