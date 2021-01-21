public class Best_Time_to_Buy_and_Sell_Stock_121_not_all_way {
    //greedy
    //时间复杂度：O(n)
    //空间复杂度；O(1)
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length == 0) {
            return max;     //没有值就返回0
        }
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= buyPrice) {       //遇到比买进价大的就计算利润
                max = Math.max(prices[i] - buyPrice, max);     //比较之前计算过的利润大小
            } else {
                buyPrice = prices[i];          //遇到比之前的买进价小的就切换买进价(后面遇到更大的，用更小的买进价计算能得到更高的利润)
            }
        }
        return max;
    }
}
