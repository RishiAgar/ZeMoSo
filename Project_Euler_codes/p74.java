import java.util.*;
public class p74 {
	public static void main(String[] args) {
		
		int sum, count = 0, max = 1000000;
		int[] fact = new int[10];
		fact[0] = 1;
		for( int i=1; i<10; i++) {
			fact[i] = fact[i-1] * i;
			// System.out.println(fact[i]);
		}
		for( int i = 11; i<max; i++) {
			int count_chain = 1;
			Map<Integer, Byte> map = new HashMap<>();
			sum = i;
			while(true) {
				// if( i == 999836) {
				// 	System.out.println( i + "  " + sum + "  " + count_chain);
				// }
				map.put( sum, (byte)0);
				// if( i == 26) {
				// 	System.out.println(sum);
				// }
				sum = getSum(sum, fact);
				if( count_chain > 62 || map.containsKey(sum)) {
					break;
				}
				count_chain++;
				
			}
			if( count_chain == 60) {
				// System.out.println(i);
				count++;
			}
		}
		System.out.println(count);
	}

	public static int getSum( int num, int[] fact) {
		int sum=0;
		while(num !=0) {
			int a = num % 10;
			num /= 10;
			sum += fact[a];
		}
		return sum;
	}
}