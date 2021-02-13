public class Candy_135_need_understand {
    public int candy(int[] ratings) {
        //greedy
        //Leetcode solution 2
        //首先初始化每个人一个糖果，然后这个算法需要遍历两遍，
        //第一遍从左向右遍历，如果右边的小盆友的等级高，等加一个糖果，这样保证了一个方向上高等级的糖果多。
        //然后再从右向左遍历一遍，如果相邻两个左边的等级高，而左边的糖果又少的话，则左边糖果数为右边糖果数加一。
        //最后再把所有小盆友(左右数组中大的那个值)的糖果数都加起来返回即可。
        //time complexity : O(ratings.length)
        //space complexity : O(ratings.length)
        int result = 0;
        int n = ratings.length;
        int[] left = new int[n];    //从左到右遍历的数组
        int[] right = new int[n];   //从右到左遍历的数组
        //初始化1个糖果
        for(int i = 0; i < n; i++){
            left[i] = 1;
            right[i] = 1;
        }
        for(int i = 0; i < n; i++){
            //遇到比之前大的才改变值,若遇到相等或小于的,其值依旧为1
            if(i > 0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }

        for(int i = n - 1; i >= 0; i--){
            if(i < n - 1 && ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        for(int i = 0; i < n; i++){
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
