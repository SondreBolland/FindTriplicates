package INF102.h21.contains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsThreeHash<T> implements IContainsThree<T> {

	@Override
	public boolean containsThree(List<T> list, T element) {
		Map<T, Integer> frequencies = new HashMap<>();
		for (T e: list) {
			if (frequencies.containsKey(e)) {
				int frequency = frequencies.get(e);
				if (frequency == 1)
					frequencies.put(e, 2);
				else
					return true;
			}
			else {
				frequencies.put(e, 1);
			}
		}
		return false;
	}

}
