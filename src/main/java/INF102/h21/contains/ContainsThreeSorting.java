package INF102.h21.contains;

import java.util.Collections;
import java.util.List;

/**
 * Checks for duplicate triple of given element.
 * Sorts the list and searches for the given element
 * followed by (at least) two consecutive equal elements.
 * 
 * @author Sondre Bolland
 *
 */
public class ContainsThreeSorting<T extends Comparable<T>> implements IContainsThree<T> {

	@Override
	public boolean containsThree(List<T> list, T element) {
		Collections.sort(list);
		for (int i = 0; i < list.size() - 2; i++) {
			T one = list.get(i);
			if (one.equals(element)) {
				T two = list.get(i + 1);
				T three = list.get(i + 2);
				if (two.equals(element) && three.equals(element))
					return true;
				else
					return false;
			}
		}
		return false;
	}

}
