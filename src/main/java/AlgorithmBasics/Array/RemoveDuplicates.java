package AlgorithmBasics.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/30 11:39
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {


    public static void main(String[] args) {

        int[] nums = {1,1,2};
        int i = removeDuplicates(nums);
        System.out.println(nums);
    }

    /**
     * 使用双指针,
     * 快指针J , 慢指针 i
     * 如果快指针的值 不等于 慢指针的值, 将快指针的值赋给慢指针, 慢指针后移一位, 快指针后移一位
     * 如果两个指针的值相同, 快指针后移一位, 慢指针不动, 快指针跳过了重复的值了
     * 直到快指针到达末尾, 最后统计慢指针所在的下标即可
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
