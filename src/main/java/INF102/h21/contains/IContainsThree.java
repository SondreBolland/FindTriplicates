package INF102.h21.contains;

import java.util.List;

public interface IContainsThree<T> {

	/**
	 * Checks if <code>list</list> contains (at least) three
	 *  of <code>element</code>
	 * @param element
	 * @return true if list contains (at least) three of the given element, false if not
	 */
	public T containsThree(List<T> list);
}
