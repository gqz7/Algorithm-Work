import java.text.*;
public class Main
{
	public static void main(String[] args) {
		
		String testString = "This is a test string!";
		
		String reversedString = "";
		   
		int strLen = testString.length()-1;
		
		for (int i = strLen; i >= 0 ; i--) {
		  //  System.out.println(testString.charAt(i));
		    reversedString += testString.charAt(i);
		}
		
		String finalMsg = MessageFormat.format("\nYour Original String:\n{0}\n\nYour String Reversed:\n{1}", testString, reversedString);
		
		System.out.println(finalMsg);
	}
}