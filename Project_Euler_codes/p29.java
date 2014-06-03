public class p29
{
	public static void main(String args[])
	{
		int i, sum = 0;
		
		/*
		2 3 4 5 6 7 8 9 10
		
		2 4 8 16 32 64
		3 9 27 81
		5 25
		6 36
		7 49
		10 100
		*/
		
		int[] a = new int[8101];
		sum = sum + 81*98;
		sum = sum + 4 * (99 + 50 );
		for( i=0; i<8101; i++ )
			a[i]=0;
		for( i=1; i<6401; i++ )
		{
			if( i <= 200 && i%2 == 0 )
				a[i] = 1;
			if( i <= 400 && i%4 == 0 )
				a[i] = 1;
			if( i <= 800 && i%8 == 0 )
				a[i] = 1;
			if( i <= 1600 && i%16 == 0 )
				a[i] = 1;
			if( i <= 3200 && i%32 == 0 )
				a[i] = 1;
			if( i <= 6400 && i%64 == 0 )
				a[i] = 1;
		}
		
		for( i=1; i<6401; i++ )
			if( a[i] == 1 )
				sum++;
		for( i=0; i<8101; i++ )
			a[i]=0;
		for( i=1; i<8101; i++ )
		{
			if( i <= 300 && i%3 == 0 )
				a[i] = 1;
			if( i <= 900 && i%9 == 0 )
				a[i] = 1;
			if( i <= 2700 && i%27 == 0 )
				a[i] = 1;
			if( i <= 8100 && i%81 == 0 )
				a[i] = 1;
		}
		for( i=1; i<8101; i++ )
			if( a[i] == 1 )
				sum++;
		System.out.println(sum-2);
	}
}