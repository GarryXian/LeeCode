package ListRelated;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/23 17:33
 */
public class FrequencySort {

    public static void main(String[] args) {
        String s = "cdageag";
        System.out.println(frequencySort(s));

    }

    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> tmpMap = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            if (tmpMap.containsKey(aChar)) {
                Integer count = tmpMap.get(aChar);
                tmpMap.put(aChar, ++count);
            } else {
                tmpMap.put(aChar, 1);
            }
        }
        // 排序
        Set<Map.Entry<Character, Integer>> entries = tmpMap.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>();
        for (Map.Entry<Character, Integer> entry : entries) {
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1 : -1;
            }
        });

        String result = "";
        for (Map.Entry<Character, Integer> entry : list) {
            for (Integer i = 0; i < entry.getValue(); i++) {
                result += String.valueOf(entry.getKey());
            }
        }
        return result;
    }
}
