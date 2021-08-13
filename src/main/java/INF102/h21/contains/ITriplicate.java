package INF102.h21.contains;

import java.util.List;

public interface ITriplicate<T> {

	/**
	 * Checks if <code>list</list> contains three of the same element
	 * @return If the list contains three of the same element then return this element
	 * null if not
	 */
	public T findTriplicate(List<T> list);
}
