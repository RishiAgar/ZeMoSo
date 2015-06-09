import java.util.*;
public class p387 {
	public static void main(String[] args) {
		boolean flag = false;
		int max = Integer.MAX_VALUE-10, count = 0;
		int a, sum;
		byte[] check = new byte[max];
		// Integer[] arr = new Integer[max];
		for( int i=0; i<10; i++) {
			check[i] = 1;
			// arr[i] = i;
		}
		prime obj = new prime(max);
		obj.prime_func();
		// List<Integer> list = new LinkedList<>();
		System.out.println("----------------------------------");
		for( int i=1; i<max/10; i++) {
			a = i/10;
			if(check[a] == 0) {
				// if( i == 2011) {
				// 	System.out.println( "continue" + i + " - " + arr[a][0] + " " + arr[a][1]);
				// }
				continue;
			}
			sum = getSum(i);
			// if( i==2011) {
			// 	System.out.println( i + " - " + sum + " " + i);
			// }
			if( i % sum == 0) {
				check[i] = 1;
				// arr[i] = sum;
				if( obj.a[i/sum] == 1) {
					// System.out.println(i);
					check[i] = 2;
				}
			} else {
				check[i] = 0;
				// arr[i] = 0;
				continue;
			}
		}
		System.out.println("----------------------------------");
		long ans=0;
		for( int i = 0; i<max/10; i++) {
			if( check[i] != 2) {
				continue;
			}
			// System.out.println( "--------" + i);
			// if( i*10 + 9 > max) {
			// 	break;
			// }
			for( int j=0; j<10; j++) {
				a = i*10 + j;
				if( a < max && obj.a[a] == 1) {
					ans += a;
					count++;
					// System.out.println(a);
				}

			}
		}
		System.out.println("Size - " + count);
		System.out.println("Sum - " + ans);
		System.out.println("----------------------------------");
	}

	public static int getSum(int num) {
		int sum = 0;
        while (num != 0) {
            int lastdigit = num % 10;
            sum += lastdigit;
            num /= 10;
        }
        return sum;
	}
}