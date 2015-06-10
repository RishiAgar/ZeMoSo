import java.util.*;
public class p204 {
	public static void main(String[] args) {
		int max = 1000000000, count = 100;
		prime obj = new prime(max);
		obj.prime_func();
		List<Integer> list = new LinkedList<>();
		for( int i=101; i<=obj.limit/2; i+=2) {
			if( obj.a[i] == 1) {
				list.add(i);
			}
		}
		for( int i : list) {
			for( int j = i; j<max; j = j+i) {
				obj.a[j] = 2;
			}
		}
		for( int i=101; i<=obj.limit; i++) {
			if( obj.a[i] == 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}