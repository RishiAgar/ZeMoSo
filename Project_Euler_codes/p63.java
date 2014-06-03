public class p63
{
	public int count( long n )
	{
		int c = 0;
		while( n != 0 )
		{
			
			n /= 10;
			c++;
		}
		return c;
	}
	public static void main(String[] args)
	{
		p63 obj = new p63();
		long p;
		int i, j, c=3;
		for( i = 2; i<10; i++ )
		{
			p=1;
			for( j=1; j<100; j++ )
			{
				p *= i;
				if( obj.count(p) == j )
				{
					System.out.println( i + " ^ " + j + " = " +p);
					c++;
				}
			}
		}
		System.out.println(c);
	}
}