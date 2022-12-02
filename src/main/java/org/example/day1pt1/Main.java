package org.example.day1pt1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	public static void main(String[] args){
		HashMap<Integer, Integer> elfWithCalories = new HashMap<>();

		try {
			File file = new File("src/main/java/org/example/day1pt1/elfs.txt");
			Scanner myReader = new Scanner(file);
			int calories = 0;
			int elf = 1;

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if(data == ""){
					elfWithCalories.put(elf,calories);
					elf++;
					calories = 0;
				}
				else{
					calories += Integer.parseInt(data);
				}
			}
			myReader.close();
			int mostCalories = Collections.max(elfWithCalories.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
			System.out.println(mostCalories);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}