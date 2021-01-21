public class Paint_House_256_need_review {
    //dp
    //Time complexity: O(n), n: the length of costs
    //Space complexity: O(1)
    public int minCost(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        for(int i = 1; i < costs.length; i++){
            //记录之前可能花费的最小值
            costs[i][0] = Math.min(costs[i - 1][1], costs[i - 1][2]) + costs[i][0];
            costs[i][1] = Math.min(costs[i - 1][0], costs[i - 1][2]) + costs[i][1];
            costs[i][2] = Math.min(costs[i - 1][0], costs[i - 1][1]) + costs[i][2];
        }
        int result = Integer.MAX_VALUE;
        //最后花费的最小值
        result = Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]);
        result = Math.min(result, costs[costs.length - 1][2]);
        return result;
    }
}
