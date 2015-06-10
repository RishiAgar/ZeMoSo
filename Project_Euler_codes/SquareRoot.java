import java.math.*;
import java.util.*;

public class SquareRoot {

  public static void main(String[] args) {
    BigDecimal num = new BigDecimal("2");
    MathContext precision = new MathContext(102,RoundingMode.HALF_UP);
    System.out.println(bigSqrt( num, precision));
  }

  public static BigDecimal bigSqrt(BigDecimal squarD, MathContext rootMC) {
    BigDecimal TWO = new BigDecimal(2);
    double SQRT_10 = 3.162277660168379332;
    int sign = squarD.signum();
    if(sign == -1) {
      throw new ArithmeticException("\nSquare root of a negative number: " + squarD);
    } else if(sign == 0) {
      return squarD.round(rootMC);
    }
    int prec = rootMC.getPrecision();
    int BITS = 62;
    int nInit = 16;
    MathContext nMC = new MathContext(18, RoundingMode.HALF_DOWN);
    BigDecimal x = null, e = null;
    BigDecimal v = null, g = null;
    BigInteger bi = squarD.unscaledValue();
    int biLen = bi.bitLength();
    int shift = Math.max(0, biLen - BITS + (biLen%2 == 0 ? 0 : 1));
    bi = bi.shiftRight(shift);
    double root = Math.sqrt(bi.doubleValue());
    BigDecimal halfBack = new BigDecimal(BigInteger.ONE.shiftLeft(shift/2));
    int scale = squarD.scale();
    if(scale % 2 == 1) {
      root *= SQRT_10;
    }
    scale = (int)Math.floor(scale/2.);
    x = new BigDecimal(root, nMC);
    x = x.multiply(halfBack, nMC);
    if(scale != 0) {
      x = x.movePointLeft(scale);
    }
    if(prec < nInit) {
      return x.round(rootMC);
    }
    v = BigDecimal.ONE.divide(TWO.multiply(x), nMC);
    ArrayList<Integer> nPrecs = new ArrayList<Integer>();
    for(int m = prec+1; m > nInit; m = m/2 + (m > 100 ? 1 : 2)) {
      nPrecs.add(m);
    }
    for(int i = nPrecs.size()-1; i > -1; i--) {
      nMC = new MathContext(nPrecs.get(i), (i%2 == 1) ? RoundingMode.HALF_UP : RoundingMode.HALF_DOWN);
      e = squarD.subtract(x.multiply(x, nMC), nMC);
      if(i != 0) {
        x = x.add(e.multiply(v, nMC));
      } else {
        x = x.add(e.multiply(v, rootMC), rootMC);
        break;
      }
      g = BigDecimal.ONE.subtract(TWO.multiply(x).multiply(v, nMC));
      v = v.add(g.multiply(v, nMC));
    }
    return x;
  }
}