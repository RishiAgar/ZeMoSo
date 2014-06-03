import java.io.*;
public class p48
{
	public unsigned long pow(int a,int b)
	{
		unsigned long s=10000000000;
		if(b == 0)
			return 1; 
		else if(b %2 == 0)
		{
			unsigned long ret = pow(a,b/2);
			return (ret*ret)%s;
		}
		else
		{
			unsigned long ret = pow(a,(b-1)/2);
			return (((ret*ret)%s)*a)%s;
		}
	}
	public static void main(String[] args)throws IOException
	{
		unsigned long a=10000000000;
		p48 obj = new p48();
		for(int i=1;i<=1000;i++)
			ans = (ans + obj.pow(i,i))%(a);
		System.out.println(ans);
	}
}