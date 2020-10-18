import java.util.Scanner;

public class Main {
    /*
      User enters number and gets the factorial of it
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the string repeater CLI!\nYou will first enter a string, then the number of times you want the string to repeat\nThen the repeated string will output\n\n");
        System.out.print("Enter an string to be repeated\nString: ");

        try {
            String orgStr = scanner.nextLine();
            String repeatedStr = "";
            System.out.print("Enter how many times you want the string to be repeated\nInt: ");
            int repeatTimes = scanner.nextInt();
            for ( int i = 0; i < repeatTimes; i++) {
                repeatedStr += orgStr;
            }
            System.out.println("\nYour Repeated String Is: \n\n" + repeatedStr);
        } catch (Exception e) {
            System.out.println("You must enter a String for your sentence and a Int for your number of repeats");
        }

    }
}