public class p69
{
	public static int limit = 1000001;
	public static int k = 0;
	public static int[] prime = new int[limit];
	public static byte[] a = new byte[limit];
    public static void main(String[] args)
	{
		int i, j;
		for( i=0; i<limit; i++ )
			if( i%2 == 0 && i != 2 )
				a[i]=0;
			else
				a[i]=1;
		a[0]=0;		
		a[1]=0;
		for( i=2; i<=Math.sqrt(limit); i++ )
			if( a[i] == 1 )
				for( j=i+i; j<limit; j=j+i )
					a[j]=0;
		prime[k++]=2;
		for( i=3; i<limit; i+=2 )
			if( a[i] == 1)
				prime[k++]=i;
		j=0;
		float max = 1;
		float[] b = new float[limit];
		for( i=0; i<limit; i++ )
			b[i] = 1;
		for( i=2; i<limit; i++ )
		{
			for( j=0; prime[j] <= Math.sqrt(i) && j<k; j++ )
				if( i%prime[j] == 0 )
					b[i] = b[i] * ( 1-(1/(float)prime[j]));
			b[i] = 1/b[i];
		}
		for( i=2; i<limit; i++ )
			if( max < b[i] )
			{
				j=i;
				max = b[i];
			}
		System.out.println(j);
	}
}