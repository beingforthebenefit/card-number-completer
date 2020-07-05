
public class Validate {
	public static boolean checkLength(String code) {
		return code.length() != 16;
	}
	
	public static boolean checkStar(String code) {
		return (
			code.indexOf('*') != -1 &&
			code.indexOf('*') == code.lastIndexOf('*')
		);
	}
}
