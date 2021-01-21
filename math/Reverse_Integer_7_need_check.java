public class Reverse_Integer_7_need_check {
    public static int reverse(int x) {
        int length = String.valueOf(x).length();
        if (x < 0){
            length--;       //负数时，算位数会多一位
        }
        double answ = 0;        //防止结果超过限定值，故用double
        int res = x;
        int aux;
        for (int i = 1; i <= length; i++){
            aux = res%10;       //除10取余数可的位数
            res = res/10;       //基数不断除10
            answ += aux * Math.pow(10 , length - i);
        }
        if(answ >= Math.pow(2,31) ||answ < - Math.pow(2,31)){       //超过范围则输出0
            return 0;
        }
        return (int)answ;
    }
    public static void main(String [] args){
        System.out.println(reverse(1234));
    }
}
