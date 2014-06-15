
package AlgorithmsPart1.Week3;

import algs4.*;

public class Brute
{
    public static boolean isLine(Point p, Point q, Point r, Point s)
    {
        double slope = p.slopeTo(q);
        if( p.slopeTo(r) == slope && p.slopeTo(s) == slope)
            return true;
        else
            return false;
    }
    public static void main(String[] args)
    {
        int i, j, k, l, x, y, N, scale=32768;
        StdDraw.setXscale(0, scale);
        StdDraw.setYscale(0, scale);
        StdDraw.show(0);
        In in = new In(args[0]);
        N = in.readInt();
        Point[] points = new Point[N];
        for (i = 0; i < N; i++)
        {
            x = in.readInt();
            y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }
        Quick.sort(points);
        for ( i=0; i<=N-4; i++ )
            for ( j=i+1; j<=N-3; j++ )
                for ( k=j+1; k<=N-2; k++ )
                    for ( l=k+1; l<=N-1; l++ )
                        if (isLine(points[i], points[j], points[k], points[l]))
                        {
                            StdOut.print(points[i] + " -> ");
                            StdOut.print(points[j] + " -> ");
                            StdOut.print(points[k] + " -> ");
                            StdOut.print(points[l] + "\n");
                            points[i].drawTo(points[l]);
                        }
        StdDraw.show(0);
    }
}