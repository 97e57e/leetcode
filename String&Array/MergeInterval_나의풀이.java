package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval_나의풀이 {
    public static void main(String[] args) {
//        int[][] input = {{1, 3},
//                         {2, 6},
//                         {8, 10},
//                         {15, 18}};
        int[][] input = {{5,13}, {1,10}, {2,11}};
        ArrayList<Integer[]> arrList = new ArrayList<Integer[]>();
        MergeInterval_나의풀이 mi = new MergeInterval_나의풀이();

        mi.solve(input, arrList);

        for(Integer[] item : arrList) {
            System.out.println(Integer.toString(item[0]) + Integer.toString(item[1]));
        }
    }

    public ArrayList<Integer[]> solve(int[][] input, ArrayList<Integer[]> arrList) {
        System.out.println(input.length);
        // sort
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<input.length-1; i++) {
            if (input[i][1] < input[i+1][0]) {
                Integer[] tmp = new Integer[2];
                tmp[0] = input[i][0];
                tmp[1] = input[i][1];
                arrList.add(tmp);
            } else {
                input[i+1][0] = input[i][0];
            }
        }

        Integer[] tmp = new Integer[2];

        tmp[0] = input[input.length-1][0];
        tmp[1] = input[input.length-1][1];

        arrList.add(tmp);

        return arrList;
    }
}
