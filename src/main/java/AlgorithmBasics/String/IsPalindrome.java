package AlgorithmBasics.String;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/8 16:47
 * 判断是否回文, 只考虑字母和数字字符，可以忽略字母的大小写
 * !!!! 使用双指针方法即可
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeOp(str));
    }


    /**
     * 双指针优化方法
     * @param s
     * @return
     */
    public static boolean isPalindromeOp(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (right >= left) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                // 左侧非字母或数字
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))){
                // 右侧非字母或数字
                right --;
                continue;
            }
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))){
                if (String.valueOf(s.charAt(left)).equalsIgnoreCase(String.valueOf(s.charAt(right)))) {
                    left++;
                    right--;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int length = s.toCharArray().length;
        // 累计正向偏移量
        Integer pointOffSetA = 0;
        // 累计反向偏移量
        Integer pointOffSetB = 0;
        for (int i = 0; i < length / 2; i++) {
            Character c = s.toCharArray()[i];
            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90) || (c >= 48 && c <= 57)) {
                // 计算左侧指针(正向偏移量与反向偏移量抵消)
                Integer pointB = s.toCharArray().length - 1 - i + pointOffSetA - pointOffSetB;
                Character c1 = s.toCharArray()[pointB];
                if (!((c1 >= 97 && c1 <= 122) || (c1 >= 65 && c1 <= 90) || (c1 >= 48 && c1 <= 57))) {
                    // 左侧位置非字母或数字, 反向偏移量 + 1, 正向指针位置停留
                    pointOffSetB++;
                    i--;
                    continue;
                }
                // 需忽略大小写
                if (!String.valueOf(c).equalsIgnoreCase(String.valueOf(c1))) {
                    return false;
                }
            } else {
                pointOffSetA++;
            }
        }
        return true;
    }

    /**
     * 计算与 i 对称的指针位置
     *
     * @param charArray    数组
     * @param pointOffSetA 正向偏移量
     * @param pointOffSetB 反向偏移量
     * @param i            正向指针位置
     * @return 反向指针的偏移量
     */
    private static Integer findCharacterIndex(char[] charArray, int pointOffSetA, int pointOffSetB, int i) {
        Integer pointB = charArray.length - 1 - i + pointOffSetA - pointOffSetB;
        char c = charArray[pointB];
        if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90) || (c >= 48 && c <= 57)) {
            return pointOffSetB;
        } else {
            pointOffSetB++;
            pointOffSetB = findCharacterIndex(charArray, pointOffSetA, pointOffSetB, i);
        }
        return pointOffSetB;
    }
}
