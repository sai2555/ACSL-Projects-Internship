import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class takes in the input five times repeatedly and displays the initializes Permissions Class Instances
 * @author Sai Maddhi
 *
 */
public class NumberInput {
	/**
	 * This String Array holds the numbers that the user enters; in BINARY
	 */
	private String[] numbers = new String[4];
	
	/**
	 * This is the default constructor that will take input from the user and initialize the numbers array
	 */
	public NumberInput() {
		Scanner input = new Scanner(System.in);
		for(int i = 1; i <= 5; i++) {
			System.out.println("Enter your numbers");
			String nums = input.nextLine();
			initNumbers(nums);
			Permissions permission = new Permissions(numbers);
		}
	}
	
	/**
	 * This method initializes Numbers with the numbers that the user has entered
	 * @param inputNums
	 */
	public void initNumbers(String inputNums) {
		String[] numbersInput = inputNums.split(", ");
		int counter = 0;
		for(String num: numbersInput) {
			numbers[counter] = convertToBase(Integer.parseInt(num));
			counter++;
		}
	}
	
	/**
	 * This method converts the octal parameter to the binary equivalent and returns it
	 * @param number this is the octal representation of the number
	 * @return this is the binary representation of the octal number
	 */
	public String convertToBase(int number) {
		ArrayList<Integer> binNum = new ArrayList<Integer>(3);
		int num = number;
		int count = 0;
		while(count < 3) {
			binNum.add(0, new Integer(num%2));
			num/=2;
			count++;
		}
		String numberInBinary = "";
		for(Integer b: binNum) {
			numberInBinary += b;
		}
		return numberInBinary;
	}
}
