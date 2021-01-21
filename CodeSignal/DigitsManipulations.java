import java.util.ArrayList;
import java.util.List;

public class DigitsManipulations {
    public static int digitsManipulations(int n){
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            int i = n % 10;
            list.add(i);
            n = n / 10;
        }
        int product = 1;
        int sum = 0;
        for(int i : list){
            product *= i;
            sum += i;
        }
        return product - sum;
    }
    public static void main(String[] args) {
        System.out.println(digitsManipulations(1010));
    }
}
