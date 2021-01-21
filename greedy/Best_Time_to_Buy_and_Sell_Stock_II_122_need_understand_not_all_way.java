public class Best_Time_to_Buy_and_Sell_Stock_II_122_need_understand_not_all_way {
    //greedy
    //时间复杂度：O(n)
    //空间复杂度；O(1)
    public static int maxProfit(int[] prices) {
        int storage = 0;
        if(prices.length == 0){
            return storage;
        }
        int buyPrice = prices[0];
        int salePrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(buyPrice > prices[i]){           //遇到买价还小的，就更改买价
                buyPrice = prices[i];
                salePrice = buyPrice;           //售价同步更新(不会出错)
            }
            //遇到不比买价小的价格
            else{
                if(salePrice < prices[i]){          //遇到价格比售价高的
                    storage += (prices[i] - salePrice);     //利润更新差价(之前的利润加上现在的价格减掉之前的售价)
                    salePrice = prices[i];          //更新售价
                }
                else{
                    buyPrice = prices[i];           //开启新的交易
                    salePrice = buyPrice;           //售价同步更新
                }
            }
        }
        return storage;
    }
    public static void main(String[] args){
        int[] price = {6,1,3,2,4,7};
        System.out.println(maxProfit(price));
    }
}
