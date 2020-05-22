package AlgorithmBasics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/5/21 14:36
 * 斐波那契数列: 动态规划
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(cal(6));

    }

    /**
     * 计算斐波那契数列第 n 层的数值
     * 递归求解(带备忘录), 每次计算时, 记录计算结果, 避免后续重复计算
     *
     * @param n > 2
     * @return
     */
    public static Integer cal(int n) {
        Map<Integer, Integer> recordMap = new HashMap<Integer, Integer>();
        return fib(recordMap, n);
    }

    private static Integer fib(Map<Integer, Integer> recordMap, int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1){
            return 1;
        }
        if (recordMap.get(n) == null) {
            Integer result = fib(recordMap, n - 1) + fib(recordMap, n - 2);
            recordMap.put(n, result);
            return result;
        } else {
            return recordMap.get(n);
        }

    }
}