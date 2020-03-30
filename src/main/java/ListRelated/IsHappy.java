package ListRelated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/20 10:08
 * 是否快乐数:
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数
 *
 * 对于不快乐数: 计算的结果会重复
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IsHappy {

    public static void main(String[] args) {

        int n = 2;
        System.out.println(isHappy(n));

    }

    public static boolean isHappy(int n) {
        HashSet<Integer> resultSet = new HashSet<>();
        resultSet.add(Integer.valueOf(n));
        return isHappy(n,resultSet );
    }

    // 不快乐数, 计算结果会重复, 以此来跳出递归
    private static boolean isHappy(int n , HashSet<Integer> set){
        boolean flag = false;
        String str = n + "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (i != str.length() - 1) {
                list.add(Integer.valueOf(str.substring(i, i + 1)));
            } else {
                list.add(Integer.valueOf(str.substring(i)));
            }

        }
        int result = isOne(list);
        if (result == 1) {
            return true;
        } else if (set.contains(result)){
          return false;
        }else {
            set.add(Integer.valueOf(result));
            flag = isHappy(result, set);
        }
        return flag;
    }

    // 计算多个数的平方和
    private static int isOne(List<Integer> a) {
        Integer result = 0;
        for (Integer i : a) {
            result += i*i;
        }
        return result;
    }
}
