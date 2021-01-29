public class Number_of_Provinces_547_need_review {
    //union find
    //根据题目的要求进行union操作，然后返回component的数量
    public class unionFind{
        int[] id;       //root node
        int[] size;     //how many friend in this component
        int count;      //how many component
        public unionFind(int peopleNumber){
            id = new int[peopleNumber];
            size = new int[peopleNumber];
            for(int i = 0; i < peopleNumber; i++){
                id[i] = i;
                size[i] = 1;
            }
            count = peopleNumber;
        }
        public int root(int i){
            while(i != id[i] ){
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        public boolean isUnion(int i, int j){
            return root(i) == root(j);
        }
        public void union(int i, int j){
            int ir = root(i);
            int jr = root(j);
            if(ir == jr){
                return;
            }
            if(size[ir] > size[jr]){
                id[jr] = ir;
                count--;
            }
            else{
                id[ir] = jr;
                count--;
            }
        }
        public int getCount(){
            return count;
        }
    }
    public int findCircleNum(int[][] M) {
        unionFind uf = new unionFind(M.length);
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[i].length; j++){
                if(i == j){
                    continue;
                }
                if(M[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }
}
