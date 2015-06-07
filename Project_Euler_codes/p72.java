public class p72 {
	public static void main(String[] args) {
		int k, max = 1000001;
		int[] arr = new int[max];
		prime obj = new prime(max);
		for( int i=0; i<max; i++) {
			arr[i] = i;
		}
		obj.prime_func();
		arr[0] = 1;
		arr[1] = 1;
		long sum = 0;
		for( int i = 2; i<max; i++) {
			k = 0;
			while(true) {
				if( i % obj.prime[k] == 0) {
					arr[i] = (arr[i] - (int)(arr[i]/(float)obj.prime[k]));
					
				}
				k++;
				if( obj.prime[k] > i || obj.prime[k] == 0) {
					break;
				}
			}
			sum += arr[i];
			System.out.println( i + " " + arr[i]);
		}
		System.out.println(sum);
	}
}