package AlgorithmBasics.String;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/11 14:33
 * 查找最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String str = strs[0];
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < str.toCharArray().length; i++) {
            char c = str.toCharArray()[i];
            for (String s : strs) {
                if (i > s.length() -1){
                    flag = false;
                    break;
                }
                if (c != s.charAt(i)) {
                    flag = false;
                }
            }
            if (flag){
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}
