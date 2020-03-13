public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String str = "8F3Z-2e-9-w2";

        int k = 4;

        String result = solve(str, k);
        System.out.println(result);
    }

    public static String solve(String s, int k) {
        StringBuilder sb = new StringBuilder();

        s = s.replace("-", "");
        s = s.toUpperCase();

        int leng = s.length();

        for(int i=0; i<leng; i ++){
            sb.append(s.charAt(i));
        }

        for(int i=k; i<leng; i=i+k){
            sb.insert(leng-i, '-');
        }

        return sb.toString();
    }
}
