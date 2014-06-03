import java.io.*;
import java.util.Arrays;
public class p22
{
    public static void main(String[] args) throws IOException
	{
		int i, j, k=0, l, n=0, count=0;
		char ch;
		String line;
		
        BufferedReader bfr = null;
		bfr = new BufferedReader(new FileReader("p22.txt"));
		while(( n = (int)bfr.read()) != -1 )
			if( n == 44 )
				count++;
		String[] a = new String[count]; 
		bfr=new BufferedReader(new FileReader("p22.txt"));
		line = bfr.readLine();
		int len = line.length();
		for( i=0; i<len; i++ )
		{
			ch = line.charAt(i);
			if( (int)ch == 34 )
				for( j=i+1; j<len; j++ )
				{
					ch = line.charAt(j);
					if( (int)ch == 34 )
					{
						a[k] = line.substring(i+1, j);
						k++;
						i = j+1;
						break;
					}
				}
		}
		Arrays.sort(a);
		long sum=0;
		long s;
		for( i=0; i<k; i++ )
		{
			len = a[i].length();
			s=0;
			for( j=0; j<len; j++ )
				s = s + ((int)a[i].charAt(j) - 64 );
			sum = sum +( s*(i+1));
		}
		System.out.println(sum);
	}
}