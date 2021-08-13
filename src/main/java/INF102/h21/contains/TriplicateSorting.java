package INF102.h21.contains;

import java.util.Collections;
import java.util.List;

/**
 * Checks for triplicate of given element. Sorts the list and searches for
 * the given element followed by (at least) two consecutive equal elements.
 * 
 * Time complexity: O(n*log(n))
 * 
 * @author Sondre Bolland
 *
 */
public class TriplicateSorting<T extends Comparable<T>> implements ITriplicate<T> {

	@Override
	public T findTriplicate(List<T> list) {
		Collections.sort(list);
		// For each element check if it is followed by 2 equal elements
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
