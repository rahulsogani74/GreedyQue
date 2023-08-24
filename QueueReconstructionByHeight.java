import java.util.*;
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        int n = people.length;
        return res.toArray(new int[n][2]);
    }
    public static void main(String[] args) {
        QueueReconstructionByHeight solution = new QueueReconstructionByHeight();
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        int[][] reconstructedQueue = solution.reconstructQueue(people);
        for (int[] person : reconstructedQueue) {
            System.out.println(Arrays.toString(person));
        }
    }
}
