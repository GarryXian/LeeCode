package ListRelated;

import java.util.*;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/23 11:57
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 */
public class Isomorphic {


    public static void main(String[] args) {

        String s = "bb";
        String t = "aa";
        System.out.println(isIsomorphicOp(s, t));

    }
    // 是否同构: 结构是否相同
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        // 1. 计算并记录字符串1 中所有字符对应相同字符的下标,
        // 定义记录字典数据结构: Map<当前字符下标, List<对应相同字符下标>>
        Map<Integer, List<Integer>> dictMap1 = getDictMap(s);
        Map<Integer, List<Integer>> dictMap2 = getDictMap(t);
        // 判断字典是否相同
        if (dictMap1.entrySet().size() != dictMap2.entrySet().size()){
            return false;
        }
        for (Map.Entry<Integer, List<Integer>> entry : dictMap1.entrySet()) {
            if (!dictMap2.containsKey(entry.getKey())){
                return false;
            }
            List<Integer> list = dictMap2.get(entry.getKey());
            List<Integer> entryValue = entry.getValue();
            if (!list.equals(entryValue)){
                return false;
            }

        }
        return true;
    }

    private static Map<Integer, List<Integer>> getDictMap(String s) {
        Map<Integer, List<Integer>> tmpMap = new HashMap<Integer, List<Integer>>();
        char[] charArray1 = s.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {

            for (int j = i + 1; j < (charArray1.length ); j++) {
                Boolean flag = false;
                for (Map.Entry<Integer, List<Integer>> integerListEntry : tmpMap.entrySet()) {
                    if (integerListEntry.getValue().contains(j)) {
                        flag = true;
                        continue;
                    }
                }
                if (flag){
                    continue;
                }
                if (charArray1[i] == charArray1[j]) {
                    if (tmpMap.containsKey(i) && !tmpMap.get(i).contains(j)) {
                        List<Integer> list = tmpMap.get(i);
                        list.add(j);
                        tmpMap.put(i, list);
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(j);
                        tmpMap.put(i, list);
                    }
                }
            }
        }
        return tmpMap;
    }

    //题判定为false有这些个情况，我们假设拿s串和t串作对比
    //1.s串中相同的字符，对应的t串中的字符并不相等
    //2.s串中不同的字符，对应的t串中的字符却是相等的
    //所以判断的关键点就是相同的字符要对应相同的字符，那么相同字符处于后位置的字符的第一次出现的位置就应该相同。
    //
    //作者：hao-fei-hao
    //链接：https://leetcode-cn.com/problems/isomorphic-strings/solution/javake-neng-bi-jiao-jian-dan-de-xie-fa-by-hao-fei-/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static boolean isIsomorphicOp(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }


}
