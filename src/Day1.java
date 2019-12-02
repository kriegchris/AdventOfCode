import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day1 {
	public static void main(String[] args) {
		System.out.println("Day 1 part 1 solution: " + proccessDataPart1());
		System.out.println(processDataPart2());

	}

	public static Integer processDataPart2() {
		String fileName = "Day1Input.txt";
		Path path = Paths.get("resources", fileName);
		File file = path.toFile();
		int total = 0;
		int result = 0;
		int moduleTotal = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				result = runCalculation(Integer.parseInt(line));
				total += result;
				moduleTotal += result;
				System.out.print(result + " ");
				while (result > 0) {
					result = runCalculation(result);
					if (result > 0) {
						total += result;
						moduleTotal += result;
						System.out.print(result + " ");
					}
				}
				System.out.println(" = " + moduleTotal);
				moduleTotal = 0;
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong with the file.");
		} catch (IOException e) {
			System.out.println("Something went wrong when we tried to read from the file.");
		}
		System.out.print("Day 1 part 2 solution: ");
		return total;
	}

	public static int proccessDataPart1() {
		String fileName = "Day1Input.txt";
		Path path = Paths.get("resources", fileName);
		File file = path.toFile();
		int total = 0;
		int result = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				result = runCalculation(Integer.parseInt(line));
				total += result;
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong with the file.");
		} catch (IOException e) {
			System.out.println("Something went wrong when we tried to read from the file.");
		}
		return total;
	}

	public static int runCalculation(int num) {
		return Math.floorDiv(num, 3) - 2;
	}

}