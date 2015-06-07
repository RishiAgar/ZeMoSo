import java.io.*;
public class p99 {

	public static void main(String[] args) throws IOException {

		int k=0, max = 1000;
		String line;
		double[] base = new double[max];
		double[] exponent = new double[max];
		BufferedReader bfr = new BufferedReader(new FileReader("p99.txt"));
        while(( line = bfr.readLine()) != null ) {
        	String[] s = line.split(",");
        	base[k] = Double.parseDouble(s[0]);
        	exponent[k] = Double.parseDouble(s[1]);
        	k++;
        }
        int maxExponent = 0;
        for( int i=1; i < max; i++ ) {
    		double maxValue = Math.log10(base[maxExponent])*exponent[maxExponent];
    		double value = Math.log10(base[i])*exponent[i];
    		if( maxValue < value) {
    			maxExponent = i;
    		}
        }
        System.out.println(maxExponent + 1);
    }
}