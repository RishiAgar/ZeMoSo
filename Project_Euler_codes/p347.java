import java.util.*;

public class p347 {
	public static void main(String[] args) {
		int max = 10000001;
		prime obj = new prime(max/2 + 1);
		obj.prime_func();
		// int power = 1;
		// for( int i=1; i<max; i++) {
		// 	power *= 2;
		// 	if( power > max) {
		// 		power = i;
		// 		break;
		// 	}
		// }
		// int[][] arr = new int[obj.k][power];
		// int k = 0;
		// for( int prime : obj.prime) {
		// 	if( prime == 0) {
		// 		break;
		// 	}
		// 	arr[k++][1] = prime;
		// }
		// for( int i=0; i<obj.k; i++) {
		// 	for( int j=2; j<power; j++) {
		// 		arr[i][j] = arr[i][j-1] * arr[i][1];
		// 		if( arr[i][j] > max ) {
		// 			arr[i][j] = -1;
		// 			break;
		// 		}
		// 	}
		// }
		// for( int i=0; i<obj.k; i++) {
		// 	for( int i=0; i<obj.k; i++) {

		// 	}
		// }
		System.out.println("1 > --------------------------------------");
		Map<String, Integer> mapping = new HashMap<>();
		Map<Integer, List> map = new HashMap<>();
		int[] arr = new int[max];
		for( int i=0; i<max; i++) {
			arr[i] = 0;
		}
		System.out.println("2 > --------------------------------------");
		for( int i=0; i<obj.k; i++) {
			System.out.println(obj.prime[i]);
			for( int j=obj.prime[i]; j<max; ) {
				// System.out.println( " >- " + j);
				List list;
				if( map.containsKey(j)) {
					list = map.get(j);
				} else {
					list = new LinkedList<>();
				}
				if( !list.contains(obj.prime[i])) {
					list.add(obj.prime[i]);
					map.put(j, list);
				}
				arr[j]++;
				j = j + obj.prime[i];
			}
		}
		System.out.println("3 > --------------------------------------");
		long s = 0;
		for( int i = max-1; i>=0; i--) {
			if( arr[i] == 2) {
				// System.out.println(i);
				List list = map.get(i);
				String str = list.get(0) + "_" + list.get(1);
				String str1 = list.get(1) + "_" + list.get(0);
				if( mapping.containsKey(str) || mapping.containsKey(str1)) {
					continue;
				} else {
					mapping.put(str, 1);
					s += i;
					System.out.println(str);
					// System.out.println(str);
				}
			}
		}
		System.out.println(s);
	}
}