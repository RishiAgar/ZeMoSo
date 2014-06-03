public class p12
{
	public int factor( int n )
	{
		int count=2, i;
		for( i=2; i<=n/2; i++ )
			if( n%i == 0)
				count++;
		return count;
	}
	public static void main(String[] args)
	{
		p12 obj = new p12();
		int i, n1, n2;
		int[] a = new int[1000000];
		for( i=0; i<10000; i++ )
			a[i]=0;
		for( i=1; ; i++ )
		{
			n1=i;
			n2=i+1;
			if( i%2 == 0 )
				n1/=2;
			else
				n2/=2;
			if( a[n1] == 0 )
				a[n1]=obj.factor(n1);
			if( a[n2] == 0 )
				a[n2]=obj.factor(n2);
			if( a[n1]*a[n2] >= 500 )
			{
				System.out.println(n1*n2);
				break;
			}
		}
	}
}