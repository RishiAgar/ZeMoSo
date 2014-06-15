/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsPart1.Week2;

import java.util.*;


public class deque2<Item> implements Iterable<Item>
{
    class Node
    {
        Item item;
        Node prev;
        Node next;
        Node( Item item)
        {
            this.item = item;
            prev = null;
            next = null;
        }
                
    }
    Node first;
    Node last;
    int size;
    deque2()
    {
        first = new Node(null);
        last = new Node(null);
        last.prev = null;
        last.next = null;
        first = last;
        size=0;
    }
    public boolean isEmpty()
    {
        if( size() == 0 )
            return true;
        return false;
    }
    public int size()
    {
        return size;
    }
    public void addFirst(Item item)
    {
        if( size() == 0)
        {
            first.item = item;
            last.item = item;
            size++;
            return;
        }
        Node temp = new Node(item);
        temp.prev = null;
        temp.next = first;
        first.prev = temp;
        first = temp;
        size++;
    }
    public void addLast(Item item)
    {
        if( size() == 0)
        {
            first.item = item;
            last.item = item;
        }
        Node temp = new Node(item);
        temp.next = null;
        last.next = temp;
        temp.prev = last;
        last = temp;
        size++;
    }
    public Item removeFirst()
    {
        if( size() == 0 )
            throw new NullPointerException();
        Item item = first.item;
        Node temp = first.next;
        first.next.prev = null;
        first = temp;
        temp = null;
        size--;
        return item;
    }
    public Item removeLast()
    {
        if( size() == 0 )
            throw new NullPointerException();
        Item item = last.item;
        Node temp = last.prev;
        last.prev.next = null;
        last = temp;
        temp = null;
        size--;
        return item;
    }
    public static void main(String args[])
    {
        deque2 obj = new deque2();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public Iterator<Item> iterator()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
