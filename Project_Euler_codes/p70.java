import java.util.*;
public class p70 {
	public static void main(String[] args) {
		int max = 10000000;
		prime obj = new prime(max);
		obj.prime_func();
		double ans_min = max, ans_i = -1;
		for( int i=11; i<max; i++) {
			int euler = i;
			for( int j : obj.prime) {
				if( j > i) {
					break;
				}
				if( i % j == 0) {
					euler = (int)(euler * ((double)(j - 1)/j));
					if( checkPermutation(i, euler)) {
						double value = (double)i / euler;
						if( value < ans_min) {
							ans_min = value;
							ans_i = i;
							System.out.println( ans_min + " " + ans_i);
						}
					}
				}
			}
		}
		System.out.println(ans_i);
	}

	public static boolean checkPermutation(int n1, int n2) {

		int[] arr = new int[10];
		for( int i=0; i<10; i++) {
			arr[i] = 0;
		}
		while( n1 != 0 || n2 != 0) {
			arr[n1%10]++;
			n1 /= 10;
			arr[n2%10]--;
			n2 /= 10;
		}
		if( n1 != 0 || n2 != 0) {
			return false;
		}
		for( int i=0; i<10; i++) {
			if( arr[i] != 0) {
				return false;
			}
		}
	    return true;
	}
}