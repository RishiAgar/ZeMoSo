import java.io.*;
public class p34
{
	public static void main(String[] args)throws IOException
	{
		long pro =1, sum=0, s;
		int	i, temp;
		long[] a = new long[10];
		a[0]=1;
		for( i=1; i<10;i++)
		{
			pro*=i;
			a[i] = pro;
		}
		for( i=10; i<a[9]*9; i++ )
		{
			temp = i;
			s=0;
			while( temp != 0 )
			{
				if( a[temp%10] > i )
					break;
				s = s + a[temp%10];
				temp = temp / 10;
			}
			if( s == i )
				sum = sum +i;
		}
		System.out.println(sum);
	}
}