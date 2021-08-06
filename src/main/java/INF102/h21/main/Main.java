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

/**
 * Records the time of different algorithms for determining if a list contains
 * (at least) three of a given element.
 * 
 * @author Sondre Bolland
 *
 */
public class Main {
	
	/**
	 * Number of integers in generated list
	 */
	public static final int N_INTEGERS = 200;
	/**
	 * Lower bound of integers in generated list
	 */
	public static final int LOWERBOUND = 0;
	/**
	 * Upper bound of integers in generated list
	 */
	public static final int UPPERBOUND = 150;

	public static void main(String[] args) {
		// Different implementations of containsThree method
		List<IContainsThree<Integer>> algorithmList = Arrays.asList(new ContainsThreeSimple<Integer>(),
				new ContainsThreeFrequency<Integer>(), new ContainsThreeSorting<Integer>(),
				new ContainsThreeHash<Integer>());

		// Run containsThree of each algorithm for the known triplets and record time
		// elapsed
		System.out.println("---Processing Algorithms---");
		for (IContainsThree<Integer> algorithm : algorithmList) {
			long timeElapsedMicro = timeAlgorithm(algorithm) / 1000;
			double timeElapsedSeconds = (timeElapsedMicro / 1000000.0);
			String algorithmName = algorithm.getClass().getSimpleName();
			System.out.printf("%-25s| time elapsed: %10d microseconds (%f seconds)%n", algorithmName, timeElapsedMicro, timeElapsedSeconds);
		}
	}

	/**
	 * <code>algorithm</code> validates all tripple occurence integers in a
	 * generated list, <code>nIntegers</code> times. Records the time spent
	 * validating.
	 * 
	 * @param algorithm ContainsThree algorithm
	 * @return long of microseconds spent validating
	 */
	public static long timeAlgorithm(IContainsThree<Integer> algorithm) {
		// Generate n lists of integers. Find all triplets and validate them with
		// the selected algorithm. Time this process.
		long startTime = System.nanoTime();
		int nIterations = 1000;
		for (int i = 0; i < nIterations; i++) {
			List<Integer> integerList = generateListOfIntegers(N_INTEGERS, LOWERBOUND, UPPERBOUND);
			List<Integer> knownThrees = getTripletOccurrences(integerList);
			if (!validateTriplets(integerList, knownThrees, algorithm))
				throw new IllegalStateException("This is a known element that occurs three times in the list");
		}
		long endTime = System.nanoTime();
		long timeElapsed = (endTime - startTime) / nIterations;
		return timeElapsed;
	}

	/**
	 * Check all known integers which occur (at least) three times in
	 * <code>integerList</code> with <code>algorithm</code>
	 * 
	 * @param integerList full list of integers
	 * @param knownThrees all known triplets in <code>integerList</code>
	 * @param algorithm   ContainsThree algorithm to validate triplets
	 * @return true if algorithm validated all know triplets, else false
	 */
	public static boolean validateTriplets(List<Integer> integerList, List<Integer> knownThrees,
			IContainsThree<Integer> algorithm) {
		for (Integer knownThree : knownThrees) {
			if (!algorithm.containsThree(integerList, knownThree))
				return false;
		}
		return true;
	}

	/**
	 * Generate a list of <code>n</code> random integers between
	 * <code>lowerbound</code> and <code>upperbound</code>
	 * 
	 * @param n          integers to be generated
	 * @param lowerbound of integers generated
	 * @param upperbound of integers generated
	 * @return list of integers generated
	 */
	public static List<Integer> generateListOfIntegers(int n, int lowerbound, int upperbound) {
		Random rand = new Random();
		List<Integer> integerList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			int number = rand.nextInt(upperbound - lowerbound) + lowerbound;
			integerList.add(number);
		}
		return integerList;
	}

	/**
	 * Find all elements in list that occur (at least) three times
	 * 
	 * @param list
	 * @return list of integers occurring three times in the input list
	 */
	public static List<Integer> getTripletOccurrences(List<Integer> list) {
		List<Integer> threes = new ArrayList<>();
		Map<Integer, Integer> frequencies = new HashMap<>();
		for (Integer e : list) {
			if (frequencies.containsKey(e))
				frequencies.put(e, frequencies.get(e) + 1);
			else
				frequencies.put(e, 1);
		}
		for (Integer e : list) {
			if (frequencies.get(e) >= 3) {
				threes.add(e);
			}
		}
		return threes;
	}
}
