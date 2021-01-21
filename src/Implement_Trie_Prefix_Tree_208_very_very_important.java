public class Implement_Trie_Prefix_Tree_208_very_very_important {
    //Ternary Search Tree（三叉树）  https://www.cnblogs.com/rush/archive/2012/12/30/2839996.html
    //使用了coursera上的实现方式(时间复杂度见coursera第十周)
//    public class TreeNode{
//        int val = 0;        //默认为0
//        Character c;
//        TreeNode left;
//        TreeNode middle;
//        TreeNode right;
//        TreeNode(){};
//        TreeNode(char c){
//            this.c = c;
//        }
//    }
//    private TreeNode root;
//    public Implement_Trie_Prefix_Tree_208_very_very_important() {
//
//    }
//
//    /** Inserts a word into the trie. */
//    public TreeNode insertString(String str, TreeNode node, int val, int d){
//        char c = str.charAt(d);
//        if(node == null){
//            node = new TreeNode(c);
//        }
//        if(c < node.c){
//            node.left = insertString(str, node.left, val,d);
//        }
//        else if(c > node.c){
//            node.right = insertString(str, node.right, val,d);
//        }
//        //当前点成功加入，下一个点继续遍历middle
//        else{
//            if(d < str.length() - 1){
//                node.middle = insertString(str, node.middle, val, d + 1);
//            }
//            else{
//                node.val = val;     //插入的单词的最后节点值设置为1
//            }
//        }
//        return node;
//    }
//    public TreeNode searchString(String str, TreeNode node, int d){
//        if(node == null){
//            return null;
//        }
//        char c = str.charAt(d);
//        if(c < node.c){
//            return searchString(str,node.left,d);
//        }
//        else if(c > node.c){
//            return searchString(str,node.right,d);
//        }
//        //查到了当前的点,则继续遍历middle
//        else{
//            if(d < str.length() - 1){
//                return searchString(str, node.middle, d + 1);
//            }
//            else{
//                return node;
//            }
//        }
//    }
//    public void insert(String word) {
//        root = insertString(word, root, 1, 0);
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        TreeNode targetNode = searchString(word, root, 0);
//        if(targetNode == null || targetNode.val == 0){
//            return false;
//        }
//        else{                   //遍历到val为1，则说明含这个单词
//            return true;
//        }
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TreeNode targetNode = searchString(prefix, root, 0);
//        if(targetNode == null){
//            return false;
//        }
//        else{
//            return true;
//        }
//    }
    //https://www.bilibili.com/video/BV1hA411t7kR
    //时间复杂度：O(单词的长度)
    //传统R - way Tries tree
    class TriesNode{
        boolean isWord;
        TriesNode[] children;
        public TriesNode(){
            isWord = false;     //默认不是单词
            children = new TriesNode[26];
        }
    }
    TriesNode root;
    public Implement_Trie_Prefix_Tree_208_very_very_important() {
        root = new TriesNode();
    }
    public void insert(String word) {
        TriesNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){      //如果是空
                TriesNode aux = new TriesNode();        //创建孩子节点
                cur.children[c - 'a'] = aux;
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TriesNode cur = root;
        for (int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TriesNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}
