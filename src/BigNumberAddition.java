import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 * @version 1.0
 * @create 2019-03-15 16:58
 * 描述:
 */
public class BigNumberAddition {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
            }
            if (l2 != null) {
                b = l2.val;
            }
            list.add((a + b));
        }
        int last = 0;
        temp1 = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            int a = list.get(i) + last;
            if (a > 9) {
                last = 1;
                a = a - 10;
            }
            ListNode node = new ListNode(a);
            if (temp1 == null) {
                temp1 = node;
            } else {
                node.next = temp1;
                temp1 = null;
                temp1 = node;
            }
        }
        return temp1;
    }

}
