package ListRelated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/25 10:28
 * <p>
 * 四数之和:
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/239/learn-to-use-keys/997/
 */
public class FourSumPlus {

    public static void main(String[] args) {
        int[] A = {-1,-1};
        int[] B = {-1,1};
        int[] C = {-1,1};
        int[] D = {1,-1};
        System.out.println(fourSumCount(A, B, C, D));
    }

    /**
     * 复杂度 O(n^2), 遍历前两个数组, 然后再遍历后两个数组, 确认是否有相反的数
     * 使用map 的key记录遍历时所有的和, value 记录下标组合
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        //Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i<A.length;i++){
            for(int j= 0;j<B.length;j++){
                int sumAB = A[i]+B[j];
                if(map.containsKey(sumAB)){
                    map.put(sumAB,map.get(sumAB)+1);
                }
                else map.put(sumAB,1);
            }
        }

        for(int i = 0;i<C.length;i++){
            for(int j = 0;j<D.length;j++){
                int sumCD = -(C[i]+D[j]);
                if(map.containsKey(sumCD)){
                    res += map.get(sumCD);
                }
            }
        }
        return res;

    }
}
