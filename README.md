# Find Triplet Duplicates
Given a list of elements find an element that occurs (at least) three times.

Code includes four different algorithms for doing this:
* **ContainsThreeSimple**
  * Simple solution: Triple for-loop (brute force)
  * Time Complexity: O(n<sup>3</sup>)
* **ContainsThreeFrequency**
  * For each element in list iterate through the rest of the list and record the frequency of this element. If it occurs >= 3 return true.
  * Time Complexity: O(n<sup>2</sup>)
* **ContainsThreeSorting**
  * Sorts the list of elements. Searches through the list and checks if it is equals to the next two elements in the list.
  * Time Complexity: O(nlog(n))
* **ContainsThreeHash**
  * Records the frequencies of all numbers in HashMap. Checks frequency of the given element with O(1) lookup time.
  * Time Complexity: O(n)
  
# Output
```
---Generating Integer Lists---
10 lists generated with 10 000 elements each.

---Processing Algorithms---
ContainsThreeHash          | time elapsed:     123923 microseconds (0,123923 seconds)
ContainsThreeSorting       | time elapsed:     119666 microseconds (0,119666 seconds)
ContainsThreeFrequency     | time elapsed:    1219880 microseconds (1,219880 seconds)
ContainsThreeSimple        | time elapsed: 2826194217 microseconds (2826,194217 seconds)
```
