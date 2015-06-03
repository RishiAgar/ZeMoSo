public class recusrsion {
	public void func( int c) {
		if(c == 0)
	     return;
		else {
	       	System.out.println(""+c);
	       	func(--c);
		}
	}

	public static void main(String[] args) {
		
		new recusrsion().func(10);
	}
}