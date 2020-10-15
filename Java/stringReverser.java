import java.text.*;
public class Main
{
	public static void main(String[] args) {
		try {
			final Scanner scanner = new Scanner(System.in);

			String normalString = scanner.nextLine();
			
			String reversedString = "";
				
			int strLen = normalString.length()-1;
			
			for (int i = strLen; i >= 0 ; i--) {
				//  System.out.println(normalString.charAt(i));
					reversedString += normalString.charAt(i);
			}
			
			String finalMsg = MessageFormat.format("\nYour Original String:\n{0}\n\nYour String Reversed:\n{1}", normalString, reversedString);
			
			System.out.println(finalMsg);

		} catch (Exception e) {
				System.out.println("You must enter a String for this program");
		}
	}
}