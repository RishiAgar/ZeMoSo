
package AlgorithmsPart1.Week5;

import java.util.*;
import algs4.*;

public class KdTree
{
    public static final boolean HORIZONTAL = true;
    public static class Node
    {
        public Point2D point;
        public RectHV rect;
        public Node left;
        public Node right;
        public Node(Point2D p, RectHV rect)
        {
            this.point = p;
            this.rect = rect;
        }
    }
    public Node root;
    public int size = 0;
    public boolean isEmpty()
    {
        return root == null;
    }
    public int size()
    {
        return size;
    }
    public void insert(Point2D p)
    {
        root = insert(root, null, p, HORIZONTAL);
    }
    public Node insert(Node node, Node parentNode, Point2D p, boolean orient)
    {
        if (node == null)
        {
            size++;
            double rectXmin = 0.0;
            double rectXmax = 1.0;
            double rectYmin = 0.0;
            double rectYmax = 1.0;
            if (parentNode != null)
            {
                if (HORIZONTAL == orient)
                {
                    rectXmin = parentNode.rect.xmin();
                    rectXmax = parentNode.rect.xmax();
                    if (p.y() < parentNode.point.y())
                    {
                        rectYmin = parentNode.rect.ymin();
                        rectYmax = parentNode.point.y();
                    }
                    else if (p.y() > parentNode.point.y())
                    {
                        rectYmin = parentNode.point.y();
                        rectYmax = parentNode.rect.ymax();
                    }
                }
                else
                {
                    rectYmax = parentNode.rect.ymax();
                    rectYmin = parentNode.rect.ymin();
                    if (p.x() < parentNode.point.x())
                    {
                        rectXmin = parentNode.rect.xmin();
                        rectXmax = parentNode.point.x();
                    }
                    else if (p.x() > parentNode.point.x())
                    {
                        rectXmin = parentNode.point.x();
                        rectXmax = parentNode.rect.xmax();
                    }
                }
            }
            return new Node(p, new RectHV(rectXmin, rectYmin, rectXmax, rectYmax));
        }
        double newKey = HORIZONTAL == orient ? p.x() : p.y();
        double nodeKey = HORIZONTAL == orient ? node.point.x() : node.point.y();
        if(newKey < nodeKey)
            node.left = insert(node.left, node, p, !orient);
        else if(newKey > nodeKey)
            node.right = insert(node.right, node, p, !orient);
        else
        {
            double newValue = HORIZONTAL == orient ? p.y() : p.x();
            double nodeValue = HORIZONTAL == orient ? node.point.y() : node.point.x();
            if (newValue == nodeValue)
            {
                node.point = p;
            }
            else
                node.right = insert(node.right, node, p, !orient);
        }
        return node;
    }
    public boolean contains(Point2D p)
    {
        return get(root, p, HORIZONTAL) != null;
    }
    public Point2D get(Node node, Point2D p, boolean orient)
    {
        if (node == null)
            return null;
        double newKey = HORIZONTAL == orient ? p.x() : p.y();
	double nodeKey = HORIZONTAL == orient ? node.point.x() : node.point.y();
	if (newKey < nodeKey)
            return get(node.left, p, !orient);
        else if (newKey > nodeKey)
            return get(node.right, p, !orient);
        else
        {
            double newValue = HORIZONTAL == orient ? p.y() : p.x();
            double nodeValue = HORIZONTAL == orient ? node.point.y() : node.point.x();
            if (newValue == nodeValue)
                return node.point;
            else
                return get(node.right, p, !orient);
        }
    }
    public void draw()
    {
        drawPoint(root, null, HORIZONTAL);
    }
    public void drawPoint(Node node, Node parentNode, boolean orient)
    {
        if (node == null)
            return;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
        node.point.draw();
        StdDraw.setPenRadius();
        StdDraw.setPenColor(HORIZONTAL == orient ? StdDraw.RED : StdDraw.BLUE);
        if (HORIZONTAL == orient)
            if (parentNode != null)
            {
                if (node.point.y() < parentNode.point.y())
                    new Point2D(node.point.x(), 0.0).drawTo(new Point2D(node.point.x(), parentNode.point.y()));
                else if (node.point.y() > parentNode.point.y())
                    new Point2D(node.point.x(), parentNode.point.y()).drawTo(new Point2D(node.point.x(), 1.0));
            }
            else
                new Point2D(node.point.x(), 0.0).drawTo(new Point2D(node.point.x(), 1.0));
        else
            if (parentNode != null)
            {
                if (node.point.x() < parentNode.point.x())
                    new Point2D(0.0, node.point.y()).drawTo(new Point2D(parentNode.point.x(), node.point.y()));
                else if (node.point.x() > parentNode.point.x())
                    new Point2D(parentNode.point.x(), node.point.y()).drawTo(new Point2D(1.0, node.point.y()));
            }
            else
                new Point2D(0.0, node.point.y()).drawTo(new Point2D(1.0,node.point.y()));
        drawPoint(node.left, node, !orient);
        drawPoint(node.right, node, !orient);
    }
    public Iterable<Point2D> range(RectHV rect)
    {
        Set<Point2D> result = new HashSet<Point2D>();
        rangeSearch(root, rect, result);
        return result;
    }
    public void rangeSearch(Node node, RectHV rect, Set<Point2D> result)
    {
        if (node == null || !rect.intersects(node.rect))
            return;
        if (rectContainsPoint(rect, node.point))
            result.add(node.point);
        rangeSearch(node.left, rect, result);
        rangeSearch(node.right, rect, result);
    }
    public static boolean rectContainsPoint(RectHV rect, Point2D point)
    {
        double pX = point.x();
        double pY = point.y();
        if (pX >= rect.xmin() && pX <= rect.xmax() && pY >= rect.ymin()&& pY <= rect.ymax())
            return true;
        return false;
    }
    public Point2D nearest;
    public Point2D nearest(Point2D p)
    {
        nearest = root.point;
        nearestSearch(root, p, HORIZONTAL);
        return nearest;
    }
    public void nearestSearch(Node node, Point2D queryPoint, boolean orient)
    {
        if (node == null)
            return;
        double distanceToFoundSoFar = nearest.distanceSquaredTo(queryPoint);
        double distanceToCurNodeRect = node.rect.distanceSquaredTo(queryPoint);
        if (distanceToFoundSoFar < distanceToCurNodeRect)
            return;
        else
            if (nearest.distanceSquaredTo(queryPoint) > node.point.distanceSquaredTo(queryPoint))
                nearest = node.point;
        Node firstNode = null;
        Node secondNode = null;
        if (HORIZONTAL == orient)
            if (queryPoint.x() < node.point.x())
            {
                firstNode = node.left;
                secondNode = node.right;
            }
            else
            {
                firstNode = node.right;
                secondNode = node.left;
            }
        else
            if (queryPoint.y() < node.point.y())
            {
                firstNode = node.left;
                secondNode = node.right;
            }
            else
            {
                firstNode = node.right;
                secondNode = node.left;
            }
        nearestSearch(firstNode, queryPoint, !orient);
        nearestSearch(secondNode, queryPoint, !orient);
    }
}
