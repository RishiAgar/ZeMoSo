/**
 * Created by rishi on 19/12/14.
 */
public class BinaryTree {
    
    BinaryTree right;
    BinaryTree left;
    int key;
    
    public BinaryTree( int key) {

        this.key = key;
        right = null;
        left = null;
    }
    
    public void setRight( BinaryTree parent, int key ) {

        parent.right = new BinaryTree(key);
    }
    
    public void setLeft( BinaryTree parent, int key ) {
        
        parent.left = new BinaryTree(key);
    }
    
    public static void main( String args[]) {
        
        
    }
}