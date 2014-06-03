public class p24
{
	static int[] a = new int [10];
	public boolean check(int n)
	{
		int i;
		for(i=0; i<10; i++ )
			if( n == a[i] )
				return true;
		return false;
	}
	public static void main(String[] args)
	{
		p24 obj = new p24();
		int pro=1, limit = 1000000, sum = 0, i=0,j, n;
		for( ; i<10; i++ )
			a[i]=-1;
		for( i=2; i<10; i++ )
			pro *= i;
		for( i=0; i<10; i++ )
		{
			n = (limit-sum)/pro;
			sum = sum + (n * pro);
			
			for( j=0; j<=n; j++)
				if( obj.check(j) == true)
						n++;
			a[i] = n;
			if( i < 9)
				pro = pro / (9-i);
		}
		for( i=0; i<10; i++ )
			System.out.print(a[i]);
	}
}