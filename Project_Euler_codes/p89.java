public class p89 {
	public static void main(String[] args) {
		String s = "IIIIIIIIIIIIIIII";
		int value = getValue(s);
		System.out.println(value);
		System.out.println(getRoman(value));	
	}

	public static int getValue(String s) {

		char ch;
		int sum = 0;
		for( int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			switch(ch) {
				case 'M':
					sum += 1000;
					break;
				case 'D':
					sum += 500;
					break;
				case 'C':
					sum += 100;
					break;
				case 'L':
					sum += 50;
					break;
				case 'X':
					sum += 10;
					break;
				case 'V':
					sum += 5;
					break;
				case 'I':
					sum += 1;
					break;
				default:
					System.out.println("Something went wrong!");
			}
		}
		return sum;
	}

	public static String getRoman(int value) {
		String s = "";
		while(value != 0) {
			if( value>1000) {
				value -= 1000;
				s += "M";
			} else if( value >= 500) {
				value -= 500;
				s += "D";
			} else if( value >= 100) {
				value -= 100;
				s += "C";
			} else if( value >= 50) {
				value -= 50;
				s += "L";
			} else if( value >= 10) {
				value -= 10;
				s += "X";
			} else if( value >= 5) {
				value -= 5;
				s += "V";
			} else if( value >= 1) {
				value -= 1;
				s += "I";
			} else if( value == 0) {
				break;
			} else {
				System.out.println("Some problem occured");
				break;
			}
		}
		return s;
	}
}