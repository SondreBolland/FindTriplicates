# Find Triplete Duplicates
Given a list of elements and a specific element checks if it occurs (at least) three times in the list.

Code includes four different algorithms for doing this:
* **ContainsThreeSimple**
  * Simple solution: Triple for-loop (brute force)
  * Time Complexity: O(n<sup>3</sup>)
* **ContainsThreeFrequency**
  * For each element in list iterate through the rest of the list and record the frequency of this element. If it occurs >= 3 return true.
  * Time Complexity: O(n<sup>2</sup>)
* **ContainsThreeSorting**
  * Sorts the list of elements. Searches through the list until it finds the element and checks if the two next elements are equal.
  * Time Complexity: O(nlog(n))
* **ContainsThreeHash**
  * Records the frequencies of all numbers in HashMap. Checks frequency of the given element with O(1) lookup time.
  * Time Complexity: O(n)
  
Generates ``n`` lists of random numbers, finds the duplicate triplets in the lists, and has each algorithm validate for each list.
Records the time elapsed for each algorithm. Prints out the time each algorithm spent on this task to illustrate runtime imperically. 
