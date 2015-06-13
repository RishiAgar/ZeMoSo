import java.util.*;

public class p179 {
	public static void main(String[] args) {
		int max = 10000000, count = 0, lastNumberOfDivisor = 0;
		prime obj = new prime(max);
		obj.prime_func();
		int[][] arr = new int[max][2];
		for( int i=0; i<max; i++) {
			arr[i][0] = 0;
			arr[i][1] = 0;
		}
		System.out.println("1 > ---------------------------------");
		for ( int i=2; i<max; i++) {

			if( i != 2 && i % 2 == 0) {
				int a = arr[i/2][0] / (arr[i/2][1] + 1);
				arr[i][1] = arr[i/2][1] + 1;
				arr[i][0] = a * (arr[i][1] + 1);
				continue;
			}
			System.out.println(i);
			List<Integer> list = new LinkedList<>();
			for( int j=0; j<obj.k; j++) {
				if( obj.prime[j] > max/2) {
					break;
				}
				if( i % obj.prime[j] == 0) {
					list.add(obj.prime[j]);
				}
			}
			int numberOfDivisor = 1;
			int powerOf2 = 0;
			for( int divisor : list) {
				int power = getPower(i, divisor);
				numberOfDivisor *= ( power + 1);
				if( divisor == 2) {
					powerOf2 = power;
				}
			}
			// System.out.println( i + " " + numberOfDivisor);
			arr[i][0] = numberOfDivisor;
			arr[i][1] = powerOf2;
			// if( numberOfDivisor == lastNumberOfDivisor) {
			// 	// System.out.println( i-1 + " " + i);
			// 	count++;
			// } else {
			// 	System.out.println(i);
			// 	lastNumberOfDivisor = numberOfDivisor;
			// }
		}
		System.out.println("2 > ---------------------------------");
		for ( int i=2; i<max; i++) {
			if( arr[i][0] == arr[i-1][0]) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static int getPower( int num, int prime) {

		int count = 0;
		while(num % prime == 0) {
			count++;
			num /= prime;
		}
		return count;
	}
}