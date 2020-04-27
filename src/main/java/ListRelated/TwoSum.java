package ListRelated;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/24 9:41
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSumUsingHash(nums, target);

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            for (int j = (i + 1); j < nums.length ; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 思路: 遍历数组元素, 目标减元素结果, hashmap中存在, 得出结果
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumUsingHash(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (tmpMap.containsKey(nums[i])){
                result[0] = i;
                result[1] = tmpMap.get(nums[i]);
            }else {
                tmpMap.put(tmp, i);
            }
        }
        return result;
    }
}
