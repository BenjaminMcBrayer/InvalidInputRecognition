import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvalidInputRecognition {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userName;
		String userEmail;
		String userPhoneNumber;
		String userDate;

		userName = Validator.getString(scnr, "Please enter a valid name: ");
		validateName(userName);

		userEmail = Validator.getString(scnr, "Please enter a valid email: ");
		validateEmail(userEmail);

		System.out.println("Please enter a valid phone number (###-###-####): ");
		userPhoneNumber = scnr.nextLine();
		validatePhoneNumber(userPhoneNumber);

		System.out.println("Please enter a valid date (dd/mm/yyyy): ");
		userDate = scnr.nextLine();
		validateDate(userDate);

		scnr.close();
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

	public static boolean validateEmail(String userEmail) {
		Pattern p = Pattern.compile("([a-zA-Z0-9\\.]){5,30}@([a-zA-Z0-9]){5,10}\\.([a-zA-Z0-9]){2,3}");
		Matcher m = p.matcher(userEmail);
		if (m.matches()) {
			System.out.println("Email is valid.");
			return true;
		} else {
			System.out.println("Sorry, email is not valid.");
		}
		return false;
	}

	public static boolean validatePhoneNumber(String userPhoneNumber) {
		//Pattern p = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");
		Pattern p = Pattern.compile("([2-9][0-8][0-9])\\W*([2-9][0-9]{2})\\W*([0-9]{4})(\\se?x?t?(\\d*))?");
		Matcher m = p.matcher(userPhoneNumber);
		if (m.matches()) {
			System.out.println("Phone number is valid.");
			return true;
		} else {
			System.out.println("Sorry, phone number is not valid.");
		}
		return false;
	}

	public static boolean validateDate(String userDate) {
		Pattern p = Pattern.compile("[0-1][0-9]/[0-3][0-9]/[0-9]{2}(?:[0-9]{2})?");
		// This does not prevent the user
		// from entering, for example,
		// 12/32/1980 and receiving the
		// message "Date is valid." Rather
		// than regex, something like
		// "LocalDate.parse(firstUserInput,
		// DateTimeFormatter.BASIC_ISO_DATE);"
		// might be better.
		Matcher m = p.matcher(userDate);
		if (m.matches()) {
			System.out.println("Date is valid.");
			return true;
		} else {
			System.out.println("Sorry, date is not valid.");
		}
		return false;
	}
}
