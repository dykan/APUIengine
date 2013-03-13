package examples;

public class GeneralUtils {

	public static boolean checkExpression(int num1, int num2, String sign) {
		boolean result = false;
		
		switch (sign) {
			case ">":
				result = (num1 > num2);
			case "<":
				result = (num1 < num2);
			case "=":
				result = (num1 == num2);
			case ">=":
				result = (num1 >= num2);
			case "<=":
				result = (num1 <= num2);
		}
		return result;		
	}
}
