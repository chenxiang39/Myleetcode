public class gravity {
    public static char[][] helper(char[][] g){
        int n = g.length;
        int n0 = g[0].length;
        boolean flag = true;
        int botDis = 0;     //探测底部，以免触底
        boolean botF = true;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < n0; j++){
                if(g[i][j] == 'F'){
                   botF = false;
                }
            }
            if(botF){
                botDis++;
            }
            else {
                break;
            }
        }
        int downCount = 0;
        while(downCount < botDis && flag){
            for(int i = 0; i < n - 1; i++){
                for(int j = 0; j < n0; j++){
                    if(g[i][j] == 'F'&& g[i + 1][j] == '#'){
                        flag = false;
                        break;
                    }
                }
            }
            if(downCount < botDis && flag){
                g = downOne(g);
                downCount++;
            }
        }
        return g;
    }
    public static char[][] downOne(char[][] g){
        int n = g.length;
        int n0 = g[0].length;
        char[][] result = new char[n][n0];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n0; j++){
                result[i][j] = '.';
            }
        }
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n0; j++){
                if(g[i][j] == 'F'){
                    result[i + 1][j] = 'F';
                }
                else if(g[i][j] == '#'){
                    result[i][j] = '#';
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        char[][] g = {
                {'F','F','F'},
                {'.','F','.'},
                {'F','F','F'},
                {'.','F','.'},
                {'.','F','.'},
                {'.','F','.'},
                {'.','.','#'},
                {'.','.','.'},
        };
        g = helper(g);
        int n = g.length;
        int n0 = g[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n0; j++){
               System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }
}
