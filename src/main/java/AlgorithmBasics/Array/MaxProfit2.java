package AlgorithmBasics.Array;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/3/30 15:03
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 */
public class MaxProfit2 {

    public static void main(String[] args) {

    }

    /**
     * 贪心算法:
     * 每一步都做当前最佳的选择, 即假设 局部最优选择可导致全局最优解
     * <p>
     * 此处可用贪心算法:
     * 只要下一次的价格比当前价格高, 即计算到利润中, 不断累加利润
     *  可从折线图中解析是否成立,
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 0; i < (prices.length - 1 ); i++) {
                int diff = prices[i + 1] - prices[i];
                if (diff > 0) {
                    maxProfit += diff;
                }

            }
            return maxProfit;
    }
}
