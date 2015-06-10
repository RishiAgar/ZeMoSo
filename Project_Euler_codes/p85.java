public class p85 {
	public static void main(String[] args) {

		boolean flag = false;
		int max = 2000000;
		long count_rectangles = 0, deviation, deviation_min = max, i_min = 0, j_min = 0;
		for( int i=1; i<max; i++) {
			for( int j=1; j<=i; j++) {
				count_rectangles = ((long)i*j*(i+1)*(j+1))/4;
				if( count_rectangles > max*10) {
					flag = true;
					break;
				}
				deviation = Math.abs(max - count_rectangles);
				if( deviation < deviation_min) {
					deviation_min = deviation;
					i_min = i;
					j_min = j;
				}
			}
			if(flag) {
					System.out.println(i_min*j_min);
					break;
			}
		}
	}
}