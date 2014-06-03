public class p25
{
	
	public static void main(String[] args)
	{
		int f1=1, f2=1, count=2, i, c=0, k1=0, k2=0, temp, s;
		int[] n1 = new int[1100];
		int[] n2 = new int[1100];
		while( f1 < 10000 )
		{
			temp = f2;
			f2 = f1 + f2;
			f1 = f2;
			count++;
		}
		for( i=0; i<1000; i++ )
		{
			n1[i] = 0;
			n2[i] = 0;
		}
		while( f1 != 0)
		{
			n1[k1++] = f1%10;
			f1 /= 10;
		}
		while( f2 != 0)
		{
			n2[k2++] = f2%10;
			f2 /= 10;
		}
		i=0;
		while( k2 <= 1000 )
		{
			while( true )
			{
				s = n1[i] + n2[i] + c;
				n1[i] = n2[i];
				n2[i] = s % 10;
				c = s / 10;
				i++;
				if( i == k2)
				{
					if( c !=0 )
					{
						n2[i] = c;
						k2++;
					}
					k1 = k2;
					break;
				}
			}
			count++;
			i=0;
			c=0;
		}
		System.out.println(count+1);
	}
}