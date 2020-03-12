import java.util.*;

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

public class MeetingRoom2 {
    public static void main(String[] args) {
        Interval in1 = new Interval(0, 30);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(15, 20);

        List<Interval> inList = new ArrayList<>();
        inList.add(in1);
        inList.add(in2);
        inList.add(in3);

        MeetingRoom2 mr2 = new MeetingRoom2();

        int answer = mr2.solve(inList);
        System.out.println(answer);
    }

    public int solve(List<Interval> intervals) {
        if (intervals == null){
            return 0;
        }

        int result = 0;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Queue<Interval> priorityQueue = new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        priorityQueue.offer(intervals.get(0));

        for(int i=1; i<intervals.size(); i++) {
            Interval interval = priorityQueue.poll();
            if(intervals.get(i).start < interval.end) {
                priorityQueue.offer(intervals.get(i));
            }
            priorityQueue.offer(interval);
        }

        return priorityQueue.size();
    }
}
