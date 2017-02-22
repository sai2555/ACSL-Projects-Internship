import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AscendingStrings aStrings = new AscendingStrings();
		System.out.println("Welcome to Ascending Strings\n");
		for(int i = 1; i <= 5; i++) {
			System.out.println("Enter your input...");
			String input = scanner.nextLine();
			boolean isEmpty = aStrings.initialize(input);
			if(isEmpty) continue; 
			aStrings.generateSequence();
			aStrings.printSequence();
			System.out.println("");
		}
	}
}
