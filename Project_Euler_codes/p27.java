public class p27
{
	public static void main(String args[])
	{
	
		int i, j, k=0, limit = 100000, count, n, ans=0, pro=1, max=-1;
		int[] a = new int[limit];
		int[] prime = new int[limit];
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
		prime[0]=2;
		k++;
		for( i=3; i<=limit; i+=2 )
			if( a[i] == 1)
			{
				prime[k]=i;
				k++;
			}
		for( i=-999; i<1000; i+=2 )
		{
			for( j=1; prime[j]<1000; j++ )
			{
				n=0;
				while( true )
				{
					ans = (n*n) + (n*i) + prime[j];
					if( ans>1 )
						if( a[ans] == 1 )
							n++;
						else
						{
							if(n > max )
							{
								max=n;
								pro = i*prime[j];
							}
							break;
						}
					else
					{
						if(n > max )
						{
								max=n;
								pro = i*prime[j];
						}
						break;
					}
				}
			}
		}
		System.out.println(pro+" "+max);
	}
}