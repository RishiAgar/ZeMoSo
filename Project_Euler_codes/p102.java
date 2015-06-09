import java.io.*;
public class p102 {
	public static void main(String[] args) throws IOException {
		
		int x1, y1, x2, y2, x3, y3, count = 0;
		float alpha, beta, gamma;
		String line;
		BufferedReader bfr=new BufferedReader(new FileReader("p102.txt"));
        while(( line = bfr.readLine()) != null ) {
        	String[] s = line.split(",");
        	x1 = Integer.parseInt(s[0]);
        	y1 = Integer.parseInt(s[1]);
        	x2 = Integer.parseInt(s[2]);
        	y2 = Integer.parseInt(s[3]);
        	x3 = Integer.parseInt(s[4]);
        	y3 = Integer.parseInt(s[5]);
        	alpha = (float)((y2 - y3)*(0 - x3) + (x3 - x2)*(0 - y3)) / (float)((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
        	beta = (float)((y3 - y1)*(0 - x3) + (x1 - x3)*(0 - y3)) / (float)((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
			gamma = 1.0f - alpha - beta;
			if( alpha > 0 && beta > 0 && gamma > 0) {
				count++;
			}
        }
        System.out.println(count);
	}
}