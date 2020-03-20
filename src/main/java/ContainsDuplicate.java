import java.util.HashSet;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/20 11:25
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(Integer.valueOf(num));
        }
        return nums.length != set.size();
    }
}
