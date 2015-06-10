public class p112 {
	public static void main(String[] args) {

		double percent;
		int count_bouncy = 525;
		for( int i=1000; ; i++) {
			if( isBouncy(i)) {
				count_bouncy++;
				percent = ((double)count_bouncy * 100) / i;
				if( Math.ceil(percent) == Math.floor(percent) && Math.ceil(percent) == 99.0) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	public static boolean isBouncy(int num) {
		return !isIncreasing(num) && !isDecreasing(num);
	}
	public static boolean isIncreasing(int num) {
		int max = -1;
		while( num != 0) {
			int a = num % 10;
			num /= 10;
			if( a >= max) {
				max = a;
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isDecreasing(int num) {
		int min = 10;
		while( num != 0) {
			int a = num % 10;
			num /= 10;
			if( a <= min) {
				min = a;
			} else {
				return false;
			}
		}
		return true;
	}
}