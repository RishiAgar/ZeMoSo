public class p35
{
	public int func(int i)
	{
		if( i<1000)
			return 3;
		if( i<10000)
			return 4;
		if( i<100000)
			return 5;
		if( i<1000000)
			return 6;
		return 0;
	}
	public static void main(String args[])
	{
		p35 obj = new p35();
		int i, j, k=0, limit = 1000000, count=13, n, temp=0,b=0, flag=1;
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
		for( i=25; i<k; i++ )
		{
			n = obj.func(prime[i]);
			flag = 1;
			j=1;
			temp = prime[i];
			while( j <= n )
			{
				b = temp % 10;
				temp = temp / 10;
				temp = temp + b*(int)Math.pow( 10, n-1);
				if( a[temp] == 0 )
				{
					flag = 0;
					break;
				}
				j++;
			}
			if( flag == 1)
				count++;
		}
		System.out.println(count);
	}
}