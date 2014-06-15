
package AlgorithmsPart1.Week5;

import algs4.*;

public class PointSET
{
    public final SET<Point2D> set;
    public PointSET()
    {
        set = new SET<Point2D>();
    }
    public boolean contains(final Point2D p)
    {
        return set.contains(p);
    }
    public void draw()
    {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
        for (final Point2D p : set)
            p.draw();
    }
    public void insert(final Point2D p)
    {
        if (!set.contains(p))
            set.add(p);
    }
    public boolean isEmpty()
    {
        return set.isEmpty();
    }
    public Point2D nearest(final Point2D p)
    {
        if (isEmpty())
            return null;
        Point2D nearest = set.min();
        for (final Point2D q : set)
            if (p.distanceSquaredTo(q) < p.distanceSquaredTo(nearest))
                nearest = q;
        return nearest;
    }
    public Iterable<Point2D> range(final RectHV rect)
    {
        final Queue<Point2D> queue = new Queue<Point2D>();
        if (rect == null || isEmpty())
            return queue;
        for (final Point2D p : set)
            if (rect.contains(p))
                queue.enqueue(p);
        return queue;
    }
    public int size()
    {
        return set.size();
    }
}