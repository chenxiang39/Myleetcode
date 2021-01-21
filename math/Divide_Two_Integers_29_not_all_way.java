public class Divide_Two_Integers_29_not_all_way {
    //https://www.jianshu.com/p/89236ec1a562
    //如果被除数为 Integer.MIN_VALUE，则它无法转化为对应的正数。需要注意：Integer.MIN_VALUE == -Integer.MIN_VALUE。
    //跳跃乘数法
    //dividend = 20 - 3 = 17，divisor = 3，jump = 1，result = 1（result 为最终要返回的结果）
    //dividend = 17 - 3*2 = 11，divisor = 6，jump = 2，result = 3（将 k 累加进 result）
    //dividend = 11 - 6*2 = -1，dividend < 0，则 divisor = 3，jump = 1
    //dividend = 11 - 3 = 8，divisor = 3，jump = 1，result = 4
    //dividend = 8 - 3*2 = 2，divisor = 6，jump = 2，result = 6
    //dividend = 2 - 6*2 = -10，dividend < 0，则 divisor = 3，jump = 1
    //dividend = 2 - 3 = -1，dividend < 0，又 jump == 1，算法结束，result = 6
    //所以 20 除 3 的商就为 6。
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == - 1){       //此结果overflow
            return Integer.MAX_VALUE;
        }
        if (divisor == -1){
            return - dividend;
        }
        if (divisor == 1){
            return dividend;
        }
        //必须全部将正数换成负数，因为负数的最小值为-2147483648，绝对值比正数的最大值2147483647更大
        boolean isSameNeg = true; //同号标志
        if (dividend > 0 && divisor < 0){
            isSameNeg = false;
            dividend = - dividend;        //换成负数
        }
        else if (dividend < 0 && divisor > 0){
            isSameNeg = false;
            divisor = - divisor;
        }
        //换成正数
        else if (dividend >= 0 && divisor > 0){
            dividend = - dividend;
            divisor = - divisor;
        }
        int jump = 1;
        int result = 0;
        while (true){
            if(jump == 1 && dividend > divisor){        //正数的话为<，因为全部换成了负数，所以为>
                return isSameNeg ? result : - result;
            }
            if (dividend <= divisor){       //正数的话为>=，因为全部换成了负数，所以为<=
                dividend -= divisor;
                result+=jump;
                if (divisor > Integer.MIN_VALUE/2){         //此处若是过界，则乘2后会变成正数
                    divisor *= 2;           //除数加倍扩大
                    jump *= 2;              //跳跃值加倍扩大
                }
            }
            else {
                divisor = divisor / 2;      //值不够时除数缩小一半
                jump = jump /2;             //跳跃值缩小一半
            }
        }
    }
    public static void main(String[] args){
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE + 1);
//        System.out.println(Integer.MIN_VALUE - 1);
//        System.out.println(-1090366779 * 2);
//        System.out.println(1100540749 * 2);
        System.out.println(divide(-2147483645 ,-2));
    }
}
