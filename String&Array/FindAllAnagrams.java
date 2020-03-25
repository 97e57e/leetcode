import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> list = solve(s, p);

        System.out.println(list);
    }

    public static List<Integer> solve(String s, String p){

        List<Integer> list = new ArrayList<>();
        int[] pArr = new int[256];
        for(int i=0; i<p.length(); i++){
            pArr[p.charAt(i)]++;
        }

        for(int i=0; i<s.length() - p.length() + 1; i++){
            int[] tArr = new int[256];
            for(int j=i; j<i+p.length(); j++){
                tArr[s.charAt(j)]++;
            }

            if(check(pArr, tArr)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean check(int[] pArr, int[] tArr){
        for(int i=0; i<pArr.length; i++){
            if(pArr[i] != tArr[i]) return false;
        }
        return true;
    }
}
