public class p14
{
	public static void main(String[] args)
	{
		int i, limit = 1000000, pr=2, count=0, max=1;
		long n;
		int[] a = new int[limit];
		for( i=0; i<limit; i++ )
		{
			if( i == pr )
			{
				a[i]=count;
				count++;
				pr = pr * 2;
			}
			else
				a[i]=0;
		}
		a[1]=1;
		for( i=2; i<limit; i++ )
		{
			if( a[i] == 0 )
			{
				n=i;
				while( true )
				{
					count++;
					if( n % 2 == 0 )
						n /= 2;
					else
						n = 3*n + 1;
					count++;
					if( n < limit )
					{
						if( a[(int)n] != 0 )
						{
							count = count + a[(int)n];
							break;
						}
					}
					else
						continue;
				}
				if (max < count)
				{
					max = count;
					pr = i;
				}
				a[i] = count;
				count = 0;
			}
		}
		System.out.println(pr);
	}
}