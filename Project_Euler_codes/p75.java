public class p75 {
	public static void main(String[] args) {
		int max = 1500000;
		long maxSide = max /2;
		long a[] = new long[max+1];
		for( int i=0; i<max+1; i++) {
			a[i] = 0L;
		}
		for( int i=1; i<maxSide; i++ ) {
			for( int j=1; j<i; j++) {
				long c = isPerfectSquare((long)i*i + (long)j*j);
				long perimeter = (long)i + j + c;
				if( c != -1 && perimeter <= max) {
					System.out.println(i + " " + j + " " + c + " " + perimeter);
					a[(int)perimeter]++;	
				}
			}
		}
		int count = 0;
		for( int i=0; i<max; i++) {
			if( a[i] == 1) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static long isPerfectSquare(long number) {
		double sqrtNum = Math.sqrt(number);
		if(Math.round(sqrtNum)==sqrtNum) {
			return (long)sqrtNum;
		}
		return -1L;
	}
}