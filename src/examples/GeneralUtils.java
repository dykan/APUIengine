package examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	
	public static String convertFileToString(String fileName) {
		
		String everything = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        everything = sb.toString();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		return everything;
	}
}
