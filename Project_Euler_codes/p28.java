public class p28
{
	public static void main(String args[])
	{
		int i, a=1, b, c, d, prev=0, sum=1;
		for( i=1; a!=1001*1001; i++)
		{
			a = 1 + prev + 8*i;
			prev = a-1;
			sum += (4*a) - 12*i;
		}
		System.out.println(sum);
	}
}