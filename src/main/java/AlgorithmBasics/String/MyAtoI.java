package AlgorithmBasics.String;

import java.util.LinkedList;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/10 11:41
 * 将字符串转整数
 */
public class MyAtoI {


    public static void main(String[] args) {
       String str = "789ff1";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // ***** 每次乘以10 再加后面的一位数*****
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }


}
