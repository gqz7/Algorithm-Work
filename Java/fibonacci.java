public class Main
{
	public static void main(String[] args) {
		System.out.println("This is the Fibonacci Sequence");
		int i = 0;
		int prev = 0;
		int cur = 1;
		int next = 1;
		while ( i < 10 ) {
		    
		    String fib = new Integer(prev).toString();
		    String msg = "FibNum: " + fib;
		    
		    System.out.println(msg);
		    
		    next = prev + cur;
		    prev = cur;
		    cur = next;
		    
		    i++;
		}
	}
}