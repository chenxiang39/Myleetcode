public class Gas_Station_134_need_to_understand {
    //brute force (very slow)
    //Time complexity : O(n^2), n ： the length of gas array
    //Space complexity : O(1)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            if(gas[i] < cost[i]){
                continue;
            }
            if(cantravel(i,gas,cost)){
                return i;
            }
        }
        return -1;
    }
    private static boolean cantravel(int start, int[] gas, int[] cost){
        int storage = gas[start] - cost[start];
        for(int i = (start + 1) % gas.length; i != start; i = (i + 1) % gas.length){
            storage += (gas[i] - cost[i]);
            if(storage < 0){
                return false;
            }
        }
        return true;
    }
    //one pass way (leetcode has video to explain)
    //Time complexity : O(n),  there is only one loop over all stations here, n ： the length of gas array
    //Space complexity : O(1)
    public static int canCompleteCircuit_2(int[] gas, int[] cost) {
        int total_cost = 0;     //记录每次充的汽油和消耗的汽油的差值和（最终小于等于0说明油够用）
        int current_gas = 0;    //记录当前加油站的剩余油量
        int start = 0;          //从何处开始（result）
        for(int i = 0; i < gas.length; i++){
            total_cost += cost[i] - gas[i];
            current_gas += gas[i] - cost[i];        //计算当前加油站的剩余油量
            if(current_gas < 0){                //油不够用
                start = i + 1;                  //从下一个加油站开始计数，此前的加油站都不是合理的结果(因为是循环，所以不用害怕之前的加油站不会经过)
                current_gas = 0;                //剩余油量置0
            }
        }
        return total_cost > 0 ? -1 : start;         //油最终够用就输出start,否则输出-1
    }
    public static void main(String[] args){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
