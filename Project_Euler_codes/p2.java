public class p2
{
	public static void main(String[] args)
	{
		int n1=0, n2=1, temp;
		long sum=0;
		while(n1<=4000000)
		{
			if( n1 %2 == 0)
				sum+=n1;
			temp=n2;
			n2=n2+n1;
			n1=temp;
			
		}
		System.out.print(sum);
	}
}