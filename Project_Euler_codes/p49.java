public class p49
{
	public static void main(String args[])
	{
		int i, j, k=0, limit = 10000;
		byte[] a = new byte[limit];
		int[] prime = new int[1061];
		int[][] b = new int[42994][3];
		for( i=0; i<limit; i++ )
		{
			if( i%2 == 0 && i != 2 )
				a[i]=0;
			else
				a[i]=1;
		}
		a[0]=0;		
		a[1]=0;
		for( i=2; i<=Math.sqrt(limit); i++ )
			if( a[i] == 1 )
				for( j=i+i; j<limit; j=j+i )
					a[j]=0;
		for( i=3; i<limit; i+=2 )
			if( a[i] == 1 && i>999 && i<10000)
				prime[k++]=i;
		int c=0;
		for( i=0; i<k-1; i++ )
			for( j=i+1; j<k; j++ )
				if( prime[j]+(prime[j]-prime[i]) < limit )
					if( a[prime[j]+(prime[j]-prime[i])] == 1 )
					{
						b[c][0] = prime[i];
						b[c][1] = prime[j];
						b[c][2] = prime[j]+(prime[j]-prime[i]);
						c++;
					}
		String s1, s2, s3;
		int[][] d = new int[3][10];
		int temp=0;
		for( i=0; i<c; i++ )
		{
			for( j=0; j<10; j++ )
			{
				d[0][j]=0;
				d[1][j]=0;
				d[2][j]=0;
			}
			temp = b[i][0];
			while( temp!=0)
			{
				d[0][temp%10]++;
				temp/=10;
			}
			temp = b[i][1];
			while( temp!=0)
			{
				d[1][temp%10]++;
				temp/=10;
			}
			temp = b[i][2];
			while( temp!=0)
			{
				d[2][temp%10]++;
				temp/=10;
			}
			temp=0;
			for( j=0; j<10; j++ )
				if( d[0][j] == d[1][j] && d[1][j] == d[2][j])
					continue;
				else
					temp=1;
			if( temp == 0 )
				System.out.println(b[i][0]+""+b[i][1]+""+b[i][2]);
		}
	}
}