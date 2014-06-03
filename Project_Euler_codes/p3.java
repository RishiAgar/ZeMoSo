public class p3
{
	public static void main(String[] args)
	{
		long i, j;
		int f=1;
		double num;
		num=600851475143.0;
		long sq=(long)Math.sqrt(num);
		if(sq%2==0)
			sq--;
		for( i=sq; i>=3; i-=2)
		{
			if(num%i==0)
			{
				if( i%2!=0)
				{
					for(j=3; j<=(long)Math.sqrt(i); j+=2 )
					{
						if(i%j == 0)
						{
							f=0;
							break;
						}
					}
				}
				else
					f=0;
				if(f==1)
				{
					System.out.print(i);
					break;
				}
				f=1;
			}
		}
	}
}