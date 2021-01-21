public class Subtract_the_Product_and_Sum_of_Digits_of_an_Integer_1281 {
    public int subtractProductAndSum(int n) {
        return getP(n) - getS(n);
    }
    //get Product
    public int getP(int n){
        int result = 1;
        int temp = 1;
        while(n != 0){
            temp = n%10;
            result *= temp;
            n = n/10;
        }
        return result;
    }
    //get Sum
    public int getS(int n){
        int result = 0;
        int temp = 0;
        while(n != 0){
            temp = n%10;
            result += temp;
            n = n/10;
        }
        return result;
    }
}
