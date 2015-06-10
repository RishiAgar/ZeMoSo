import java.math.*;

public class p80 {
  public static void main(String[] args) {
    int sum = 0, max_num = 100, max_digits = 100;
    SquareRoot sqrt = new SquareRoot();
    MathContext precision = new MathContext(200, RoundingMode.HALF_UP);
    for( int i = 2; i <= max_num; i++) {
      if( Math.ceil(Math.sqrt(i)) == Math.floor(Math.sqrt(i))) {
        continue;
      }
      BigDecimal num = new BigDecimal( i + "");
      String s = sqrt.bigSqrt( num, precision).toString();
      boolean flag_dot = false;
      int count = 0;
      for( int j = 0; j < s.length(); j++) {
        char ch = s.charAt(j);
        if( ch == '.') {
          continue;
        }
        count++;
        if( count > max_digits) {
          break;
        }
        sum += Integer.parseInt(ch + "");
      }
    }
    System.out.println(sum);
  }
}