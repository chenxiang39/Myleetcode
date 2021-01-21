public class Design_Add_and_Search_Words_Data_Structure_211_very_important {
    class TriesNode{
        boolean isWord;
        TriesNode[] children;
        public TriesNode(){
            isWord = false;
            children = new TriesNode[26];
        }
    }

    TriesNode root;
    //add操作时间复杂度O(n), 空间复杂度O(n)，
    //search操作时间复杂度O(n * m)（有.）(要检查每种可能) ， O(n)(无.), 空间复杂度O(1), 其中 n为单词长度, m为单词个数
    public Design_Add_and_Search_Words_Data_Structure_211_very_important() {
        root = new TriesNode();
    }

    /** Adds a word into the data structure. */

    public void addWord(String word) {
        TriesNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                TriesNode children = new TriesNode();
                cur.children[c - 'a'] = children;
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchTries(word,0,root);
    }

    private boolean searchTries(String word, int i, TriesNode node){
        if(node == null){
            return false;
        }
        //如果遍历完了
        if(i == word.length()){
            return node.isWord;
        }
        char c = word.charAt(i);
        if(c != '.'){
            return searchTries(word, i + 1, node.children[c- 'a']);
        }
        //如果是.，就需要寻找接下来的每一个可能的路径
        else{
            for(int j = 0; j < 26; j++){
                //有一条路径能全部找到，就是true
                if(searchTries(word, i + 1, node.children[j])){
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args){
        Design_Add_and_Search_Words_Data_Structure_211_very_important obj = new Design_Add_and_Search_Words_Data_Structure_211_very_important();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("czx");
        System.out.println(obj.search(".zx"));
    }
}
