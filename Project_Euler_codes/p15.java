public class p15
{
	public static void main(String[] args)
	{
		long[][] a = new long[21][21];
		for( int i=0; i<21; i++ )
		{
			a[i][0] = 1;
			a[0][i] = 1;
		}
		for( int i=1; i<21; i++ )
			for( int j=1; j<21; j++ )
				a[i][j] = a[i][j-1] + a[i-1][j];
		System.out.println( a[20][20] );
	}
}