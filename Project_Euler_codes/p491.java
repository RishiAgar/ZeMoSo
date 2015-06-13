import java.math.*;

public class p491 {

    public static int count = 0;
    public static int sum_digits = 0;
    public static long fact_10;
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};

        for( int i=0; i<arr.length; i++ ) {
            sum_digits += arr[i];
        }
        System.out.println(sum_digits);
        int r = 10;
        combine(arr, r);
        System.out.println(count);
    }

    private static void combine(int[] arr, int r) {
        int[] res = new int[r];
        doCombine(arr, res, 0, 0, r);
    }

    private static void doCombine(int[] arr, int[] res, int currIndex, int level, int r) {
        if(level == r) {
            checkDivisibility(res);
            return;
        }
        for (int i = currIndex; i < arr.length; i++) {
            res[level] = arr[i];
            doCombine(arr, res, i+1, level+1, r);
            if(i < arr.length-1 && arr[i] == arr[i+1]){
                i++;
            }
        }
    }

    private static void checkDivisibility(int[] res) {

        int[] permu1 = new int[10];
        int[] permu2 = new int[10];
        int sum_part1 = 0;
        for (int i = 0; i < res.length; i++) {
            // System.out.print(res[i] + "_");
            sum_part1 += res[i];
        }
        int sum_part2 = sum_digits - sum_part1;
        int diff = sum_part1 - sum_part2;
        if( sum_part1 < sum_part2) {
            diff = -diff;
        }
        if( diff % 11 == 0) {

            for( int i=0; i<10; i++) {
                permu1[i] = 0;
                permu2[i] = 2;
            }
            for (int i = 0; i < res.length; i++) {
                permu1[res[i]]++;
                permu2[res[i]]--;
            }
            count++;
        }
        // System.out.println();
    }
}