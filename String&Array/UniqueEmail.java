import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
    public static void main(String[] args) {
        String[] emails = {
                "khjvvv7@naver.com",
                "khj.vvv7+123@naver.com",
                "khjvvv8@naver.com",
                "khjvvv7@naver.com",
                "khjvvv+7@naver.com",
        } ;

        int answer = solve(emails);
        System.out.println(answer);
    }

    public static int solve(String[] emails) {
        Set<String> em = new HashSet<String>();

        for(String email : emails) {
            String local = email.split("@")[0];
            String domain = email.split("@")[1];

            local = local.replace(".", "").split("\\+")[0];
            em.add(local+domain);
        }


        return em.size();
    }
}
