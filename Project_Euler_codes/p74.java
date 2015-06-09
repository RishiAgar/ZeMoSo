import java.util.*;
public class p74 {
	public static void main(String[] args) {
		
		int sum, count = 0, max = 1000000;
		int[] fact = new int[10];
		fact[0] = 1;
		for( int i=1; i<10; i++) {
			fact[i] = fact[i-1] * i;
		}
		for( int i = 11; i<max; i++) {
			int count_chain = 1;
			Map<Integer, Byte> map = new HashMap<>();
			sum = i;
			while(true) {
				map.put( sum, (byte)0);
				sum = getSum(sum, fact);
				if( count_chain > 62 || map.containsKey(sum)) {
					break;
				}
				count_chain++;
				
			}
			if( count_chain == 60) {
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