import java.util.Arrays;
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
            new Interval(1, 3),
            new Interval(2, 6),
            new Interval(8, 10),
            new Interval(15, 18)
        };
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int maxNonOverlappingIntervals = 0;
        int currentEnd = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start > currentEnd) {
                maxNonOverlappingIntervals++;
                currentEnd = intervals[i].end;
            }
        }
        System.out.println("The maximum number of non-overlapping intervals is " + maxNonOverlappingIntervals);
    }
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
