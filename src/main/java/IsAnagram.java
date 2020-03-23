import java.util.HashMap;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/23 10:54
 * 求异位词
 */
public class IsAnagram {

    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        // 1. 计算字符串1 和 字符串2 中每个字母出现的次数
        Map<Character, Integer> tmpMap1 = new HashMap<>();
        Map<Character, Integer> tmpMap2 = new HashMap<>();

        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        for (char c : charArray1) {
            if (tmpMap1.containsKey(c)) {
                Integer count = tmpMap1.get(c);
                tmpMap1.put(c, count++);
            } else {
                tmpMap1.put(c, 1);
            }
        }

        for (char c : charArray2) {
            if (tmpMap2.containsKey(c)) {
                Integer count = tmpMap2.get(c);
                tmpMap2.put(c, count ++);
            } else {
                tmpMap2.put(c, 1);
            }
        }

        // 判断tmpMap1 和 tmpMap2 是否相同
        Boolean flag = true;
        for (Map.Entry<Character, Integer> entrySet : tmpMap1.entrySet()) {
            Character key = entrySet.getKey();
            if (tmpMap2.get(key) == null || tmpMap2.get(key) != tmpMap1.get(key)) {
                return false;
            }
        }
        return flag;
    }
}
