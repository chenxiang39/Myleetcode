import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses_93_very_important {
    //dfs
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(result, s,0 ,"");
        return result;
    }
    public static void dfs(List<String> result, String s, int count, String cur)
    {
        // 剪枝，因ip不会超过三位(留的字符串不能太长，否则必有一段超过三位)
        if(s.length() > 3 * (4 - count)){
            return;
        }
        if(count == 4){
            // 去掉最后一个'.'
            result.add(cur.substring(0,cur.length() - 1));
            return;
        }
        for(int i = 1; i <= 3; i++){
            // 如果剩余的长度还不够k那么说明不能排列成ip,比如i为三，但只剩下2个字符
            if(s.length() < i){
                break;
            }
            int val = Integer.parseInt(s.substring(0,i));       //截取子字符串
            // k != String.valueOf(val).length(),为了避免前导0情况,比如010 => 不合法
            if (val > 255 || String.valueOf(val).length() != i){
                continue;
            }
            //s.substring(i),即字符串截掉前i个字符
            //s.substring(0,i),即保存字符串前i个字符
            dfs(result, s.substring(i), count + 1,cur + s.substring(0,i) + ".");
        }
    }
    //StringBuilder优化
    public static List<String> restoreIpAddresses_2(String s) {
        List<String> result = new ArrayList<>();
        dfs_2(result, s,0 ,new StringBuilder());
        return result;
    }
    public static void dfs_2(List<String> result, String s, int count, StringBuilder cur)
    {
        if(s.length() > 3 * (4 - count)){
            return;
        }
        if(count == 4){
            result.add(cur.substring(0,cur.length() - 1));
            return;
        }
        for(int i = 1; i <= 3; i++){
            if(s.length() < i){
                break;
            }
            int val = Integer.parseInt(s.substring(0,i));
            if (val > 255 || String.valueOf(val).length() != i){
                continue;
            }
            cur.append(s.substring(0,i) + ".");
            dfs_2(result, s.substring(i), count + 1, cur);
            cur.delete(cur.length() - i - 1, cur.length());         //删除之前添加的i+1个字符（+1因为有"."）
        }
    }
    public static void main(String[] args){
        String s ="25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
