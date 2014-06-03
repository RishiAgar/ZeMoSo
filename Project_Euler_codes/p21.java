public class p21
{
	public static void main(String args[])
	{
	
		int i, j, k=0, limit = 10000, temp, l, ans=0;
		int[] a = new int[limit+1];
		int[] prime = new int[limit];
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
		for( i=0; i<=limit; i++ )
			a[i]=1;
		for( i=2; i<=limit; i++ )
		{
			temp=i;
			l=0;
			ans=0;
			while( l!=k )
				if( temp % prime[l] == 0 )
				{
					temp /= prime[l];
					ans++;
				}
				else
				{
					a[i] = a[i] * (int)((  (long)Math.pow( prime[l], ans+1) - 1 )/( prime[l] -1 ));
					if( temp == 1 )
						break;
					ans=0;
					l++;
				}
			a[i]=a[i]-i;
		}
		ans=0;
		for( i=2 ; i<=limit; i++ )
			if( a[i] <= limit && i != a[i] && a[a[i]] == i )
				ans+=a[i];
		System.out.println(ans);
	}
}