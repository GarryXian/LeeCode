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
//        char[][] board = {
//                {"5".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
//                {"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],"5".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
//                {".".toCharArray()[0],"9".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0]},
//                {"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0]},
//                {"4".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0]},
//                {"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0]},
//                {".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0]},
//                {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"4".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"5".toCharArray()[0]},
//                {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],"9".toCharArray()[0]}
//        };
//        char[][] board =
//                {
//                        {"8".toCharArray()[0], "3".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "7".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0]},
//                        {"6".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "1".toCharArray()[0], "9".toCharArray()[0], "5".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0]},
//                        {".".toCharArray()[0], "9".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "6".toCharArray()[0], ".".toCharArray()[0]},
//                        {"8".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "6".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "3".toCharArray()[0]},
//                        {"4".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0], "3".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "1".toCharArray()[0]},
//                        {"7".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "2".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "6".toCharArray()[0]},
//                        {".".toCharArray()[0], "6".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "2".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0]},
//                        {".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "4".toCharArray()[0], "1".toCharArray()[0], "9".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "5".toCharArray()[0]},
//                        {".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "8".toCharArray()[0], ".".toCharArray()[0], ".".toCharArray()[0], "7".toCharArray()[0], "9".toCharArray()[0]}
//                };
        char[][] board =
                {
                        {"5".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
                        {"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],"5".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0]},
                        {".".toCharArray()[0],"9".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0]},
                        {"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0]},
                        {"4".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],"3".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"1".toCharArray()[0]},
                        {"7".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"6".toCharArray()[0]},
                        {".".toCharArray()[0],"6".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"2".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0]},
                        {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"4".toCharArray()[0],"1".toCharArray()[0],"9".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"5".toCharArray()[0]},
                        {".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"8".toCharArray()[0],".".toCharArray()[0],".".toCharArray()[0],"7".toCharArray()[0],"9".toCharArray()[0]}};

        System.out.println(isValidSudoku(board));
    }


    /**
     * 遍历所有元素, 用map 记录元素的坐标值 key : [横坐标, 纵坐标], value 值
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Map<Map<Integer, Integer>, Character> coordinateMap = new HashMap<Map<Integer, Integer>, Character>();
        for (int v = 0; v < board.length; v++) {
            char[] subBord = board[v];

            for (int h = 0; h < subBord.length; h++) {
                char c = subBord[h];
                if (c == ".".toCharArray()[0]) {
                    continue;
                }
                if (!coordinateMap.containsValue(c)) {
                    Map<Integer, Integer> cordMap = new HashMap<Integer, Integer>();
                    cordMap.put(v, h);
                    coordinateMap.put(cordMap, c);
                } else {
                    for (Map.Entry<Map<Integer, Integer>, Character> mapCharacterEntry : coordinateMap.entrySet()) {
                        if (mapCharacterEntry.getValue() == c) {
                            Map<Integer, Integer> cord = mapCharacterEntry.getKey();
                            // 根据规则判断当前的坐标与cord的坐标是否符合规则
                            for (Map.Entry<Integer, Integer> integerIntegerEntry : cord.entrySet()) {
                                Integer vertical = integerIntegerEntry.getKey();
                                Integer horizonal = integerIntegerEntry.getValue();
                                // 当前的坐标值mod 3, 根据结果判定时候在 3*3的区域中
                                Integer hMod = h % 3;
                                Integer vMod = v % 3;
                                Boolean hFlag = true;
                                Boolean vFlag = true;
                                // 判定横坐标是否符合 3*3 区域
                                switch (hMod){
                                    case 0:
                                        // 3*3 区域中第一个
                                        hFlag = (horizonal - h) < 3 && (horizonal - h) >= 0;
                                        break;
                                    case 1:
                                        // 3*3 区域中第二个, 是否相邻
                                        hFlag = Math.abs(horizonal - h) == 1;
                                        break;
                                    case 2:
                                        // 3*3 区域中第三个
                                        hFlag = (h - horizonal) < 3 && (h - horizonal) >= 0 ;
                                        break;
                                }
                                // 判定纵横坐标是否符合 3*3 区域
                                switch (vMod){
                                    case 0:
                                        // 3*3 区域中第一个
                                        vFlag = (vertical - v) < 3 && (vertical - v) >= 0;
                                        break;
                                    case 1:
                                        // 3*3 区域中第二个, 是否相邻
                                        vFlag = Math.abs(vertical - v) == 1;
                                        break;
                                    case 2:
                                        // 3*3 区域中第三个
                                        vFlag = (v - vertical) < 3 && (v - vertical) >= 0 ;
                                        break;
                                }
                                if (hFlag && vFlag) {
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
