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
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        BigDecimal tmp = BigDecimal.ZERO;
        for (int i = digits.length - 1; i >= 0; i--) {
            // 倒序遍历
            int digit = digits[i];
            Double v = digit * Math.pow(10, (digits.length - 1 - i));
            tmp = tmp.add(BigDecimal.valueOf(v));
        }
        tmp = tmp.add(BigDecimal.ONE);
        // 转换为数组
        tmp.setScale(0);
        String tmpStr = tmp + "";
        String[] split = tmpStr.split("");
        int[] result = new int[tmpStr.length()];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.valueOf(split[i]);
        }
        return result;
    }
}
