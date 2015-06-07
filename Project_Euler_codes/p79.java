import java.io.*;
public class p79 {

	public static void main(String[] args) throws IOException {

		int k=0, max = 50;
		String line;
		int[] arr = new int[max];
		int[] l1 = new int[10];
		int[] l2 = new int[10];
		int[] l3 = new int[10];
		for ( k=0; k<10; k++) {
			l1[k] = 0;
			l2[k] = 0;
			l3[k] = 0;
		}
		k=0;
		BufferedReader bfr = new BufferedReader(new FileReader("p79.txt"));
        while(( line = bfr.readLine()) != null ) {

        	int n1 = Integer.parseInt(line.charAt(0) + "");
        	int n2 = Integer.parseInt(line.charAt(1) + "");
        	int n3 = Integer.parseInt(line.charAt(2) + "");
        	if( n2 == 9) {
    			System.out.println(line);
        	}
    		l1[n1]++;
    		l2[n2]++;
    		l3[n3]++;
        	arr[k++] = Integer.parseInt(line);
        }
        System.out.println("\nAll Numbers ------------");
        for( k=0; k<max; k++) {
        	System.out.println(arr[k]);
        }

        System.out.println("\nLine 1, 2, 3 ------------");
        for( int i=0; i<10; i++) {
        	System.out.println( i + "    " + l1[i] + "    " + l2[i] + "    " + l3[i]);
        }

	}
}