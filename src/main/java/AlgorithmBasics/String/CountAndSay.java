package AlgorithmBasics.String;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/11 11:34
 * 外观描述数列:
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            // 每次遍历, 对result进行拆解并重新组合赋值
            char[] charArray = result.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < charArray.length ; j++) {
                Integer count = 1;
                char value = charArray[j];
                count = countArray(charArray, j, count);
                j = j + count -1 ;
                sb.append(count + "").append(value);
            }
            result = sb.toString();
        }
        return result;
    }

    private static int countArray(char[] charArray, int j, int count) {
        if ((j +1) > charArray.length -1){
            return count;
        }
        char a = charArray[j];
        char b = charArray[j + 1];
        if (a == b) {
            ++count;
            count = countArray(charArray, (j + 1), count);
        }else {
            return count;
        }
        return count;
    }
}
