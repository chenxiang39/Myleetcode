import java.util.ArrayList;
import java.util.List;

//dp(自顶向下)
//另一种方法（自底向上）：https://www.cnblogs.com/springfor/p/3887908.html
//时间复杂度:O(n^2),(等差数列) n为三角形的行数
//空间复杂度为O(n^2),每一行的每一个都要查看
public class Triangle_120_not_all_way {
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();     //记录每一个对应位置的最优解
        List<Integer> row = new ArrayList<>();          //记录当前行的情况
        int length = triangle.size();
        for(int i = 0; i < length; i++){
            if(i == 0){
                row = triangle.get(0);
            }
            else{
                int curSize = triangle.get(i).size();
                for(int j = 0; j < curSize; j++){
                    if(j == 0){
                        row.add(triangle.get(i).get(0) + dp.get(i - 1).get(j));
                        continue;
                    }
                    if(j == curSize - 1){
                        row.add(triangle.get(i).get(curSize - 1) + dp.get(i - 1).get(j - 1));
                        continue;
                    }
                    int aux = Math.min(dp.get(i - 1).get(j - 1),dp.get(i - 1).get(j));
                    row.add(aux + triangle.get(i).get(j));
                }
            }
            dp.add(new ArrayList<>(row));
            row.clear();
        }
        int size = dp.get(length - 1).size();
        int Min = dp.get(length - 1).get(0);
        for(int i = 1; i < size; i++){
            Min = Math.min(Min, dp.get(length - 1).get(i));         //返回dp中最下面一行的最小值
        }
        return Min;
    }
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int j = 2;
        for(int i = 1; i <= 4; i++){
            for(int q = 0; q < i; q++) {
                row.add(j);
                j++;
            }
            triangle.add(new ArrayList(row));
            row.clear();
        }
        System.out.println(minimumTotal(triangle));
    }
}
