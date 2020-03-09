import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeInterval {
    public static void main(String[] args) {
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(interval1);
        intervalList.add(interval2);
        intervalList.add(interval3);
        intervalList.add(interval4);

        MergeInterval mg = new MergeInterval();

        List<Interval> answer = mg.solve(intervalList);

        for(int i=0; i<answer.size(); i++){
            System.out.printf( "%d, %d\n", answer.get(i).start, answer.get(i).end);
        }

    }

    public List<Interval> solve(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> answer = new ArrayList<>();
        Interval before = intervals.get(0);
        for (int i=1; i<intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(before.end >= current.start) {
                current.start = before.start;
                current.end = Math.max(current.end, before.end);
            } else {
                answer.add(before);
                before = current;
            }
        }

        if(!answer.contains(before)) {
            answer.add(before);
        }

        return answer;
    }
}