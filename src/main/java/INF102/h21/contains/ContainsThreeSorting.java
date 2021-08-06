package INF102.h21.contains;

import java.util.Collections;
import java.util.List;

public class ContainsThreeSorting<T extends Comparable<T>> implements IContainsThree<T> {

	@Override
	public boolean containsThree(List<T> list, T element) {
		Collections.sort(list);
		for (int i = 0; i < list.size()-2; i++) {
			T one = list.get(i);
			T two = list.get(i+1);
			T three = list.get(i+2);
			if (one.equals(element) && two.equals(element) && three.equals(element))
				return true;
		}
		return false;
	}

}
