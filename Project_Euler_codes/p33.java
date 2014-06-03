public class p33
{
	public static void main(String[] args)
	{
		double d=0.0, d2=0.0;
		int num=1, den=1, i, j, x=1, y=1, k=0;
		int[] a = new int[4];
		for( i= 11; i<100; i++ )
		{
			if( i%10 == 0 )
				continue;
			for( j= i+1; j<100; j++ )
			{
				if( j%10 == 0 )
					continue;
				d = (double)i/(double)j;
				a[1] = i%10;
				a[0] = i/10;
				a[3] = j%10;
				a[2] = j/10;
				if( a[0] == a[2] )
				{
					x = a[1];
					y = a[3];
				}
				else if( a[0] == a[3] )
				{
					x = a[1];
					y = a[2];
				}
				else if( a[1] == a[2] )
				{
					x = a[0];
					y = a[3];
				}
				else if( a[1] == a[3] )
				{
					x = a[0];
					y = a[2];
				}
				else
					continue;
				d2 = (double)x/(double)y;
				if( d == d2 )
				{
					num *= x;
					den *= y;
					k++;
				}
				if( k == 4)
					break;
			}
		}
		for( i=100 ;i>1; i-- )
		{
			if( num%i == 0 && den%i == 0)
			{
				num/=i;
				den/=i;
			}
		}
		System.out.println(den);
	}
}