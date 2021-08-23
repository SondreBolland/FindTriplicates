# Find Triplicate
Given a list of elements find an element that occurs (at least) three times.

Code includes four different algorithms for doing this:
* **TriplicateBruteForce**
  * Simple solution: Triple for-loop (brute force)
  * Time Complexity: O(n<sup>3</sup>)
* **TriplicateFrequency**
  * Checks for triplicate of given element. Saves the frequencies of all numbers. Proceeds to search through frequency list for the given element and checks if the frequency is three (or higher).
  * Time Complexity: O(n<sup>2</sup>)
* **TriplicateSorting**
  * Sorts the list of elements. Searches through the list and checks if it is equals to the next two elements in the list.
  * Time Complexity: O(nlog(n))
* **TriplicateHash**
  * Records the frequencies of all numbers in HashMap. Checks frequency of the given element with O(1) lookup time.
  * Time Complexity: O(n)
  
# Output
```
---Generating Integer Lists---
10 lists generated with 10 000 elements each.

---Processing Algorithms---
TriplicateHash          | time elapsed:     123923 microseconds (0,123923 seconds)
TriplicateSorting       | time elapsed:     119666 microseconds (0,119666 seconds)
TriplicateFrequency     | time elapsed:    1219880 microseconds (1,219880 seconds)
TriplicateBruteForce    | time elapsed: 2826194217 microseconds (2826,194217 seconds)
```
