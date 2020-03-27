/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/27 9:15
 * <p>
 * 滑动窗口问题:
 * 给定一个整数数组和一个整数 k，
 * 判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicateOp(nums, k));
    }


    /**
     * 维护一个滑动的窗口, 窗口大小为 k , 在此窗口中寻找是否有相同的元素
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicateOp(int[] nums, int k){
        Boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            // 维护一个窗口, 直到窗口到达数组尾部, 窗口开始从 ()
            for (int j = ( i + 1 ); j <= Math.min((i + k), (nums.length-1) ); j++) {
                // 在此窗口中判断是否有相同元素
                if (nums[i] == nums[j]){
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = (i + 1); j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs((i - j)) <= k) {
                    flag = true;
                } else {
                    continue;
                }
            }
        }
        return flag;
    }
}
