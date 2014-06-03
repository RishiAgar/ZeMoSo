import java.io.*;
public class p42
{
    public static void main(String[] args) throws IOException
	{
		int i, j, k=0, l, n=0, count=0;
		char ch;
		String line;
        BufferedReader bfr = null;
		bfr = new BufferedReader(new FileReader("words.txt"));
		while(( n = (int)bfr.read()) != -1 )
			if( n == 44 )
				count++;
		String[] a = new String[count+1]; 
		bfr=new BufferedReader(new FileReader("words.txt"));
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
		count = 0;
		int[] b = new int[20101];
		for( i=0; i<20101; i++ )
			b[i] = 0;
		for( i=0; i<=200; i++ )
			b[(i*(i+1))/2] = 1;
		for( i=0; i<k; i++ )
		{
			len = a[i].length();
			int sum =0;
			for( j=0; j<len ;j++ )
				sum = sum +((int)(a[i].charAt(j))-64);
			if( b[sum] == 1)
				count++;
		}
		System.out.println(count);
	}
}