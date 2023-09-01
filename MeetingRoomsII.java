import java.util.Arrays;
import java.util.PriorityQueue;
public class MeetingRoomsII {
    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i].end);
        }
        return minHeap.size();
    }
    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
        Interval[] intervals = {
                new Interval(1, 3),
                new Interval(8, 10),
                new Interval(7, 8),
                new Interval(9, 15),
                new Interval(2, 6),
        };
        int rooms = solution.minMeetingRooms(intervals);
        System.out.println("Minimum meeting rooms required: " + rooms);
    }
}
