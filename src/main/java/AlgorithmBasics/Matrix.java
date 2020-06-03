package AlgorithmBasics;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/3 15:06
 * 矩阵转置: 列转行, 需原地旋转
 */
public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(matrix);
    }

    public static void rotate(int[][] matrix) {
        // 矩阵转置: 横坐标纵坐标转换, 矩阵沿对角线镜像交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 矩阵转置之后, 每行元素反转及可最终得到顺时针旋转90度的矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = tmp;
            }
        }
    }
}
