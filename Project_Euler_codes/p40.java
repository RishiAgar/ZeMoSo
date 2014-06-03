public class p40
{
	public int func(int i)
	{
		if( i<10)
			return 1;
		if( i<100)
			return 2;
		if( i<1000)
			return 3;
		if( i<10000)
			return 4;
		if( i<100000)
			return 5;
		if( i<1000000)
			return 6;
		if( i<10000000)
			return 7 ;
		return 0;
	}
	public static void main(String args[])
	{
		p40 obj = new p40();
		int count =0, k = 0, pro=1, s=0, temp, j, i, b, n;
		int a[] ={10, 100, 1000, 10000, 100000, 1000000};
		for( i=1; ; i++ )
		{
			n = obj.func(i);
			count = count + n;
			if( count == a[k] )
			{
				
				pro = pro * ( i % 10 );
				k++;
			}
			else if( count > a[k])
			{
				s = count;
				count = count - n;
				temp = i;
				j=n-1;
				while( j!=-1)
				{
					b = temp / (int)Math.pow( 10, j);
					temp = temp - b*(int)Math.pow( 10, j);
					j--;
					count++;
					if( count == a[k] )
					{
						pro = pro * b;
						count = s;
						k++;
						break;
					}
				}
			}
			if( count >=1000005)
				break;
		}
		System.out.println(pro);
	}
}