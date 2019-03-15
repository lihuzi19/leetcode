import java.lang.reflect.Field;

/**
 * @author lining
 * @version 1.0
 * @create 2019-01-08 16:34
 * 描述:
 */
public class TestHashCode {

    private static void text() throws Exception {
        String s = "Hello";
        s.intern();
        String s1 = "llo";
        String s2 = "He" + s1;
        String s3 = "Hel" + "lo";
        String s4 = "Hello";
        String s5 = "He" + s1;
        String s6 = s + s1;
        String s7 = "Hellollo";
        System.out.println("s2 == s3:" + (s2 == s3));
        System.out.println("s4 == s2:" + (s4 == s2));
        System.out.println("s4 == s3:" + (s4 == s3));
        System.out.println("s5 == s2:" + (s5 == s2));
        System.out.println("s6 == s7:" + (s6 == s7));

        final String A = "ab";
        final String B = "cd";
        String C = A + B;
        String D = "abcd";
        String E = C.intern();
        Class strClass = E.getClass();
        Field valueField = strClass.getDeclaredField("value");
        valueField.setAccessible(true);
        System.out.println("C == D :" + (C == D));
        System.out.println("C == E :" + (C == E));
        System.out.println("E == D :" + (E == D));
        valueField.set(E, new char[]{'l', 'u', 'e', 'l', 'u', 'e'});
        System.out.println("E == D :" + (E == D));
        System.out.println("C:" + C);

        String F = "abcd";
        System.out.println("F == C: " + (F == C));

        String a = "0123456789";
        String addString = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            addString += i;
            sb.append(i);
        }
        String sbToString = sb.toString();
        System.out.println("a == addString: " + (a == addString));
        System.out.println("a == sbToString: " + (a == sbToString));
    }


    public static void main(String[] args) {
        try {
            text();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        HashMap map = new HashMap();
//        int count = 2500;
//        for (int i = 0; i < count; i++) {
//            map.put("key" + i, "value" + i);
//        }
//        Class cls = map.getClass();
//        try {
//            Field field_table = cls.getDeclaredField("table");
//            field_table.setAccessible(true);
//            Class innernode = Class.forName("java.util.HashMap$Node");
////            HashMap.Entry[] table = (HashMap.Entry[]) field_table.get(map);
//            Field len = innernode.getDeclaredField("value");
//            len.setAccessible(true);
//
//            HashMap.Entry[] table = (HashMap.Entry[]) field_table.get(map);
////            System.out.println("table length: " + table.length);
//            Object tableArray = field_table.get(map);
//            int tablelength = Array.getLength(tableArray);
//            for (int i = 0; i < tablelength; i++) {
//                System.out.print(i);
//                Object objNode = Array.get(tableArray, i);
//                if (objNode == null) {
//                    System.out.println(" null");
//                    continue;
//                } else {
//                    System.out.print("\n");
//                }
//                do {
//                    WrapNode wrapNode = new WrapNode(objNode);
//                    System.out.print(wrapNode.toString());
//                    objNode = wrapNode.next;
//                } while (objNode != null);
//                System.out.print("\n");
//            }
//            System.out.println("table length: " + tablelength);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void init() {
        String s1 = "111";
        String s2 = Integer.toString(111);
        String s3 = new String(new char[]{'1', '1', '1'});
        String s4 = "11" + "1";
        System.out.println(s1 == s2 ? "相等" : "不相等");
        System.out.println(s3 == s2 ? "相等" : "不相等");
        System.out.println(s4 == s1 ? "相等" : "不相等");
    }

    static class WrapNode {
        Object key;
        Object value;
        Object next;

        private WrapNode() {

        }

        static Class node_class;
        static Field key_field;
        static Field value_field;
        static Field next_field;

        static {
            try {
                node_class = Class.forName("java.util.HashMap$Node");
                key_field = node_class.getDeclaredField("key");
                value_field = node_class.getDeclaredField("value");
                next_field = node_class.getDeclaredField("next");

                key_field.setAccessible(true);
                value_field.setAccessible(true);
                next_field.setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public WrapNode(Object obj) {
            try {
                key = key_field.get(obj);
                value = value_field.get(obj);
                next = next_field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(" WrapNode [");
            sb.append("key").append("=").append(key).append(", ");
            sb.append("value").append("=").append(value);
            sb.append("] ");
            return sb.toString();
        }
    }
}
