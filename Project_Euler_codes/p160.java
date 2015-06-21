public class p160 {
	public static void main(String[] args) {
		long pro = 1, max = 1000000000000l;

		for( long i=2; i<max; i++) {
			pro *= reduce(i);
			pro = reduce(pro);
			System.out.println(i + " " + pro);
		}
		System.out.println(pro);
	}

	public static long reduce(long num) {

		long a = num % 10;
		while( a == 0) {
			num /= 10;
			a = num % 10;
		}
		return num % 100000;
	}
}