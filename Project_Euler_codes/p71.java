public class p71 {
	public static void main(String[] args) {
		boolean flag;
		int k, max = 1000001;
		int arr[] = new int[max];
		prime obj = new prime(max);
		obj.prime_func();
		for( int i=0; i<max; i++) {
			arr[i] = 1;
		}
		for( int i = 2; i<max; i++) {
			for( int j = 2; j<=(i*3)/7 ; j++) {
				k = 0;
				flag = false;
				while(true) {
					if( obj.prime[k] > j) {
						break;
					}
					if( i % obj.prime[k] == 0 && i % obj.prime[k] == 0) {
						flag = true;
						break;
					}
					k++;
				}
				if(flag) {
					arr[i]++;
				}
			}
			System.out.println( i + " " + arr[i]);
		}
	}
}