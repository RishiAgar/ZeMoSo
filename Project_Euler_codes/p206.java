public class p206 {

	public static String pattern = "1_2_3_4_5_6_7_8_9";
	public static long max = 19293949596979899L;
	public static long min = 10203040506070809L;
	public static void main(String[] args) {

		long maxSqrRoot = 138902663L;
		long minSqrRoot = 101010103L;
		byte flag = 03;
		for( long i=minSqrRoot; i<=maxSqrRoot; ) {

			if(checkSquare(i)) {
				System.out.println(i + "0");
				return;
			}
			if(flag == 03) {
				flag = 07;
				i += 4;
			} else if( flag == 07) {
				flag = 13;
				i += 6;
			} else if( flag == 13) {
				i += 4;
				flag = 17;
			} else if( flag == 17) {
				i += 6;
				flag = 03;
			}
		}
	}

	public static boolean checkSquare(long num) {

		long square = num * num;
		String str = square + "";
		boolean flag = true;
		// System.out.println( pattern.length() + "  " + str.length());
		if( square >= min && square <= max && pattern.length() == str.length()) {
			for( int i=0; i<str.length(); i++ ) {
				char ch1 = pattern.charAt(i);
				char ch2 = str.charAt(i);
				if(flag) {
					if( ch1 != ch2) {
						return false;
					}
				}
				flag = !flag;
			}
		} else {
			return false;
		}
		return true;
	}
}

// 			 3or7 0

// 1_2_3_4_5_6_7_8_9_0
// 1_2_3_4_5_6_7_8_900

// 12233445566778899