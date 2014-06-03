public class p9
{
	public static void main(String[] args)
	{
		int abc, i;
		float a, b, c, temp;
		for( i=500; i>=1; i-- )
		{
			b=(float)i;
			a=500*(1000-2*b)/(1000-b);
			if( a> 1000 || a<1)
				continue;
			temp=(int)a;
			if(temp == a )
			{
				c=1000-a-b;
				if( c>a && c>b && a!=b )
				{
					abc=(int)(a*b*c);
					System.out.print(abc);
					break;
				}
			}
		}
	}
}