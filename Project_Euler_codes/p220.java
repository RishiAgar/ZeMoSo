

import java.awt.*;
public class p220
{
	private long steps = 0;
	private char ch = ' ';
	Point p = new Point(0,0);
	public void func( String s, int n, int direction)
	{
		for( int i=0; i<s.length(); i++)
		{
			ch = s.charAt(i);
			if( ch == 'F' )
			{
				switch(direction)
				{
					case 1:
						p.translate(0, 1);
						break;
					case 2:
						p.translate(1, 0);
						break;
					case 3:
						p.translate(0, -1);
						break;
					case 4:
						p.translate(-1, 0);
						break;
				}
				steps++;
			}
			else if( ch == 'R' )
			{
				direction = direction + 1;
				if( direction > 4 )
					direction = 1;
			}
			else if( ch == 'L' )
			{
				direction = direction - 1;
				if( direction < 1 )
					direction = 4;
			}
			
			else if( ch == 'a')
			{
				if( n <50)
					func("aRbFR", n+1, direction);
			}
			else if( ch == 'b' )
			{
				if( n <50)
					func("LFaLb", n+1, direction);
			}
			if( steps == 500)
			{
				System.out.println(p.getLocation());
				System.exit(0);
			}
		}
	}
	public static void main(String[] args)
	{
		String s = "Fa";
		new p220().func(s, 1, 1);
	}
}
