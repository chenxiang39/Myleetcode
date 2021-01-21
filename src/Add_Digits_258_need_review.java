public class Add_Digits_258_need_review {
    //一直处理知道最后的数字小于10（只有1位）
    public int addDigits(int num) {
        while(num >= 10){
            num = solve(num);
        }
        return num;
    }
    //将每个位相加
    public int solve(int n){
        int result = 0;
        while(n > 0){
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}
