public class p47
{
	public static void main(String args[])
	{
		int i, j, k=0, limit = 200000;
		byte[] a = new byte[limit];
		byte[] b = new byte[limit];
		int[] prime = new int[limit/2];
		for( i=0; i<limit; i++ )
		{
			if( i%2 == 0 && i != 2 )
				a[i]=0;
			else
				a[i]=1;
			b[i]=0;
		}
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
		for( i=647; i<limit; i++ )
		{
			if( a[i] == 0 )
				for( j=0; prime[j]<=i && j<k; j++ )
				{
					if( i%prime[j] == 0 )
						b[i]++;
					if( b[i] > 4 )
						break;
				}
		}
		k=-1;
		for( i=647; i<limit-4; i++ )
			if( b[i]==4 && b[i+1]==4 && b[i+2]==4 && b[i+3]==4 )
			{
				k = i;
				break;
			}
			else
			{
				if( b[i+3] != 4 )
					i++;
			}
		System.out.println(k);
	}
} 