import java.io.*;
public class p13
{
    public static void main(String[] args) throws IOException
	{
		int b=1, sum=0, n=0, count=0, carry = 0, i;
        BufferedReader bfr=new BufferedReader(new FileReader("p13.txt"));
		int[] a = new int [52];
		int[] s = new int [52];
		for( i=0; i<52; i++ )
		{
			a[i] = 0;
			s[i] = 0;
		}
		while(( n = (int)bfr.read()) != -1 )
		{
			b = n-48;
			if( b < 0)
				continue;
			count++;
			a[ count+1 ] = b;
			if( count  == 50)
			{
				count = 0;
				for( i=51; i>=0; i-- )
				{
					sum = s[i] + a[i] + carry;
					s[i] = sum % 10;
					carry = sum / 10;
				}
			}
		}
		for( i=0; i<10; i++ )
			System.out.print( s[i] );
		bfr.close();
    }
}