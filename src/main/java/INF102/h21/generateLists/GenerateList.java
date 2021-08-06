package INF102.h21.generateLists;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateList {
	
	private static Random rand = new Random();
	
	public static void writeIntegerListToFile(String[] args) {
		int nElements = 1000;
		int lowerbound = -10000;
		int upperbound = 100000;
		
		List<Integer> integerList = generateListOfIntegers(nElements, lowerbound, upperbound);
		writeToFile("integerList.txt", integerList);
	}
	
	public static List<Integer> generateListOfIntegers(int nElements, int lowerbound, int upperbound) {
		List<Integer> integerList = new ArrayList<>(nElements);
		for (int i = 0; i < nElements; i++) {
			int number = rand.nextInt(upperbound-lowerbound) + lowerbound;
			integerList.add(number);
		}
		return integerList;
	}
	
	public static void writeToFile(String filename, List<Integer> list) {
		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			for (Integer num: list) {
				writer.print(num);
				writer.print(",");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
