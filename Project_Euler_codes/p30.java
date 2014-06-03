public class p30
{
	public static void main(String args[])
	{
		int i, c, temp;
		long sum=0, ans=0;
		int[] a = new int[10];
		for( i=0; i<10; i++ )
			a[i] = (int)Math.pow( i, 5 );
		for( i =112; i<1000000; i++ )
		{
			temp = i;
			while(temp != 0)
			{
				c = temp%10;
				temp /= 10;
				sum += a[c];
			}
			if( sum == i )
				ans += sum;
			sum=0;
		}
		System.out.println( ans);
	}
}