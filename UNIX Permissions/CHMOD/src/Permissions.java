/**
 * 
 * This class takes the four numbers from NumberInput class and displays their values and their permissions
 * @author Sai Maddhi
 *
 */
public class Permissions {
	/**
	 * This is the String array of binary numbers; NOT including the special permission number
	 */
	private String[] numbers = new String[3];
	/**
	 * This is the String array that holds the permissions
	 */
	private String[] permissions = new String[3];
	/**
	 * This is the permission Number; 1 = owner; 2 = group; 3 = others(4 is changed to three in the constructor)
	 */
	private int permissionType;
	/**
	 * This is the constructor for the Permissions class; This constructor analyzes the numbers and prints out the output
	 * @param nums this is the parameter that holds the array of numbers
	 */
	public Permissions(String[] nums) {
		getPermissionType(Integer.parseInt(nums[0]));
		initNumbers(nums);
		getPermissions();
		displayPermissions();
	}
	/**
	 * This method gets the permission type;  1 = owner; 2 = group; 3 = others(4 is changed to three in this method)
	 * @param num
	 */
	public void getPermissionType(int num) {
		switch(num) {
		case 0:
			permissionType = 0;
			break;
		case 1:
			permissionType = 1;
			break;
		case 10:
			permissionType = 2;
			break;
		case 100:
			permissionType = 3;
			break;
		}
	}
	/**
	 * This method initializes the numbers array; NOT including the special permission number
	 * @param nums this parameter is the input from the NumberInput class; the user inputed array
	 */
	public void initNumbers(String[] nums) {
		for(int i = 1; i < nums.length; i++) {
			numbers[i-1] = nums[i];
		}
	}
	/**
	 * This is the class that initializes the permissions array and gets all the permissions for each class
	 */
	public void getPermissions() {
		int countPermissionGroup = 1;
		int permissionsCounter = 0;
		for(String num: numbers) {
			String permission = "";
			for(int i = 0; i < 3; i++) {
				if(num.charAt(i) == '1') {
					switch(i) {
					case 0:
						permission += 'r';
						break;
					case 1: 
						permission += 'w';
						break;
					default:
						if(countPermissionGroup == permissionType) {
							if(permissionType == 3) permission += 't';
							else permission += 's';
						} else permission += 'x';
						break;
					}
				} else {
					permission+="-";
				}
			}
			permissions[permissionsCounter] = permission;
			permissionsCounter++;
			countPermissionGroup++;
		}
	}
	/**
	 * This method outputs the binary representation and the specific permissions as well
	 */
	public void displayPermissions() {
		String displayStr = "";
		for(String s: numbers) {
			displayStr += s + " ";
		}
		displayStr += "and ";
		for(String s: permissions) {
			displayStr += s + " ";
		}
		displayStr = displayStr.trim();
		System.out.println(displayStr);
	}
	
}
