public class p76 
{
    public static void main(String args[])
    {
        int max = 100;
        int[] arr = new int[max+1];
        arr[0] = 1;
        for (int i = 1; i <= max-1; i++) {
            for (int j = i; j <= max; j++) {
                arr[j] += arr[j - i];
            }
        }
        System.out.println( arr[arr.length - 1]);
    }
}