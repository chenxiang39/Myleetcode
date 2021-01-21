public class checkOperation {
    public static boolean[] checkoperation(int[] a, int[] b, int[] c, char[] signs){
        boolean[] result = new boolean[a.length];
        for(int i = 0; i < a.length; i++){
            int ai = a[i];
            int bi = b[i];
            int ci = c[i];
            char s = signs[i];
            if(s == '+'){
                result[i] = ai + bi == ci;
            }
            else if(s == '-'){
                result[i] = ai - bi == ci;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {3,2,-1,4};
        int[] b = {2,7,-5,2};
        int[] c = {5,5,4,2};
        char[] signs = {'+','-','-','+'};
        boolean[] r = checkoperation(a,b,c,signs);
        for(boolean s : r) {
            System.out.println(s);
        }
    }
}
