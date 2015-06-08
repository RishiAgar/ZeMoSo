public class p71 {
	public static void main(String[] args) {
		boolean flag;
		int k, num = 0, max = 1000001;
		int arr[] = new int[max];
		prime obj = new prime(max);
		obj.prime_func();
		double max_limit = (double)3/(double)7;
		double ans_max = 0;
		for( int i = max-1; i>=0; i--) {
			for( int j = i/2; j>=1; j-- ) {
				double value = (double)j/i;
				if( value < ans_max) {
					break;
				}
				if(( i % 2 == 0 && j % 2 == 0) || (i % 3 == 0 && j % 3 == 0)) {
					continue;
				}
				flag = checkGCD(i, j);
				if(flag) {
					if( value < max_limit) {
						if( value > ans_max) {
							ans_max = value;
							num = j;
							System.out.println( i + " " + num);
						}
						break;
					}
				}
			}
		}
		System.out.println(num);
	}

	public static boolean checkGCD( int a, int b) {
		while (b != 0) {
	        int c = a % b;
	        a = b;
	        b = c;
	    }
	    return a == 1;
	}
}