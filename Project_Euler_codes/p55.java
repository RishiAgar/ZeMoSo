import java.util.*;
import java.math.*;
public class p55
{
	public boolean  isPalindrome( BigInteger a)
	{
		String s = a+"";
		String sub1 = s.substring(0, s.length()/2);;
		String sub2;
		if( s.length()%2 == 0 )
			sub2 = s.substring( s.length()/2);
		else
			sub2 = s.substring( s.length()/2+1);
		return sub1.equals(new StringBuilder(sub2).reverse().toString());
	}
	public static void main(String args[])
	{
		p55 obj = new p55();
		int i, k;
		BigInteger sum;
		boolean flag;
		int count=0;
		byte[] a = new byte[1000000];
		for( i=0; i<a.length; i++ )
			a[i]=0;
		for( i=11; i<10000; i++ )
		{
			k=0;
			List<Long> list = new ArrayList<>();
			sum=BigInteger.valueOf(i);
			flag= true;
			while( k++<50)
			{
				if( sum.compareTo(BigInteger.valueOf(a.length)) == -1)
				{
					list.add(sum.longValue());
					if( a[sum.intValue()] == 1 )
					{
						flag=false;
						break;
					}
				}
				sum = sum .add(new BigInteger(new StringBuilder(sum+"").reverse().toString()));
				if( obj.isPalindrome(sum) )
				{
					flag=false;
					break;
				}
			}
			if( flag )
			{
				System.out.print(i+ "  ");
				count++;
			}
			else
				for ( long j : list)
					if( j < (long)a.length )
						a[(int)j]=1;
		}
		System.out.println(count);
	}
}