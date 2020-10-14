import java.text.NumberFormat;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Fibonacci Sequence");
        int i = 0;
        int prev = 0;
        int cur = 1;
        int next = 1;

        System.out.print("Enter an integer for the number of rounds through the fibonacci sequence to calculate\nInt: ");
        int number = scanner.nextInt();

        String finalFib = "";

        while ( i < number ) {

            String fib = new Integer(prev).toString();
            String msg = fib;

            if (i != number-1) {
                msg += ", ";
            } else {
                finalFib = fib;
            }

            System.out.print(msg);

            next = prev + cur;
            prev = cur;
            cur = next;

            i++;
        }

        System.out.println("\n\nThe " + number + " Number In The Fibonacci Sequence Is " + finalFib);

    }
}