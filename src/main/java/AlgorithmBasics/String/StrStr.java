package AlgorithmBasics.String;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/11 10:57
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class StrStr {


    public static void main(String[] args) {
        String h = "";
        String n = "";
        System.out.println(strStr(h, n));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")){
            return 0;
        }
        char[] hCharArray = haystack.toCharArray();
        char[] nCharArray = needle.toCharArray();

        for (int i = 0; i < hCharArray.length; i++) {
            boolean flag = true;
            char nChar = nCharArray[0];
            char hChar = hCharArray[i];
            if (nChar != hChar) {
                continue;
            }
            if ((hCharArray.length - i) < nCharArray.length) {
                flag = false;
                continue;
            }
            for (int j = 1; j < nCharArray.length; j++) {
                nChar = nCharArray[j];
                hChar = hCharArray[i + j];
                if (nChar != hChar) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
