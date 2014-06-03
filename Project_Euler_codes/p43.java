public class p43
{
	public static void main(String args[])
	{
		for( int i=1; i<988; i++ )
		{
			if( i%3 == 0)
			{
				if( i%10  == (i/10)%10 || i%10  == i/100 || i/100  == (i/10)%10 )
					continue;
				if( i%100 == 49 )
					System.out.println(i);
			}
		}
	}
}


/*
Using simple login and code
1430952867
4130952869
1460357289
4160357289
1406357289
4106357289
*/