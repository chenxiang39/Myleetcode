import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://blog.csdn.net/mine_song/article/details/70207326
public class Valid_Sudoku_36_not_all_way {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // 检查第i行，在横坐标位置
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                // 检查第i列，在纵坐标位置
                if (board[j][i] != '.' && !column.add(board[j][i]))
                    return false;
                // 行号+偏移量
                int RowIndex = 3 * (i / 3) + j / 3;
                // 列号+偏移量
                int ColIndex = 3 * (i % 3) + j % 3;
                //每个小九宫格，总共9个（第i个九宫格）
                if (board[RowIndex][ColIndex] != '.' && !cube.add(board[RowIndex][ColIndex]))
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
//        //HashMap和HashSet的介绍
//        HashMap<Integer,Character> map = new HashMap<>();
//        System.out.println(map.put(1,'1'));
//        System.out.println(map.put(1,'2'));
//        System.out.println(map.put(1,'3'));     //返回原来键为1的值并改为新的内容
//        System.out.println(map.get(1)); //键被代替
//        //利用set的add函数解此题
//        HashSet<Character> set = new HashSet<>();
//        System.out.println(set.add('1'));       //不存在时add即返回true
//        System.out.println(set.add('2'));
//        System.out.println(set.add('1'));       //set中存在时返回false
        for (int i = 1; i < 2; i++){
            for (int j = 0; j < 9; j++){
                int RowIndex = 3 * (i / 3) + j / 3;
                // 列号+偏移量
                int ColIndex = 3 * (i % 3) + j % 3;
                System.out.print("RowIndex:" + RowIndex +" ");
                System.out.print("ColIndex:" + ColIndex);
                System.out.println();
            }
        }
    }
}
