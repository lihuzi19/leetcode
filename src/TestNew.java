import java.lang.reflect.Constructor;

/**
 * @author lining
 * @version 1.0
 * @create 2019-03-28 13:46
 * 描述:
 */
public class TestNew {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("TestNewClassInstance");
            Constructor cons = null;
            cons = clazz.getDeclaredConstructor(String.class);

            //set accessble to access private constructor
            cons.setAccessible(true);
            Object onj = cons.newInstance("hello");
            ((TestNewClassInstance) onj).helol();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
