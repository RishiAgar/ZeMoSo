package mine;

import java.awt.*;
public class p220_BruteForce
{
    
    public static void main(String[] args)
    {
        String s = "Fa";
        String a = "aRbFR";
        String b = "LFaLb";
        int k=1;
        int i;
        while( k++<=10)
        {
            for( i=0; i<s.length(); i++ )
            {
                if( s.charAt(i) == 'a')
                {
                    s = s.substring(0, i) + a + s.substring(i+1);
                    i+=5;
                }
                else if( s.charAt(i) == 'b')
                {
                    s = s.substring(0, i) + b + s.substring(i+1);
                    i+=5;
                }
            }
            System.out.println(s);
        }
        temp obj = new temp();
    }
}


/*
long maxSteps = (long)Math.pow(10, 12);
        maxSteps -= (long)Math.pow(2, i-1);
        Point pos = a[i-1];
        int k=7;
        i=38;
        while( true)
        {
            maxSteps -= Math.pow(2, i);
            if( maxSteps < 0 )
            {
                maxSteps += Math.pow(2,i);
                i--;
                continue;
            }
            else if( maxSteps == 0 )
                break;
            pos.x -=a[i].x;
            pos.y -= a[i].y;
        }
        System.out.println(pos.x + "," + pos.y +" "+i);
*/