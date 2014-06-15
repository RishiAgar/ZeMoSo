
package AlgorithmsPart1.Week2;

import java.util.*;
import algs4.*;

public class Deque<Item> implements Iterable<Item>
{
    class Node
    {
        public Node(Item i)
        {
            item = i;
	}
        Item item;
        Node next;
        Node prev;
    }
    int size;
    Node start;
    public Deque()
    {
        start = new Node(null);
	start.next = start;
	start.prev = start;
	size = 0;
    }
    public boolean isEmpty()
    {
        return size <= 0;
    }
    public int size()
    {
        return size;
    }
    public void addFirst(Item item)
    {
        if (item == null)
            throw new NullPointerException();
	Node newNode = new Node(item);
	newNode.prev = start.next;
	newNode.next = start;
	start.next.next = newNode;
	start.next = newNode;
	if (start.prev == start)
            start.prev = newNode;
	size++;
    }
    public void addLast(Item item)
    {
        if (item == null)
            throw new NullPointerException("Can't add null item!");
        Node newNode = new Node(item);
        newNode.next = start.prev;
        newNode.prev = start;
        start.prev.prev = newNode;
        start.prev = newNode;
        if (start.next == start)
            start.next = newNode;
	size++;
    }
    public Item removeFirst()
    {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty!");
	Item item = start.next.item;
            start.next.item = null;
            if (start.next.prev == start)
            {
                start.next = start;
                start.prev = start;
            }
            else
            {
                start.next.prev.next = start;
                start.next = start.next.prev;
            }
            size--;
            return item;
    }
    public Item removeLast() 
    {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty!");
        Item item = start.prev.item;
        start.prev.item = null;
        if (start.prev.next == start)
        {
            start.prev = start;
            start.next = start;
        }
        else
        {
            start.prev.next.prev = start;
            start.prev = start.prev.next;
        }
        size--;
        return item;
    }
    @Override
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item>
    {
        private Node current = start.next;
        @Override
        public boolean hasNext()
        {
            return current != start;
        }
        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
        @Override
        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.prev;
            return item;
        }
    }
    public static void main(String[] args)
    {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("1");
        deque.addFirst("2");
        StdOut.println(deque.removeLast());
        deque.addFirst("3");
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeLast());
        deque.addFirst("4");
        StdOut.println(deque.removeLast());
    }
}