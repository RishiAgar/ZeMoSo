public class p10
{
	public boolean prime(int n)
	{
		int i;
		if (n==2)
			return true;
		if ( n%2==0)
			return false;
		for( i=3; i<=(int)Math.sqrt(n); i+=2)
			if( n%i==0)
				return false;
		return true;
	}
	public void func()
	{
		int i;
		long sum=2;
		for(i=3; i<2000000; i+=2)
		{
			if(prime(i) == true )
				sum+=i;
		}
		System.out.println(sum);
	}
	public static void main(String[] args)
	{
		p10 obj= new p10();
		obj.func();
	}
}