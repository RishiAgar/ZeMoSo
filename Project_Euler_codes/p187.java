public class p187 {
	public static void main(String[] args) {
		int k = 0, max = 30;
		prime obj = new prime(max);
		obj.prime_func();
		long count = 0;
		int[] arr = new int[max];
		System.out.println(obj.k);
		for( int i=0; i<max; i++ ) {
			if(  i == obj.prime[k]) {
				k++;
			}
			arr[i] = k;
			System.out.println( i + " " + arr[i]);
		}
		for( int i=0; i<obj.k; i++ ) {
			int max_prime = max / obj.prime[i];
			if( max_prime < arr[max_prime]) {
				count += (i+1);
			} else {
				count += arr[max_prime];
			}
			System.out.println( obj.prime[i] + " " + arr[max_prime]);
		}
		System.out.println(count);
	}
}