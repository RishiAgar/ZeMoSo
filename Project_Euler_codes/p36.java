public class p36
{
	public static void main(String args[])
	{
		int i, sum=0;
		String num, rev;
		for( i=1; i<1000000; i+=2 )
		{
			num = Integer.toString(i);
			rev = new StringBuffer(num).reverse().toString();
			if( num.equals(rev) )
			{
				num = Integer.toString(i,2);
				rev = new StringBuffer(num).reverse().toString();
				if( num.equals(rev) )
					sum += i;
			}
		}
		System.out.println(sum);
	}
}