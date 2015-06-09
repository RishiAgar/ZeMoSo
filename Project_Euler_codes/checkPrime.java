public class checkPrime {
	public static void main(String[] args) {
		
		int num = Integer.parseInt(args[0]);
		System.out.println(isPrime(num));
	}

	public static boolean isPrime(int n) {
 	   return !new String(new char[n]).matches(".?|(..+?)\\1+");
	}
}