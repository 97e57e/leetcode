package leetcode;

public class LicenseKeyFormatting_나의풀이 {
    public static void main(String[] args) {
        String str = "8F3Z-2e-9-w";
        String str2 = "8-5g-3-J";
        int k = 4;
        String result = solve(str, k);
        System.out.println(new StringBuffer(result).reverse().toString());

    }

    public static String solve(String s, int k) {
        String result = "";
        int count = 0;
        s = s.replace("-", "");
        for(int i=s.length()-1; i>=0; i--){
            if(count==k){
                result = result.concat("-");
                count=0;
            }
            result = result.concat(Character.toString(s.charAt(i)));
            count ++;
        }

        return result.toUpperCase();
    }
}
