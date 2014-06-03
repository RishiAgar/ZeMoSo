public class p16
{
	public static void main(String[] args)
	{
		int i, j, k, b;
		int s=32768;
		k=17;
		int[] a = new int[1000];
		while(k++<=31)
			s*=2;
		k-=2;
		for( i=0; i<1000; i++ )
			a[i]=0;
		i=0;
		while( s != 0 )
		{
			b=(int)s%10;
			s=s/10;
			a[i++]=b;
		}
		b=0;
		for( ; k<=1000; k++ )
		{
			for( j=0 ;j<1000; j++ )
			{
				s=a[j]*2+b;
				if( s>9 )
				{
					b=1;
					a[j]=s%10;	
				}
				else
				{
					b=0;
					a[j]=s;
				}
			}
		}
		b=0;
		for( j=0; j<1000; j++ )
			b+=a[j];
		System.out.print(b);
	}
}