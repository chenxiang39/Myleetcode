public class Pow_x_n_50_need_to_understand {
    //my way(directly)
    public static double myPow(double x, int n) {
        //注意特殊情况（三种情况必须要加，因为后面的循环考虑的都是n的绝对值大于等于2的情况）
        if(n == 0){
            return 1;
        }
        if(n == 1 || x == 0 || x == 1){
            return x;
        }
        if(n == -1){
            return 1/x;
        }
        double result = 1.0;
        boolean isPos = n > 0;
        n = n > 0 ? -n : n;
        //这里将n强行变为负数的原因是可以满足n = -2147483648的情况，因为 -2147483648的绝对值还是-2147483648
        while (n < -2){
            if (n % 2 == 0){
                n = n / 2;      //n缩小一半
                x = x * x;      //乘数平方
            }
            else{
                result = result * x;        //将多出的一个乘数单独乘进结果中
                n++;        //因为是负数，所以+1
            }
        }
        result *= x * x;        //最后n = 2或-2时，进行乘数平方运算
        return isPos ? result: 1.0/result;
    }
    //recursive way
    public static double myPow_2(double x, int n) {
        double result=0.0;
        if(n == 0){
            return 1;
        }
        if(n == 1 || x == 0 || x == 1){
            return x;
        }
        int sign=n < 0 ? 1:0;
        n= Math.abs(n);
        if(n%2==0)
        {
            double prod=myPow_2(x,n/2);
            result=prod*prod;
        }
        else
        {
            result=x*myPow_2(x,n-1);
        }

        return sign==1 && result!=0.0?1/result: result;
    }
    public static void main(String[] args){
        System.out.println(Math.abs(-2147483648));
        System.out.println("result:"+myPow(2.00000,2));
    }
}
