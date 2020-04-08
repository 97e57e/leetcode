package leetcode.linkedList;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers_나의풀이 {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        list1.add(2);
        list1.add(4);
        list1.add(3);

        list2.add(5);
        list2.add(6);
        list2.add(4);

        int answer = solve(list1, list2);
        System.out.println(answer);
    }

    public static int solve(List<Integer> list1, List<Integer> list2) {
        int answer = 0;
        int upper = 0;
        List<Integer> answerList = new LinkedList<>();

        for (int i=0; i<list1.size(); i++) {
            int sum = list1.get(i) + list2.get(i) + upper;
            upper = 0;
            if (sum >= 10) {
                sum -= 10;
                upper ++;
            }
            answerList.add(sum);
        }

        if (upper == 1) {
            answerList.add(1);
        }

        Iterator<Integer> iter = answerList.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        for (int i=answerList.size() - 1; i >=0; i--) {
            answer *= 10;
            answer += answerList.get(i);
        }

        return answer;
    }
}
