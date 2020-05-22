package AlgorithmBasics;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/5/8 11:21
 * <p>
 * 判断 9 * 9 的二维数组是否为有效的数独
 */
public class IsValidtSudoku {

    public static void main(String[] args) {
        method(null);
    }



    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }



//    public static void main(String[] args) {
////        char[][] board = {
////                {"5".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
////                {"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],"5".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
////                {".".toCharArray()[0],"9".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0]},
////                {"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0]},
////                {"4".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0]},
////                {"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0]},
////                {".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0]},
////                {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"4".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"5".toCharArray()[0]},
////                {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],"9".toCharArray()[0]}
////        };
////        char[][] board =
////                {
////                        {"8".toCharArray()[0], "3".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "7".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0]},
////                        {"6".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "1".toCharArray()[0], "9".toCharArray()[0], "5".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0]},
////                        {".".toCharArray()[0], "9".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "6".toCharArray()[0], ".".toCharArray()[0]},
////                        {"8".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "6".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "3".toCharArray()[0]},
////                        {"4".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0], "3".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "1".toCharArray()[0]},
////                        {"7".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "2".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "6".toCharArray()[0]},
////                        {".".toCharArray()[0], "6".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "2".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0]},
////                        {".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "4".toCharArray()[0], "1".toCharArray()[0], "9".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "5".toCharArray()[0]},
////                        {".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "7".toCharArray()[0], "9".toCharArray()[0]}
////                };
//        char[][] board =
//                {
//                        {"5".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
//                        {"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],"5".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
//                        {".".toCharArray()[0],"9".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0]},
//                        {"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0]},
//                        {"4".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0]},
//                        {"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0]},
//                        {".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0]},
//                        {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"4".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"5".toCharArray()[0]},
//                        {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],"9".toCharArray()[0]}};
//
//        System.out.println(isValidSudoku(board));
//    }


    /**
     * 遍历所有元素, 用map 记录元素的坐标值 key : [横坐标, 纵坐标], value 值
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Map<Map<Integer, Integer>, Character> coordinateMap = new HashMap<Map<Integer, Integer>, Character>();
        for (int i = 0; i < board.length; i++) {
            char[] subBord = board[i];

            for (int j = 0; j < subBord.length; j++) {
                char c = subBord[j];
                if (c == ".".toCharArray()[0]) {
                    continue;
                }
                if (!coordinateMap.containsValue(c)) {
                    Map<Integer, Integer> cordMap = new HashMap<Integer, Integer>();
                    cordMap.put(i, j);
                    coordinateMap.put(cordMap, c);
                } else {
                    for (Map.Entry<Map<Integer, Integer>, Character> mapCharacterEntry : coordinateMap.entrySet()) {
                        if (mapCharacterEntry.getValue() == c) {
                            Map<Integer, Integer> cord = mapCharacterEntry.getKey();
                            // 根据规则判断当前的坐标与cord的坐标是否符合规则
                            for (Map.Entry<Integer, Integer> integerIntegerEntry : cord.entrySet()) {
                                Integer key = integerIntegerEntry.getKey();
                                Integer value = integerIntegerEntry.getValue();

                                if ((i <= key && key <= (i + 3)) || (j <= value && value <= (j + 3))) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
