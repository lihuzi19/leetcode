import java.math.BigDecimal;

/**
 * @author lining
 * @version 1.0
 * @create 2019-01-16 11:44
 * 描述:
 */
public class lhzcalc {

    public static void main(String[] args) {
        calc2();
    }

    private static void calc1() {
        int i1 = 15 & 8;
        int i2 = 15 & 9;
        System.out.println("15 & 8 = " + IntegerToString(i1));
        System.out.println("15 & 9 = " + IntegerToString(i2));
        System.out.println("15 " + IntegerToString(15));
        System.out.println("8 " + IntegerToString(8));
        System.out.println("9 " + IntegerToString(9));
    }

    private static String IntegerToString(int i) {
        return Integer.toBinaryString(i);
    }

    private static void calc2() {
        float f = 8.9f;
        BigDecimal bd1 = new BigDecimal(String.valueOf(f));
        BigDecimal bd2 = new BigDecimal(String.valueOf(100f));
        int a = (int) (bd1.multiply(bd2).floatValue());
        System.out.println(a);
    }
}
