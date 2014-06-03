public class p7
{
	public static void main(String[] args)
	{
		int count, i, j, f;
		count = 1;
		for(i=3; ;i+=2 )
		{
			f=1;
			for( j=3; j<=(int)Math.sqrt(i); j+=2)
			{
				if(i%j==0)
				{
					f=0;
					break;
				}
			}
			if(f==1)
				count++;
			if( count == 10001 )
				break;
		}
		System.out.print(i);
	}
}