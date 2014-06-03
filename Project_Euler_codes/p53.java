public class p53
{
	public static void main(String[] args)
	{
		int i, n, r, count=4, pro=1;
		for( n=24; n<=100; n++ )
		{
			for( r=3; r<15; r++ )
			{
				pro=1;
				for( i=0; i<r; i++ )
					pro = (pro*(n-i))/(i+1);
				if( pro >1000000 )
				{
					count += (n-r)-r+1;
					break;
				}
			}
		}
		System.out.println(count);
	}
}