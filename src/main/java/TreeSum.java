import java.util.*;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/24 10:32
 * 三数之和 等于 0
 */
public class TreeSum {


    public static void main(String[] args) {
        int[] a = {3, 0, -2, -1, 1, 2};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }

    /**
     * 思路:
     * 将数组按升序排序,
     * 使用3个指针遍历, 指针A 固定, 指针B, 指针C 从两侧开始遍历,
     * 指针A 值  + B + C = 0, B, C 均往中间移动
     * A + B + C < 0, B 往右移动, C 不动
     * A + B+ B > 0 , B 不动, C 往左移动
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        // 升序
        List<Integer> tmpList = new ArrayList<>();
        for (int num : nums) {
            tmpList.add(num);
        }
        Collections.sort(tmpList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < tmpList.size(); i++) {
            if (i == (tmpList.size() - 1)) {
                continue;
            }
            // 指针A
            int pointA = i;
            int pointAValue = tmpList.get(pointA);

            // 指针B, 指针A 的下一位
            int pointB = (i + 1);

            //指针C, 列表的最后一位
            int pointC = (tmpList.size() - 1);
            while (pointB < pointC) {
                int pointBValue = tmpList.get(pointB);
                int pointCValue = tmpList.get(pointC);

                if ((pointAValue + pointBValue + pointCValue) < 0) {
                    pointB++;
                }
                if ((pointAValue + pointBValue + pointCValue) > 0) {
                    pointC--;
                }
                if (pointAValue == -(pointBValue + pointCValue)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(tmpList.get(pointA));
                    list.add(tmpList.get(pointB));
                    list.add(tmpList.get(pointC));
                    resultSet.add(list);
                    pointB++;
                    pointC--;
                }
            }
            // 指针B = 指针C 时, 如

        }
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.addAll(resultSet);
        return resultList;
    }
}
