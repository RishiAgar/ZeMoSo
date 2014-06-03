import java.io.*;
public class p57
{
	public static void main(String[] args)throws IOException
	{
		int num = 3, den = 2, i, j, c=0, carry, count_den=0, count_num=0 ;
		int[] n = new int[500];
		int[] d = new int[500];
		int[] a = new int[500];
		for( i=0; i<500; i++ )
		{
			n[i] = 0;
			d[i] = 0;
			a[i] = 0;
		}
		i=0;
		while( i<499  )
		{
			n[i] = num % 10;
			d[i] = den % 10;
			num /= 10;
			den /= 10;
			i++;
		}
		for( j=2; j<1001; j++ )
		{
			carry=0;
			for( i=0; i<500; i++ )
			{
				a[i] = ( n[i] + d[i]+ carry ) % 10;
				carry = ( n[i] + d[i]+ carry ) / 10;
			}
			for( i=499; i>=0; i-- )
				if( a[i] != 0  )
				{
					count_den = i+1;
					break;
				}
			carry=0;
			for( i=0; i<500; i++ )
			{
				num = ( n[i] + d[i] + d[i] + carry ) ;
				n[i] = num%10;
				carry = ( num) / 10;
				
			}
			for( i=499; i>=0; i-- )
				if( n[i] != 0  )
				{
					count_num = i+1;
					break;
				}
			for( i=0; i<500; i++ )
				d[i] = a[i];
			if( count_num > count_den )
				c++;
		}
		System.out.println(c);
	}
}