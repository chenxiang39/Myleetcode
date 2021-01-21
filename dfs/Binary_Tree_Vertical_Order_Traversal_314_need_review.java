import java.util.*;

public class Binary_Tree_Vertical_Order_Traversal_314_need_review {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    public class Pairs{
        int x;
        int y;
        Pairs(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //记录每个点相对数的根的位置，题意要求展示的点按x从小到大排布，x相同的情况下，y从大到小排布
        //key -> x坐标，value ->一组pairs, pairs中的x和y分别对应(y坐标，节点对应的值)
        TreeMap<Integer, List<Pairs>> map = new TreeMap<>();//使用treeMap将自动使内容按x坐标从小到大排布
        dfs(map, 0, 0, root);
        //遍历每个x坐标
        for(Integer c : map.keySet()){
            List<Integer> cur = new ArrayList<>();
            //y坐标按大到小排序
            Collections.sort(map.get(c), new Comparator<Pairs>() {
                public int compare(Pairs o1, Pairs o2) {
                    return o2.x - o1.x;
                }
            });
            for(Pairs p : map.get(c)){
                cur.add(p.y);
            }
            result.add(cur);
        }
        return result;
    }

    public void dfs( TreeMap<Integer, List<Pairs>> map, int x, int y, TreeNode root){
        if(root == null){
            return;
        }
        if(!map.containsKey(x)){
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(new Pairs(y,root.val));
        //左子树深度搜索
        dfs(map, x - 1, y - 1, root.left);
        //右子树深度搜索
        dfs(map, x + 1, y - 1, root.right);
    }
}
