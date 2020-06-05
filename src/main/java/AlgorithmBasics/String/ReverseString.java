package AlgorithmBasics.String;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/3 16:54
 * 反转字符串
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2 ; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i -1];
            s[s.length - i -1] = tmp;
        }
    }
}
