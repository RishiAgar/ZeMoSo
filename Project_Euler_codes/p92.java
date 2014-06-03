public class p92
{
	public int square( int i )
	{
		int sum = 0;
		while( i != 0 )
		{
			sum = sum + ((i%10)*(i%10));
			i /= 10;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		p92 obj = new p92();
		int i, j, limit = 10000001, l;
		byte flag=0;
		int[] a = new int[limit];
		int[][] b = new int[2][limit];
		for( i=1; i<limit; i++ )
		{
			a[i] = obj.square(i);
			if( i == 85 || i == 89 || i == 145 || i == 42 || i == 20 || i == 4 || i == 16 || i == 37 || i == 58 )
				b[0][i] = 1;
			else if( i == 44 || i == 32 || i == 13 || i == 10 || i==1)
				b[0][i] = -1;
			else
				b[0][i] = 0;
		}
		for( i=2; i<limit; i++ )
		{
			if( b[0][i] == 1 || b[0][i] == -1 )
				continue;
			j=i;
			flag=0;
			l=0;
			while( true )
			{
				b[1][l] = j;
				l++;
				j = a[j];
				if( b[0][j] == 1 )
				{
					flag=1;
					break;
				}
				else if( b[0][j] == -1 )
				{	
					flag=-1;
					break;
				}
			}
			for( j=0; j<l; j++ )
			{
				
				b[0][b[1][j]] = flag;
			}
		}
		l=0;
		for( i=2; i<limit; i++ )
			if( b[0][i] == 1)
				l++;
		System.out.println(l);
	}
}