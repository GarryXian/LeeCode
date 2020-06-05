package AlgorithmBasics.String;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/4 16:33
 * 找到字符串中第一个不重复的字符, 返回下标
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(firstUniqChar(str));
    }

    public static int firstUniqChar(String s) {
        // 找所有不重复的字符
        Map<Character, Integer> tmp = new HashMap<Character,  Integer>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.toCharArray()[i];
            if (tmp.containsKey(c)){
                Integer count = tmp.get(c);
                tmp.put(c, ++ count);
            }else {
                tmp.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (tmp.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
