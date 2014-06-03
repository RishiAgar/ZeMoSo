public class p44
{
	public static void main(String[] args)
	{
		int i, limit = 10000000;
		byte[] a = new byte[limit];
		int[] b = new int[100000];
		int k = 0;
		for( i=1; i<limit ; i++ )
		{
			a[i]=0;
			if( i<100000)
				b[i]=0;
		}
		for( i=1; k<100000 && (i*((3*i)-1)/2)<limit; i++ )
		{
			b[k++] = i*((3*i)-1)/2;
			a[i*((3*i)-1)/2]=1;
		}
		int min = limit, j;
		for( i=1; i<k-1 ; i++ )
			for( j=i+1; j<k ;j++ )
				if( b[i]+b[j] < limit )
					if( a[b[i]+ b[j]] ==1 && a[b[j] - b[i]] == 1 )
						if(	(b[j] - b[i]) < min)
							min = b[j] - b[i];
		System.out.println(min);
	}
}