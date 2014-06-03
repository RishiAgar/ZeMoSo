public class p45
{
    public static void main(String[] args)
	{
		int i, j;
		//Every hexagonal number is triangular number
		//Using Pells equation
		//x^2 - 3*y^2 = -2
		long x2=0, y,a ;
		for( y=143*50+1; y<1000000; y++ )
		{
			x2 = -2 + 3*y*y;
			a = (int)Math.sqrt(x2);
			a=a*a;
			if( a == x2)
				if( (y+1) %4 ==0 )
					break;
		}
		y=(y+1)/4;
		System.out.println(y*((2*y)-1) );
	}
}