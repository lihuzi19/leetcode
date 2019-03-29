import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author lining
 * @version 1.0
 * @create 2019-03-26 17:18
 * 描述:
 */
public class TestForeach {

    public static void main(String[] args) {
        int len = 20000000;
        LinkedList<String> a = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            a.add(i + "");
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            String b = a.get(i);
        }
        long for1 = System.currentTimeMillis();
        for (String i : a) {
            String b = i;
        }
        long for2 = System.currentTimeMillis();
        System.out.println(start - for1);
        System.out.println(for1 - for2);
    }
}
