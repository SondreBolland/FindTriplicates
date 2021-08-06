package INF102.h21.contains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsThreeFrequency<T> implements IContainsThree<T> {

	@Override
	public boolean containsThree(List<T> list, T element) {
		Map<T, Integer> frequencies = new HashMap<>();
		for (T e: list) {
			if (frequencies.containsKey(e))
				frequencies.put(e, frequencies.get(e)+1);
			else
				frequencies.put(e, 1);
		}
		for (T key: frequencies.keySet()) {
			if (frequencies.get(key) >= 3)
				return true;
		}
		return false;
	}

}
