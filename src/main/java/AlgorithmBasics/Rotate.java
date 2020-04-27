package AlgorithmBasics;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/15 9:14
 * <p>
 * 旋转数组: 数组所有元素右移动 k 个位置, 空间复杂度为 O(1), 原地移动
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 分析:
 *   1. 递归: 每次操作将当前位置的值赋给右边 k 个位置上, 递归返回条件, 右边的第k个位置为 第一个
 *   2. 每次循环, 将最后一个元素放到第一位上, 其余元素后移
 */
public class Rotate {


    public void rotate(int[] nums, int k) {
        int temp=0;
        for(int i=0;i<k;i++){
            temp= nums[nums.length-1];
            for(int j=nums.length-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0]=temp;
        }


    }

}
