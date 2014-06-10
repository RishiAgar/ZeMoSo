
package mine;

import java.util.*;

public class p220 
{
    public static class Point
    {
        long x=0;
        long y=0;
        byte quad=1;
    }
    public Point func(Point a)
    {
        
        return a;
    }
    public static void main(String args[])
    {
        int i;
        Point[] a = new Point[50];
        for( i=0; i<50; i++)
            a[i] = new Point();
        Point[] b = new Point[50];
        for( i=0; i<50; i++)
            b[i] = new Point();
        a[1].x = 1;
        a[1].y = 1;
        a[1].quad = 1;
        i=1;
        while( i<45)
        {
            if( a[i].quad == 1)
            {
                a[i+1].x = a[i].x + a[i].y;
                a[i+1].y = 0;
                a[i+1].quad = 2;
            }
            else if( a[i].quad == 2)
            {
                a[i+1].y = -a[i].x;
                a[i+1].x = a[i].x;
                a[i+1].quad = 3;
            }
            else if( a[i].quad == 3)
            {
                a[i+1].x = 0;
                a[i+1].y = a[i].y*2;
                a[i+1].quad = 4;
            }
            else if( a[i].quad == 4)
            {
                a[i+1].x = a[i].y ;
                a[i+1].y = a[i].y;
                a[i+1].quad = 5;
            }
            else if( a[i].quad == 5)
            {
                a[i+1].x = a[i].x*2;
                a[i+1].y = 0;
                a[i+1].quad = 6;
            }
            else if( a[i].quad == 6)
            {
                a[i+1].y = -a[i].x;
                a[i+1].x = a[i].x;
                a[i+1].quad = 7;
            }
            else if( a[i].quad == 7)
            {
                a[i+1].x = 0;
                a[i+1].y = a[i].y*2;
                a[i+1].quad = 8;
            }
            else if( a[i].quad == 8)
            {
                a[i+1].x = a[i].y;
                a[i+1].y = a[i].y;
                a[i+1].quad = 1;
            }
            System.out.println(i +" " + a[i].quad+" "+Math.pow(2, i) + "  " + a[i].x + " , " + a[i].y);
            i++;
            //System.out.println(i +" " + a[i].quad+" "+Math.pow(2, i) + "  " + a[i].x + " , " + a[i].y);
        }
        b[1].x = -1;
        b[1].y = -1;
        b[1].quad = 5;
        i=1;
        while( i<45)
        {
            if( b[i].quad == 1)
            {
                b[i+1].x = b[i].x + b[i].y;
                b[i+1].y = 0;
                b[i+1].quad = 2;
            }
            else if( b[i].quad == 2)
            {
                b[i+1].y = -b[i].x;
                b[i+1].x = b[i].x;
                b[i+1].quad = 3;
            }
            else if( b[i].quad == 3)
            {
                b[i+1].x = 0;
                b[i+1].y = b[i].y*2;
                b[i+1].quad = 4;
            }
            else if( b[i].quad == 4)
            {
                b[i+1].x = b[i].y ;
                b[i+1].y = b[i].y;
                b[i+1].quad = 5;
            }
            else if( b[i].quad == 5)
            {
                b[i+1].x = b[i].x*2;
                b[i+1].y = 0;
                b[i+1].quad = 6;
            }
            else if( b[i].quad == 6)
            {
                b[i+1].y = -b[i].x;
                b[i+1].x = b[i].x;
                b[i+1].quad = 7;
            }
            else if( b[i].quad == 7)
            {
                b[i+1].x = 0;
                b[i+1].y = b[i].y*2;
                b[i+1].quad = 8;
            }
            else if( b[i].quad == 8)
            {
                b[i+1].x = b[i].y;
                b[i+1].y = b[i].y;
                b[i+1].quad = 1;
            }
            System.out.println(i +" " + b[i].quad+" "+Math.pow(2, i) + "  " + b[i].x + " , " + b[i].y);
            i++;
        }
        //a[39].x -=51000+136;
        //a[39].y += 64000;
        i=40;
        long maxSteps = (long) Math.pow(10,12);
        maxSteps -= (long)Math.pow(2, i-1);
        Point pos = new Point();
        pos.x= a[i-1].x;
        pos.y = a[i-1].y;
        System.out.println("--------------------"+pos.x+" "+pos.y + " " + maxSteps);
        i=i-2;
        while( true)
        {
            maxSteps -= (long)Math.pow(2, i);
            if( maxSteps>=0)
                System.out.println(pos.x+" "+pos.y + " " + maxSteps +" " + i );
            if( maxSteps < 0 )
            {
                maxSteps += (long)Math.pow(2,i);
                i--;
                if( i==12)
                    i--;
                continue;
            }
            pos.x +=b[i].x;
            pos.y += b[i].y;
            //139776,963904
            if( maxSteps == 0 )
                break;
        }
        System.out.println(pos.x + "," + pos.y +" "+i);
    }
}