public class p20
{
	public static void main(String[] args)
	{
		int i, j, s=0, f=1;
		int[] a = new int[200];
		for( i=0; i<200; i++ )
			a[i]=0;
		for( i=2; i<=9; i++ )
			f*=i;
		f/=10;
		i=0;
		while( f != 0 )
		{
			a[i] = f%10;
			f/=10;
			i++;
		}
		for( i=11; i<100; i++ )
			for( j=0; j<200; j++ )
			{
				f = a[j]*i + s;
				a[j] = f%10;
				s = f/10;
			}
		s=0;
		for( i=0; i<200; i++ )
			s+=a[i];
		System.out.println(s);
	}
}