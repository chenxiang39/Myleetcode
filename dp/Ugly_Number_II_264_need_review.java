public class Ugly_Number_II_264_need_review {
    //dp
    //Time complexity: O(n)
    //Space complexity: O(n)
    //当前的数是由前面已存在的丑数乘以2/3/5，所以我们对每一个存在的丑数乘以2,3,5
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];   //第i + 1个丑数
        dp[0] = 1;       //第1个丑数为1
        // 2, 3, 5对应的最小丑数
        int i2 = 2;
        int i3 = 3;
        int i5 = 5;
        //i2, i3, i5对应最小值的下标
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for(int i = 1; i < n; i++){
            //找出当前可能的丑数的最小值
            int min = Math.min(Math.min(i2,i3),i5);
            dp[i] = min;
            //如果找到了对应的丑数，则将对应的下标加1，然后重新计算新的丑数，三个if可以避免i2,i3和i5相等的情况
            if(min == i2){
                index2++;
                i2 = 2 * dp[index2];
            }
            if(min == i3){
                index3++;
                i3 = 3 * dp[index3];
            }
            if(min == i5){
                index5++;
                i5 = 5 * dp[index5];
            }
        }
        return dp[n - 1];
    }
}
