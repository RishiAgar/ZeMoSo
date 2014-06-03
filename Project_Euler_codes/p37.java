public class p37
{
	public static void main(String args[])
	{	
		int i, j, k=0, limit = 100000000, flag=0, temp, sum=0, b=0;
		byte[] a = new byte[limit];
		int[] prime = new int[limit/15];
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
		long s=0;
		int l=0;
		for( i=4; i<k; i++ )
		{
			temp = prime[i];
			sum = 0;
			flag=1;
			j=0;
			while( temp != 0 )
			{
				b = temp % 10;
				sum = sum + b*(int)Math.pow(10,j);
				j++;
				if( a[temp] == 0 || a[sum] == 0 )
				{
					flag = 0;
					break;
				}
				temp = temp /10;
			}
			if( flag == 1 )
			{
				s = s + prime[i];
				l++;
				if( l == 11 )
					break;
			}
		}
		System.out.println(s);
	}
}