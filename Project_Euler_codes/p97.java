public class p97
{
	public static void main(String[] args)
	{
		int[] a = new int[11];
		int tw_pw=2;
		int i, carry=0, j;
		for( i=2; i<=10; i++ )
			tw_pw *= 2;
		for( j=0; j<11; j++ )
			a[j]=0;
		i=0;
		while( i<11 )
		{
			a[i] = tw_pw%10;
			tw_pw /= 10;
			i++;
		}
		for( i=11; i<=7830457; i++ )
		{
			carry=0;
			for( j=0; j<11; j++ )
			{
				tw_pw = a[j]*2 + carry;
				a[j] = tw_pw % 10;
				carry = tw_pw / 10;
			}
		}
		for( j=10; j>=0; j-- )
			System.out.print(a[j]);
	}
}

//275808739992577