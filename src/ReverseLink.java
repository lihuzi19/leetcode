import java.util.Arrays;

/**
 * @author lining
 * @version 1.0
 * @create 2019-03-13 17:36
 * 描述:
 */
public class ReverseLink {
    public static void main1(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] nums1 = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums1, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int result = nums[i] + nums[j];
                    if (result == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
//        1534236469
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    public static int reverse(int x) {
        Long a = new Long(x);
        boolean minus = (x >= 0);
        String value = new StringBuffer(String.valueOf(minus ? a : -a)).reverse().toString();
        Long num = new Long(value);
        if (num > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (minus ? num : -num);
    }

}
