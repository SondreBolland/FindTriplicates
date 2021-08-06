# Find Triplete Duplicates
Given a list of elements and a specific element checks if it occurs (at least) three times in the list.

Code includes four different algorithms for doing this:
* **ContainsThreeSimple**
  * Simple solution: Triple for-loop (brute force)
  * Time Complexity: O(n<sup>3</sup>)
* **ContainsThreeSorting**
  * Sorts the list of elements. Searches through the list until it finds the element and checks if the two next elements are equal.
  * Time Complexity: O(n<sup>2</sup>log(n))
* **ContainsThreeFrequency**
  * Saves the frequencies of all numbers. Proceeds to search through frequency list for the given element and checks if the frequency is three (or higher).
  * Time Complexity: O(n<sup>2</sup>)
* **ContainsThreeHash**
  * Records the frequencies of all numbers in HashMap. Checks frequency of the given element with O(1) lookup time.
  * Time Complexity: O(n)
  
Generates ``n`` lists of random numbers, finds the duplicate triplets in the lists, and has each algorithm validate for each list.
Records the time elapsed for each algorithm. Prints out the time each algorithm spent on this task to illustrate runtime imperically. 
