package ListRelated;

import java.math.BigDecimal;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/27 9:35
 *
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t， 小于t
 * 并且 i 和 j 之间的差的绝对值最大为 k, 小于k
 *
 */
public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = (i +1 ); j <= Math.min((i + k), (nums.length-1)); j++) {
                BigDecimal a = BigDecimal.valueOf(nums[i]);
                BigDecimal b = BigDecimal.valueOf(nums[j]);
                if (a.subtract(b).abs().compareTo(BigDecimal.valueOf(t)) <= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
