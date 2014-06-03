public class p5
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
	public int LCM(int a, int b)
	{
		int i, pro=1, temp=a;
		for(i =2; i<=(int)Math.sqrt(a);)
		{
			if( prime(i) == true )
			{
				if( a==0)
				{
					a=1;
					break;
				}
				if( b==0 )
				{
					b=1;
					break;
				}
				if(a%i==0 && b%i==0)
				{
					pro=pro*i;
					a=a/i;
					b=b/i;
				}
				else
					i++;
			}
			else
				i++;
		}
		System.out.println(a+" "+b+" "+pro);
		pro=pro*a*b;
		
		return pro;
	}
	public void func()
	{
		int i, s=2520;

		for(i=11; i<=20 ;i++ )
		{

			if(s%i==0)
				continue;
			else if(prime(i)==true)
			{
				s=s*i;
				continue;
			}
			else
				s=LCM(i,s);
			
		}
		System.out.print(s);
		
	}
	public static void main(String[] args)
	{
		p5 obj= new p5();
		obj.func();
	}
}