import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/26 11:17
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 固定起始点A,遍历计算后续点与点A 间的斜率 相等次数, 每相等一次, 此起点及斜率 计数 +1
 * <p>
 * 斜率 k=(y2-y1)/(x2-x1)
 * 注: 水平线的判断, 重复点的判断
 */
public class MaxPoints {


    public static void main(String[] args) {
//        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] points = {{1,1},{2,2},{1,1},{2,2}};
//        int[][] points = {{0,0},{0,0}};
//        int[][] points = {{0,0},{94911151,94911150},{94911152,94911151}};
        int[][] points = {{1,1},{2,2},{3,1},{-1,3},{-10,1}};
//        int[][] points = {{0, 0}, {0, 0}, {0, 0}};
//        int[][] points = {{0, -1}, {0, 3}, {0, -4}, {0, -2}, {0, -4}, {0, 0}, {0, 0}, {0, 1}, {0, -2}, {0, 4}};
        System.out.println(maxPointsOp(points));
    }

    public int maxPointsOp(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        //遍历每个点
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;//保存经过当前点的直线中，最多的点
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                //求出分子分母
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;

                }
                //进行约分
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 定义直线的数据结构: 端点(数组下标), 斜率, 线上坐标的数量, 使用Map存储, key 为 端点下标 + 斜率 拼接字符串
    public static int maxPoints(int[][] points) {
        Map<Integer, Integer> eachMaxPoints = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> lineMap = new HashMap<>();
            int[] pointA = points[i];
            int duplicateCount = 0;
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                int[] pointB = points[j];
                // 判断是否与起点重合
                if (pointA[0] == pointB[0] && pointA[1] == pointB[1]) {
                    // 重合了, 无法计算斜率, 手动在此线上的节点计数加1
                    duplicateCount++;
                    continue;
                }
                // 计算斜率
                BigDecimal k = getK(pointA, pointB);
                // 判断是否有此斜率和此点
                String key = i + "@" + k;
                if (lineMap.containsKey(key)) {
                    // 有此斜率, 判断是否有此点
                    Integer integer = lineMap.get(key);
                    lineMap.put(key, (integer + 1));
                } else {
                    // 无此斜率
                    lineMap.put(key, 2);
                }
            }
            // 经过此点所有直线的最大值
            Integer maxSinglePoint = 0;
            for (Map.Entry<String, Integer> stringIntegerEntry : lineMap.entrySet()) {
                maxSinglePoint = stringIntegerEntry.getValue() > maxSinglePoint ? stringIntegerEntry.getValue() : maxSinglePoint;
            }
            if (lineMap.size() == 0) {
                // 所有点重合
                eachMaxPoints.put(i, points.length);
            } else {
                eachMaxPoints.put(i, maxSinglePoint + duplicateCount);
            }
        }
        Integer result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : eachMaxPoints.entrySet()) {
            result = integerIntegerEntry.getValue() > result ? integerIntegerEntry.getValue() : result;
        }
        return result;
    }

    // 斜率精度有问题, 不能使用Double, 使用Long 类型
    private static BigDecimal getK(int[] pointA, int[] pointB) {
        if ((pointA[0] - pointB[0]) == 0) {
            return null;
        }
        return (BigDecimal.valueOf((pointA[1] - pointB[1]))).divide(BigDecimal.valueOf((pointA[0] - pointB[0])), 9999, RoundingMode.HALF_UP);
    }
}
