import java.io.*;
public class p81
{
    public static void main(String[] args) throws IOException
	{
		int b=1, n=0, i=0, j=0, s=0;
        BufferedReader bfr=new BufferedReader(new FileReader("matrix.txt"));
		int[][] a = new int [80][80];
		while(( n = (int)bfr.read()) != -1 )
		{
			b = n-48;
			if( i == 80 && j == 80 )
				break;
			if( j > 79 )
			{
				j=0;
				i++;
			}
			if( b < 0 || b > 9 )
			{
				a[i][j] = s;
				s=0;
				j++;
				continue;
			}
			else
				s = s*10 + b;
		}
		for( i=1; i<80; i++ )
		{
			a[0][i] = a[0][i] + a[0][i-1];
			a[i][0] = a[i][0] + a[i-1][0];
		}
		for( i=1; i<80; i++ )
			for( j=1; j<80; j++ )
				a[i][j] = a[i][j] +Math.min( a[i][j-1], a[i-1][j] );
		System.out.println(a[79][79]);
	}
}