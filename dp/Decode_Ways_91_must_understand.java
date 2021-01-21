public class Decode_Ways_91_must_understand {
    //https://www.cnblogs.com/grandyang/p/4313384.html
    //dp
    //时间复杂度：O(s.length)
    //空间复杂度：O(s.length)，dp array
    //dp[i]表示s的前i个字符能组成的解码的个数
    //初始化dp[0] = 1
    //如果当前字符可以跟前一位组成组合字符（例如'26' ==> BF, Z),则dp[i] = dp[i - 1] + dp[i - 2]
    //否则就是dp[i] = dp[i - 1]
    //遇到当前位是0表示该位无法拆分
    public static int numDecodings(String s) {
        int n = s.length();
        //空字符或者第一位为0，直接返回0
        if(n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            // 就拿题目中的例子2来分析吧，当 i=1 时，对应s中的字符是 s[0]='2'，只有一种拆分方法，就是2，注意 s[0] 一定不能为0，这样的话无法拆分。当 i=2 时，对应s中的字符是 s[1]='2'，由于 s[1] 不为0，
            // 那么其可以被单独拆分出来，就可以在之前 dp[i-1] 的每种情况下都加上一个单独的2，
            // 这样 dp[i] 至少可以有跟 dp[i-1] 一样多的拆分情况，接下来还要看其能否跟前一个数字拼起来，若拼起来的两位数小于等于26，并且大于等于 10（因为两位数的高位不能是0），
            // 那么就可以在之前 dp[i-2] 的每种情况下都加上这个二位数，所以最终 dp[i] = dp[i-1] + dp[i-2]，是不是发现跟斐波那契数列的性质吻合了。所以0是个很特殊的存在，若当前位置是0，
            // 则一定无法单独拆分出来，即不能加上 dp[i-1]，就只能看否跟前一个数字组成大于等于 10 且小于等于 26 的数，能的话可以加上 dp[i-2]，否则就只能保持为0了
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            if(i > 1 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(numDecodings("10110"));
    }
}
