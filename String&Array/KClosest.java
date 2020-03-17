import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Point {
    int x;
    int y;

    public Point() {}

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class KClosest {
    public static void main(String[] args) {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(-2, 2);

        Point[] points = {p1, p2};
        int k = 1;

        Point answer = solve(points, k);

        System.out.println(answer.x);
        System.out.println(answer.y);

    }

    public static Point solve(Point[] points, int k){
        Point result = new Point();
        Queue<Point> pq = new PriorityQueue<Point>(points.length, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return  ((o1.x * o1.x) + (o1.y * o1.y)) - ((o2.x * o2.x) + (o2.y * o2.y));
            }
        });

        for(int i = 0; i<points.length; i++){
            pq.offer(points[i]);
        }

        for(int i=0; i<k; i++){
            result = pq.poll();
        }

        return result;
    }
}
