package INF102.h21.contains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Checks for triplicate of given element. Records the frequencies of all numbers in HashMap.
 * Checks frequency of the given element with O(1) lookup time.
 * 
 * Time complexity: O(n)
 * 
 * @author Sondre Bolland
 *
 */
public class TriplicateHash<T> implements ITriplicate<T> {

	@Override
	public T findTriplicate(List<T> list) {
		Map<T, Integer> frequencies = new HashMap<>();
		for (T e: list) {
			if (frequencies.containsKey(e)) {
				int frequency = frequencies.get(e);
				if (frequency == 1)
					frequencies.put(e, 2);
				else
					return e;
			}
			else {
				frequencies.put(e, 1);
			}
		}
		return null;
	}

}
