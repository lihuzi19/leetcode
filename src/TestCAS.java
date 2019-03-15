/**
 * @author lining
 * @version 1.0
 * @create 2019-01-07 13:57
 * 描述:
 */
public class TestCAS {

    private int i;
    private volatile boolean casing;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int j = 0; j < 200; j++) {
                casadd();
            }
            System.out.println(i);
        }
    };

    private void casadd() {

    }

    public static void main(String[] args) {
//        TestCAS c = new TestCAS();
//        c.init();
        TestHashCode.main(null);
    }

    private void init() {
        i = 0;
        casing = false;
        for (int i = 0; i < 1000; i++) {
            new Thread(runnable).start();
        }
    }
}
