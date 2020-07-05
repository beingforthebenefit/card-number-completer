import javax.swing.*;

public class CardNumberCompleter {
	
	public static int[] numStringToArray(String string) {
		int[] numArray = new int[string.length()];
		for (int i = 0; i < string.length(); i++) {
			numArray[i] = Integer.parseInt(string.substring(i, i + 1));
		}
		return numArray;
	}
	
	public static int sumDigits(int num) {
		return (num > 9) ? num - 9 : num;
	}
	
	public static int checksum(String code) {
		int[] numArray = numStringToArray(code.substring(0, code.length() - 1));
		int sum = 0;
		for (int i = 0; i < code.length() - 1; i++) {
			sum += (i % 2 == 0) ? sumDigits(2 * numArray[i]) : numArray[i];
		}
		return 10 - (sum % 10);
	}
	
	public static int lastDigit(String code) {
		return Integer.parseInt(code.substring(code.length() - 1));
	}
	
	public static int missingNumber(String code) {
		String newCode = code.replace('*', '0');
		int badChecksum = checksum(newCode);
		int weightedNumber = Math.abs(badChecksum - lastDigit(code));
		if (code.indexOf('*') % 2 == 0) {
			return (weightedNumber % 2 == 0 ? weightedNumber : weightedNumber + 9) / 2;
		}
		return weightedNumber;
	}
	
	public static void main(String[] args) {
		// Example credit card input with missing digit
		String code = "51780581368*2211";
		// If the number is missing the last digit (checksum)
		if (code.charAt(code.length() - 1) == '*') {
			System.out.println(checksum(code));
		} else { // If an intermediate digit is missing
			System.out.println(missingNumber(code));
		}
	}
}
