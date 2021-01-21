import java.util.ArrayList;
import java.util.List;

//recursion way
//时间复杂度：O(numRows ^ 2),等差数列
//空间复杂度：O(numRows ^ 2), 开辟了满足计算等差数列的空间
public class Pascal_Triangle_118_not_all_way {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }
        List<Integer> pre = new ArrayList<>();      //上一层的信息
        List<Integer> cur = new ArrayList<>();      //本层的信息
        pre.add(1);     //从第一层开始
        recursion(result,pre,numRows,cur);
        return result;
    }
    public void recursion(List<List<Integer>> result, List<Integer> pre, int numRows, List<Integer> cur){
        int size = pre.size();
        result.add(new ArrayList(pre));
        //result中的数量跟numRows一样就结束循环
        if(result.size() == numRows){
            return;
        }
        for(int i = 0; i < size + 1; i++){
            //首尾为1
            if(i == 0 || i == size){
                cur.add(1);
            }
            //中间跟上一层的关系与动画一样
            else{
                int a = pre.get(i - 1);
                int b = pre.get(i);
                cur.add(a + b);
            }
        }
        //递归进下一层的计算
        recursion(result, cur, numRows, new ArrayList<>());
    }
}
