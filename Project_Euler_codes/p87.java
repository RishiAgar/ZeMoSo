import java.util.*;
public class p87 {
	public static void main(String[] args) {
		int count = 0, max = 50000000;
		prime obj = new prime(max);
		obj.prime_func();
		List<Long> power2 = new LinkedList<>();
		List<Long> power3 = new LinkedList<>();
		List<Long> power4 = new LinkedList<>();
		byte[] arr = new byte[max];
		for( int i=0; i<max; i++) {
			arr[i] = 0;
		}
		for( int prime : obj.prime) {
			long square = prime * prime;
			if( square > max) {
				break;
			}
			power2.add(square);
			if( square * prime < max) {
				power3.add(square * prime);
			}
			if( square * square < max) {
				power4.add(square * square);
			}
		}
		for( long i : power2) {
			for( long j : power3) {
				for( long k : power4) {
					long sum = i + j + k;
					if( sum > 0 && sum < max) {
						arr[(int)sum] = 1;
					}
				}
			}
		}
		for( int i=0; i<max; i++) {
			if( arr[i] == 1) {
				count++;
			}
		}
		System.out.println(count);
	}
}