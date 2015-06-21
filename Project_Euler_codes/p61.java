import java.util.*;

public class p61 {

	private static int max = 10000, min = 1000;
	private static int[] arr_p3;
	private static int[] arr_p4;
	private static int[] arr_p5;
	private static int[] arr_p6;
	private static int[] arr_p7;
	private static int[] arr_p8;
	public static void main(String[] args) {

		int max_p = 8, min_p = 3;
		int[][] arr = new int[max][max_p - min_p + 1];
		for( int i = min; i<max; i++) {
			for( int j = min_p; j<=max_p; j++) {
				arr[i][j - min_p] = 0;
			}
		}
		createArray();
		System.out.println( "3 " + arr_p3.length);
		System.out.println( "4 " + arr_p4.length);
		System.out.println( "5 " + arr_p5.length);
		System.out.println( "6 " + arr_p6.length);
		System.out.println( "7 " + arr_p7.length);
		System.out.println( "8 " + arr_p8.length * arr_p7.length* arr_p6.length * arr_p5.length* arr_p4.length * arr_p3.length);
		// for( int i=0; i<arr_p8.length; i++) {
		// 	System.out.println(arr_p8[i]);
		// }
	}















	public static void createArray() {

		List<Integer> p3 = new LinkedList<>();
		List<Integer> p4 = new LinkedList<>();
		List<Integer> p5 = new LinkedList<>();
		List<Integer> p6 = new LinkedList<>();
		List<Integer> p7 = new LinkedList<>();
		List<Integer> p8 = new LinkedList<>();
		int  k = 0, k3 = 0, k4 = 0, k5 = 0, k6 = 0, k7 = 0, k8 = 0;
		for( int i = 1; i<max; i++) {
			if( getTriangle(i) > max) {
				break;
			}
			if( getOctagonal(i) < min) {
				continue;
			}
			if( getTriangle(i) > min) {
				p3.add(getTriangle(i));
			}
			if( getSquare(i) > min && getSquare(i) < max) {
				p4.add(getSquare(i));
			}
			if( getPentagonal(i) > min && getPentagonal(i) < max) {
				p5.add(getPentagonal(i));
			}
			if( getHexagonal(i) > min && getHexagonal(i) < max) {
				p6.add(getHexagonal(i));
			}
			if( getHeptagonal(i) > min && getHeptagonal(i) < max) {
				p7.add(getHeptagonal(i));
			}
			if( getOctagonal(i) > min && getOctagonal(i) < max) {
				p8.add(getOctagonal(i));
			}
		}
		arr_p3 = new int[p3.size()];
		arr_p4 = new int[p4.size()];
		arr_p5 = new int[p5.size()];
		arr_p6 = new int[p6.size()];
		arr_p7 = new int[p7.size()];
		arr_p8 = new int[p8.size()];
		for( int i : p3) {
			arr_p3[k++] = i;
		}
		k = 0;
		for( int i : p4) {
			arr_p4[k++] = i;
		}
		k = 0;
		for( int i : p5) {
			arr_p5[k++] = i;
		}
		k = 0;
		for( int i : p6) {
			arr_p6[k++] = i;
		}
		k = 0;
		for( int i : p7) {
			arr_p7[k++] = i;
		}
		k = 0;
		for( int i : p8) {
			arr_p8[k++] = i;
		}
	}

	public static int sortDigits(int n) {
	    char[] chars = Integer.toString(n).toCharArray();
	    Arrays.sort(chars);
	    for (int i = 0, j = chars.length - 1; i < j; i++, j--) {                                                                                   
	        char t = chars[i]; chars[i] = chars[j]; chars[j] = t;
	    }
	    return Integer.parseInt(new String(chars));
	}   

	public static int getTriangle(int num) {
		return num*(num+1)/2;
	}

	public static int getSquare(int num) {
		return num*num;
	}

	public static int getPentagonal(int num) {
		return num*(3*num - 1)/2;
	}

	public static int getHexagonal(int num) {
		return num*(2*num - 1);
	}

	public static int getHeptagonal(int num) {
		return num*(5*num - 3)/2;
	}

	public static int getOctagonal(int num) {
		return num*(3*num - 2);
	}
}