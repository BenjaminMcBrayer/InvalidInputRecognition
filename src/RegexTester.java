import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userName;
//		String userEmail;
//		String userPhoneNumber;
//		String userDate;

		userName = Validator.getString(scnr, "Please enter a valid name: ");
		
	}
	
	public static boolean validateName(String userName) {
		Pattern p = Pattern.compile("^[a-zA-Z]{1,30}+$");
		Matcher m = p.matcher(userName);
		if (m.matches()) {
			System.out.println("Name is valid.");
			return true;
		} else {
			System.out.println("Sorry, name is not valid.");
		}
		return false;
	}

}
