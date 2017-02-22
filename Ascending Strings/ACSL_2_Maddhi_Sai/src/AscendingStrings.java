import java.util.ArrayList;

public class AscendingStrings {
	private String digits;
	private ArrayList<Integer> sequence;
	private int index;
	
	public AscendingStrings() {
		this.digits = "";
		this.sequence = new ArrayList<Integer>(1);
		this.index = 0;
	}
	
	public boolean initialize(String str) {
		this.digits = str;
		this.sequence = new ArrayList<Integer>(1);
		this.index = 0;
		return str.length() == 0;
	}
	
	public void generateSequence() {
		int lastNum = Integer.parseInt(""+digits.charAt(0));
		boolean fromLeft = false;
		digits = digits.substring(1);
		int index = digits.length()-1;
		sequence.add(lastNum);
		while(true) {
			int currentNum = -1;
			//Go in this direction and get a number greater than last num
			while(!(currentNum > lastNum ||
					((!fromLeft && index < 0) || (fromLeft && index >= digits.length())))) {
				//Check currentNum
				if(currentNum == -1) currentNum++;
				//Add the number at the next index
				currentNum = Integer.parseInt("" + currentNum + digits.charAt(index));
				//Increment index
				index = (fromLeft) ? index+1 : index-1;
			}
			if(currentNum <= lastNum) {
				break;
			} else {
				lastNum = currentNum;
				sequence.add(currentNum);
				if(fromLeft) {
					digits = digits.substring(index);
					index = digits.length()-1;
					fromLeft = !fromLeft;
				} else {
					digits = digits.substring(0, index+1);
					index = 0;
					fromLeft = !fromLeft;
				}
			}
		}
	}
	
	public void printSequence() {
		String output = "";
		for(Integer i : sequence) {
			output += i + " ";
		}
		System.out.println("Output: " + output.trim());
	}
}
