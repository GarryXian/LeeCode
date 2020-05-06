package AlgorithmBasics;

import java.math.BigDecimal;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/17 15:16
 * 将输入的数组转换为数字, 加一后的数字转换为数组返回
 *
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {4,9,8};
        plusOne(digits);
        System.out.println(digits.toString());
    }


    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            // 对10 取余数, 如果为0, 则标识需进一位, 继续遍历
            digits[i] %= 10;
            if(digits[i]!=0)
                // 加1后不为0, 不需进一位, 直接返回
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
