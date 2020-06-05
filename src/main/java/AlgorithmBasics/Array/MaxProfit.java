package AlgorithmBasics.Array;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/30 14:56
 * 单次交易最大收益
 */
public class MaxProfit {

    public static void main(String[] args) {

    }

    /**
     * 暴力解题方法:
     * 时间复杂度 : O(n^2)
     * 空间复杂度: O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = (i + 1); j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

}
