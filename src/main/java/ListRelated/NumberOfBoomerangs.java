package ListRelated;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/26 9:41
 * <p>
 * 回旋镖问题:
 * 获取输入的坐标数组, 输出所有坐标 (i, j, k) 排序, i 到 j  的距离 = i 到 k  的距离
 */
public class NumberOfBoomerangs {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        System.out.println(numberOfBoomerangsOP(points));
    }

    /**
     * 寻找中间点, 然后找相同距离的两个顶点, 两个顶点可换位置, 计数乘以2即可
     *
     * @param points
     * @return
     */
    public static int numberOfBoomerangsOP(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> tmpMap = new HashMap<>();
            int[] pointA = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] pointB = points[j];
                Double aDouble = calDistance(pointA, pointB);
                if (tmpMap.containsKey(aDouble)) {
                    Integer existNodeNum = tmpMap.get(aDouble);
                    // 关键: !!!排列组合问题, 取与当前中间点相同距离的点数量 * 2 即可
                    count  = count + (existNodeNum *2);
                    tmpMap.put(aDouble, (existNodeNum + 1));
                } else {
                    tmpMap.put(aDouble, 1);
                }
            }
        }
        return count ;

    }


    /**
     * 固定指针A, 超时解法
     *
     * @param points
     * @return
     */
    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < points.length; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    // 计算距离
                    int[] pointA = points[i];
                    int[] pointB = points[j];
                    int[] pointC = points[k];
                    Double i1 = calDistance(pointA, pointB);
                    Double i2 = calDistance(pointA, pointC);
                    if (i1.equals(i2)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static Double calDistance(int[] pointA, int[] pointB) {
        return Math.pow(Double.valueOf((pointA[0] - pointB[0])), 2) + Math.pow(Double.valueOf((pointA[1] - pointB[1])), 2);
    }
}
