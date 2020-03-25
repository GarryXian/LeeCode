import java.util.*;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/25 9:24
 * <p>
 * 求四数之和
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);

    }


    /**
     * 将两个数先捆绑一起, 与三数之和类似
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // 升序排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int j = 1; j < (list.size() - 1); j++) {


            for (int i = 0; i < list.size(); i++) {
                if (i == (list.size() - 1)) {
                    continue;
                }
                // 指针A , 指针A 的值等于当前位置及后续位置中的其中一个的和
                int pointA = i;
                int pointAa = (list.size() - j);
                int aValue = list.get(i) + list.get(pointAa);

                // 指针B, 从第一位开始, 跳过 i 和 (i + j) 的值
                int pointB = 0;

                // 指针C
                int pointC = list.size() - 1;

                while (pointB < pointC) {
                    // 判断指针B 是否与指针A 有重叠了
                    if (pointB == pointA || pointB == (pointAa) ){
                        pointB++;
                        continue;
                    }
                    if (pointC == pointA || pointC == (pointAa) ){
                        pointC--;
                        continue;
                    }
                    int bValue = list.get(pointB);
                    int cValue = list.get(pointC);
                    if (aValue + bValue + cValue < target) {
                        pointB++;
                    }
                    if (aValue + bValue + cValue > target) {
                        pointC--;
                    }
                    if (pointA == pointAa){
                        break;
                    }
                    if (aValue + bValue + cValue == target) {
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(list.get(pointA));
                        tmpList.add(list.get(pointAa));
                        tmpList.add(bValue);
                        tmpList.add(cValue);
//                        System.out.println(tmpList);
                        tmpList.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1.compareTo(o2);
                            }
                        });
                        resultSet.add(tmpList);
                        pointB++;
                        pointC--;
                    }
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.addAll(resultSet);
        return resultList;
    }
}
