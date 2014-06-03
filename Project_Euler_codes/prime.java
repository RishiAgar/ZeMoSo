public class prime
{
	public static int limit;
	public static int k = 0;
	public static int[] prime;
	public static byte[] a;
	prime( int n )
	{
		limit = n;
		a = new byte[limit+1];
		prime = new int[limit];
	}
	public void prime_func()
	{
		int i, j;
		
		for( i=0; i<=limit; i++ )
			if( i%2 == 0 && i != 2 )
				a[i]=0;
			else
				a[i]=1;
		a[0]=0;		
		a[1]=0;
		for( i=2; i<=Math.sqrt(limit); i++ )
			if( a[i] == 1 )
				for( j=i+i; j<=limit; j=j+i )
					a[j]=0;
		prime[k++]=2;
		for( i=3; i<=limit; i+=2 )
			if( a[i] == 1)
				prime[k++]=i;
	}
	public static void main(String args[])
	{
		int n = 1000;
		prime obj = new prime(n);
		obj.prime_func();
	}
}