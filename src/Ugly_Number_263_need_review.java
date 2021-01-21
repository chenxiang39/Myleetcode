public class Ugly_Number_263_need_review {
    //查找是否能被2或3或5除，直到发现除不进就返回false,如果最后得到了1，就是true
    public boolean isUgly(int num) {
        if(num == 0){
            return false;
        }
        while(num != 1){
            if(num % 2 == 0){
                num /= 2;
            }
            else if(num % 3 == 0){
                num /= 3;
            }
            else if(num % 5 == 0){
                num /= 5;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
