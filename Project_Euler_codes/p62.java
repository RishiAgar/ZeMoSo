import java.util.*;
public class p62 {
	public static void main(String[] args) {
		int itr;
		long pro, sorted, ans_sorted = 0, max = 1000000L;
		Map<Long, Integer> map = new HashMap<>();
		for( long i=1; i<max; i++) {
			pro = i*i*i;
			sorted = sort(pro);
			itr = 1;
			if( map.containsKey(sorted)) {
				itr = map.get(sorted) + 1;
				map.put(sorted, itr);
			} else {
				map.put(sorted, 1);
			}
			if( itr == 5) {
				ans_sorted = sorted;
				break;
			}
		}
		for( long i=0; i<max; i++) {
			pro = i*i*i;
			sorted = sort(pro);
			if( sorted == ans_sorted) {
				System.out.println(pro);
				break;
			}
		}
	}

	public static long sort(long n) {
	    char[] chars = Long.toString(n).toCharArray();
	    Arrays.sort(chars);
	    for (int i = 0, j = chars.length - 1; i < j; i++, j--) {                                                                                   
	        char t = chars[i]; chars[i] = chars[j]; chars[j] = t;
	    }
    	return Long.parseLong(new String(chars));
	}   
}