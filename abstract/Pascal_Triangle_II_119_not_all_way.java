import java.util.ArrayList;
import java.util.List;

//Memory-efficient Dynamic Programming
//leetcode approach 3
//Time complexity : O(k^2), k = rowIndex; 等差数列求和
//Space complexity : O(k). No extra space is used other than that required to hold the output.
public class Pascal_Triangle_II_119_not_all_way {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if(rowIndex == 0){
            return result;      //注意，当rowIndex == 0 ,需要输出[1];
        }
        for(int i = 1; i <= rowIndex; i++){
            result.add(1);
            for(int j = i - 1; j >= 1;j--){
                int a = result.get(j);
                int b = result.get(j - 1);
                result.set(j, a + b);
            }
        }
        return result;
    }
}
