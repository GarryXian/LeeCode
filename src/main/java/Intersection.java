import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 *   两个数组的交集
 * @Date 2020/3/13 15:20
 */
public class Intersection {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j ){
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
}
