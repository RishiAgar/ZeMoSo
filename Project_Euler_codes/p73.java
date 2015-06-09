public class p73 {
	public static void main(String[] args) {
		int max = 12000 + 1, count = 0;
		for ( int i = 2; i<max; i++) {
			int upper = (int)Math.ceil((float)i/2);
			int lower = (int)Math.floor((float)i/3) + 1;
			for( int j = lower; j<upper; j++) {
				if( isCoPrime(i, j)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static boolean isCoPrime(int a, int b) {
	    while (b != 0) {
	        int c = a % b;
	        a = b;
	        b = c;
	    }
	    return a == 1;
	}
}