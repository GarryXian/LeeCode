package ListRelated;

import java.util.*;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * 两个数组的交集
 * @Date 2020/3/13 15:20
 */
public class Intersection {

    public static void main(String[] args) {

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = intersect2(nums1, nums2);
        System.out.println(intersect.toString());


    }

    // 简单求两个数组的交集
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<Integer>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    result.add(i);
                }
            }
        }
        int[] resultArr = new int[result.size()];
        ArrayList<Integer> list = new ArrayList();
        list.addAll(result);
        for (int i = 0; i < list.size(); i++) {
            resultArr[i] = list.get(i);
        }
        return resultArr;
    }

    // 求两个数组交集, 重复次数也要一致
    // 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    // 我们可以不考虑输出结果的顺序。
    public static int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<Integer>();
        // 1. 取出集合1中的一个元素, 判断集合2中是否有相同元素
        Set<Integer> tmpList = new HashSet<Integer>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    tmpList.add(i);
                    continue;
                }
            }
        }
        // 2. 有相同元素, 计算集合1 和 集合2 中此元素的重复次数, 取最小值
        Map<Integer, Integer> resultConutMap = new HashMap<Integer, Integer>();
        Iterator<Integer> iterator = tmpList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Integer count1 = 0;
            Integer count2 = 0;
            for (int i : nums1) {
                if (next == i) {
                    count1++;
                }
            }
            for (int i : nums2) {
                if (next == i) {
                    count2++;
                }
            }
            // 3. 按步骤2 中的次数 和 元素, 将元素添加到结果集中
            for (Integer i = 0; i < (count1 >= count2 ? count2 : count1); i++) {
                resultList.add(next);
            }
        }
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }
}
