import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public static List<Integer> partitionLabels (String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }
        List<Integer> res = new ArrayList<>();
        int pre = -1;
        int max = 0;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if (max == i){
                res.add(max - pre);
                pre = max;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String input = "ababcbacadefegdehijhklij";
        List<Integer> partitions = partitionLabels(input);
        System.out.println(partitions);
    }
}
