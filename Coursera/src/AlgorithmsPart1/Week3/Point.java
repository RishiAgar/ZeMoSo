
package AlgorithmsPart1.Week3;

import java.util.*;
import algs4.*;

public class Point implements Comparable<Point>
{
    private class SlopeOrder implements Comparator<Point>
    {
        @Override
        public int compare( Point p1, Point p2)
        {
            if (p1 == null)
                throw new java.lang.RuntimeException();
            if (p2 == null)
                throw new java.lang.RuntimeException();
            final double slope1 = slopeTo(p1);
            final double slope2 = slopeTo(p2);
            if (slope1 < slope2)
                return -1;
            if (slope1 > slope2)
                return +1;
            return 0;
        }
    }
    public Comparator<Point> SLOPE_ORDER = new SlopeOrder();
    private int x, y;
    public Point( int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo( Point p)
    {
        if (p == null)
            throw new java.lang.RuntimeException();
        if (y < p.y || y == p.y && x < p.x)
            return -1;
        if (y > p.y || x > p.x)
            return +1;
        return 0;
    }
    public void draw()
    {
        StdDraw.point(x, y);
    }
    public void drawTo( Point p)
    {
        StdDraw.line(x, y, p.x, p.y);
    }
    public double slopeTo( Point p)
    {
        if (p == null)
            throw new java.lang.RuntimeException();
        double Y_axis = p.y - y;
        double X_axis = p.x - x;
        if (X_axis == 0 && Y_axis == 0)
            return Double.NEGATIVE_INFINITY;
        if (X_axis == 0)
            return Double.POSITIVE_INFINITY;
        if (Y_axis == 0)
            return +0.0;
        return Y_axis / X_axis;
    }
    @Override
    public String toString()
    {
        String s = "(" + x + ", " + y + ")";
        return s;
    }
}