public class Factorial_Trailing_Zeroes_172_need_to_understand {
    //关注其他方法的时间复杂度
    public static int trailingZeroes(int n) {
        //因为我们知道0是2和5相乘得到的，而在1到n这个范围内，2的个数要远多于5的个数，所以这里只需计算从1到n这个范围内有多少个5就可以了。
        //注意25中包含2个5，125包含3个5
        //https://www.jianshu.com/p/211618afc695
        //空间复杂度：O(1)
        //时间复杂度：因为乘法和除法都在32位中计算，所以复杂度为O(1),总的计算次数是log5(n),约等于log(n);在对数复杂度计算中，底数不重要
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
    public static void main(String[] args){
        System.out.println(trailingZeroes(20));
    }
}
