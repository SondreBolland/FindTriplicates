package INF102.h21.contains;

import java.util.List;

/**
 * Checks for duplicate triple of given element, by means of brute force.
 * 
 * Time complexity: O(n^3)
 * 
 * @author Sondre Bolland
 *
 */
public class ContainsThreeSimple<T> implements IContainsThree<T> {

	@Override
	public boolean containsThree(List<T> list, T element) {
		int length = list.size();
		for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				for (int k = j+1; k < length; k++) {
					T one = list.get(i);
					T two = list.get(j);
					T three = list.get(k);
					if (one.equals(element) && two.equals(element) && three.equals(element)) {
						return true;
					}
				}
			}
		}
		return false;
	}

		
}
