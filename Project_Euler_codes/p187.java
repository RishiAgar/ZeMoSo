public class p187 {
	public static void main(String[] args) {
		int k = 0, max = 100000000;
		prime obj = new prime(max);
		obj.prime_func();
		long count = 0;
		int[] arr = new int[max];
		int max_prime;
		for( int i=0; i<max; i++ ) {
			if(  i == obj.prime[k]) {
				k++;
			}
			arr[i] = k;
		}
		for( int i=0; i<obj.k; i++ ) {
			int prime = obj.prime[i];
			max_prime = max / prime;
			if( arr[prime] < arr[max_prime]) {
				count += arr[prime];
			} else {
				count += arr[max_prime];
			}
		}
		System.out.println(count);
	}
}