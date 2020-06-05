package AlgorithmBasics.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/5/6 17:00
 * 移动0: 将所有0移动到数组的末尾, 其他非0元素的排序不变
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 遍历数组，无为0的元素移动数组前方，用index下标记录。
     * 遍历结束，对index值后的元素统一设为0
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if(num != 0){
                nums[index ++] = num;
            }
        }
        // index 开始到数组末尾全置为0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
