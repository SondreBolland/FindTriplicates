package INF102.h21.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import INF102.h21.contains.ContainsThreeFrequency;
import INF102.h21.contains.ContainsThreeHash;
import INF102.h21.contains.ContainsThreeSimple;
import INF102.h21.contains.ContainsThreeSorting;
import INF102.h21.contains.IContainsThree;

public class Main {

		public static void main(String[] args) {		
			// Different implementations of containsThree method
			List<IContainsThree<Integer>> algorithmList = Arrays.asList(new ContainsThreeSimple<Integer>(),
					new ContainsThreeFrequency<Integer>(), new ContainsThreeSorting<Integer>(),  new ContainsThreeHash<Integer>());
			
			// Run containsThree of each algorithm for the known triplets and record time elapsed
			System.out.println("---Processing Algorithms---");
			for (IContainsThree<Integer> algorithm: algorithmList) {
				long timeElapsed = timeAlgorithm(algorithm);
				String algorithmName = algorithm.getClass().getSimpleName();
				System.out.printf("%-25s| time elapsed: %10d microseconds%n", algorithmName, timeElapsed);
			}
		}//kake
		
		/**
		 * <code>algorithm</code> validates all tripple occurence integers
		 *  in a generated list, <code>nIntegers</code> times.
		 *  Records the time spent validating.
		 * @param algorithm ContainsThree algorithm
		 * @return long of microseconds spent validating
		 */
		public static long timeAlgorithm(IContainsThree<Integer> algorithm) {
			int nIntegers = 200;
			int lowerbound = 0;
			int upperbound = 150;
			
			// Generate n lists of integers. Find all triplets and validate them with
			// the selected algorithm. Time this process.
			long startTime = System.nanoTime();
			for (int i = 0; i < 1000; i++) {
				List<Integer> integerList = generateListOfIntegers(nIntegers, lowerbound, upperbound);
				List<Integer> knownThrees = getTripletOccurrences(integerList);
				if (!validateTriplets(integerList, knownThrees, algorithm))
					throw new IllegalStateException("This is a known element that occurs three times in the list");
			}
			long endTime = System.nanoTime();
			long timeElapsed = (endTime - startTime) / 1000;
			return timeElapsed;
		}
		
		/**
		 * Check all known integers which occur (at least) three times in <code>integerList</code>
		 * with <code>algorithm</code>
		 * @param integerList full list of integers
		 * @param knownThrees all known triplets in <code>integerList</code>
		 * @param algorithm ContainsThree algorithm to validate triplets
		 * @return true if algorithm validated all know triplets, else false
		 */
		public static boolean validateTriplets(List<Integer> integerList, List<Integer> knownThrees, IContainsThree<Integer> algorithm) {
			for (Integer knownThree: knownThrees) {
				if (!algorithm.containsThree(integerList, knownThree))
					return false;
			}
			return true;
		}
		
		/**
		 * Generate a list of <code>n</code> random integers between 
		 * <code>lowerbound</code> and <code>upperbound</code>
		 * @param n integers to be generated
		 * @param lowerbound of integers generated
		 * @param upperbound of integers generated
		 * @return list of integers generated
		 */
		public static List<Integer> generateListOfIntegers(int n, int lowerbound, int upperbound) {
			Random rand = new Random();
			List<Integer> integerList = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				int number = rand.nextInt(upperbound-lowerbound) + lowerbound;
				integerList.add(number);
			}
			return integerList;
		}
		
		/**
		 * Find all elements in list that occur (at least) three times
		 * @param list
		 * @return list of integers occurring three times in the input list
		 */
		public static List<Integer> getTripletOccurrences(List<Integer> list) {
			List<Integer> threes = new ArrayList<>();
			Map<Integer, Integer> frequencies = new HashMap<>();
			for (Integer e: list) {
				if (frequencies.containsKey(e))
					frequencies.put(e, frequencies.get(e)+1);
				else
					frequencies.put(e, 1);
			}
			for (Integer e: list) {
				if (frequencies.get(e) >= 3) {
					threes.add(e);
				}
			}
			return threes;
		}
}
