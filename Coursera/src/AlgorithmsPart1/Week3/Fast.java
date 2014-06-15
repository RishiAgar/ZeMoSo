
package AlgorithmsPart1.Week3;

import algs4.*;
import java.util.*;

public class Fast
{
    private static boolean alreadyDone(Point[] a, int N, Point p, double slp)
    {
        int i;
        for ( i = N; i>= 0; i--)
            if (p.slopeTo(a[i]) == slp)
                return true;
        return false;
    }
    public static void main(String[] args)
    {
        int i, j, k, x, y, N, size;
        double slope;
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        In in = new In(args[0]);
        N = in.readInt();
        Point[ ] points = new Point[N];
        for ( i = 0; i < N; i++)
        {
            x = in.readInt();
            y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }
        StdDraw.show(0);
        Arrays.sort(points);
        StringBuilder print = new StringBuilder();
        Point[] slopeOrder;
        Point p;
        for ( i = 0; i < N - 3; i++)
        {
            p = points[i];
            slopeOrder = Arrays.copyOfRange(points, i + 1, N);
            Arrays.sort(slopeOrder, p.SLOPE_ORDER);
            size = 1;
            for ( j = 0; j < slopeOrder.length - 2; j += size, size = 1)
            {
                slope = p.slopeTo(slopeOrder[j]);
                while (j + size < slopeOrder.length && p.slopeTo(slopeOrder[j + size]) == slope)
                    size++;
                if (size < 3 || alreadyDone(points, i, p, slope))
                    continue;
                print.append(p + " -> ");
                for ( k = 0; k < size - 1; k++)
                    print.append(slopeOrder[j + k] + " -> ");
                print.append(slopeOrder[j + size - 1] + "\n");
                p.drawTo(slopeOrder[j + size - 1]);
                StdDraw.show(0);
            }
        }
        StdOut.print(print);
        StdDraw.show(0);
    }
}