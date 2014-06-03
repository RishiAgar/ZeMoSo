public class p39
{
    public static void main(String[] args)
	{
		int i, j, max=0, c=0;
		int[] a = new int[1001];
		for( i=0; i<1001; i++ )
			a[i]=0;
		for( i=2; i<=998; i++ )
			for( j=2; j<999; j++ )
			{
				if( i+j > 999 )
					continue;
				c = (i*i) + (j*j);
				if( (int)Math.pow((int)Math.sqrt(c),2) == c )
					if( (int)Math.sqrt(c)+i+j <=1000 )
						a[(int)Math.sqrt(c)+i+j]++;
			}
		j=0;
		for( i=0; i<1001; i++ )
			if( a[i] > max )
			{
				max = a[i];
				j = i;
			}
		System.out.println(j);
	}
}