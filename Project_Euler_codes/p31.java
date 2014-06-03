public class p31
{
	public static void main(String[] args)
	{
		int a[] = {1, 2, 5, 10, 20, 50, 100};
		int[] b = new int[201];
		int[] c = new int[201];
		for( int i=0; i<201; i++ )
		{
			b[i] = 0;
			c[i] = 0;
		}
		b[1] = 1;
		for( int i=2; i<201; i++ )
		{
			for( int j=0; j<7; j++ )
			{
				if( i-a[j] > 0 && c[a[j]] !=1 && c[i-a[j]] != 1)
				{
					b[i] = b[i] + b[i-a[j]];
					c[a[j]] = 1;
					c[i-a[j]] = 1;
				}
				else if( i-a[j] == 0  && c[a[j]] !=1 && c[i-a[j]] != 1)
					b[i] = b[i] +1 ;
			}
			for( int j=0; j<201; j++ )
				c[j] = 0;
		}
		for( int i=1; i<50; i++ )
			System.out.println(b[i]+" ");
	}
}

/*

1 1 1 1
1 1 2
2 2