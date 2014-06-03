public class p58
{
	public static void main(String[] args)
	{
		int i, limit = 10000000;
		prime obj = new prime(limit);
		obj.prime_func();
		float min = 62;
		int[] sq = new int[1000];
		for( i=0; i<1000; i++ )
			sq[i] = ((2*i)+1)*((2*i)+1);
		int c=0, j;
		for( i=1; i<1000; i++ )
		{
			if( obj.a[sq[i] - 2*i] == 1 )
				c++;
			if( obj.a[sq[i] - 2*i - 2*i ] == 1 )
				c++;
			if( obj.a[sq[i] - 2*i - 2*i - 2*i ] == 1 )
				c++;
			if( ((float)c/((4*i)+1))*100 < min )
			{
				min = ((float)c/((4*i)+1))*100;
			}
		}
		int k, flag, s;
		while( true )
		{
			s = ((2*i)+1)*((2*i)+1);
			k=0;
			while( k < 4)
			{
				k++;
				s = s - (2*i);
				if( s%2 != 0 )
				{
					flag=0;
					for( j = 3; j<=(int)Math.sqrt(s); j+=2 )
						if( s%j == 0)
							flag=1;
					if( flag == 0 )
						c++;
				}
			}
			if( ((float)c/((4*i)+1))*100 < 10 )
			{
				System.out.println( 2*i + 1 );
				break;
			}
			i++;
		}
	}
}