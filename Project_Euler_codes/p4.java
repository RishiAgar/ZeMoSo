public class p4
{
	public static void main(String[] args)
	{
		int i, j , pro, temp, sum,a;
		int max=0;
		for(i =999;i>=100; i--)
		{
			for(j = 999;j>=100; j--)
			{
				pro=i*j;
				temp=pro;
				sum=0;
				while(temp!=0)
				{
					a=temp%10;
					temp=temp/10;
					sum=sum*10+a;
				}
				if(sum == pro)
				{
					if(max<pro)
						max=pro;
				}
			}
		}
		System.out.print(max);
	}
}