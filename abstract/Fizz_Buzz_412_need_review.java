import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz_412_need_review {
    //直接按题意做
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if((i + 1)% 3 == 0 && (i + 1) % 5 != 0){
                result.add(i,"Fizz");
            }
            else if((i + 1)% 3 != 0 && (i + 1) % 5 == 0){
                result.add(i,"Buzz");
            }
            else if((i + 1) % 3 == 0 && (i + 1) % 5 == 0){
                result.add(i,"FizzBuzz");
            }
            else{
                result.add(i,String.valueOf(i + 1));
            }
        }
        return result;
    }
}
