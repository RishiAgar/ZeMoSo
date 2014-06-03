import java.io.*;
public class p11
{
    public static void main(String[] args) throws IOException
	{
		int i,j,k, len;
		long max=0;
		char ch;
		String line;
		long[][] a = new long[20][20]; 
        BufferedReader bfr=new BufferedReader(new FileReader("p11.txt"));
		k=0;
		while(( line = bfr.readLine()) != null )
		{
			j=0;
			len = line.length();
			for( i=0; i<len; i++ )
			{
				ch = line.charAt(i);
				if( i%3 == 0 )
					a[k][j] = ((int)ch- 48) * 10;
				else if( i%3 == 1 )
					a[k][j] = a[k][j] + ((int)ch- 48);
				else
					j++;
			}
			k++;
		}
		for( i=0; i<20; i++ )
			for( j=0; j<16; j++ )
				max = Math.max( max, a[i][j]*a[i][j+1]*a[i][j+2]*a[i][j+3]);
		for( j=0; j<20; j++ )
			for( i=0; i<16; i++ )
				max = Math.max( max, a[i][j]*a[i+1][j]*a[i+2][j]*a[i+3][j]);
		for( i=0; i<16; i++ )
			for( j=0; j<16; j++ )
				max = Math.max( max, a[i][j]*a[i+1][j+1]*a[i+2][j+2]*a[i+3][j+3]);
		for( i=19; i>=3; i-- )
			for( j=0; j<16; j++ )
				max = Math.max( max, a[i][j]*a[i-1][j+1]*a[i-2][j+2]*a[i-3][j+3]);
		System.out.println(max);
	}
}