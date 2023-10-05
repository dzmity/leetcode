import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        if (words.length == k) {
            Arrays.sort(words);
            return Arrays.asList(words);
        }

        Map<String, Integer> countPerWord = new HashMap<>();

        for (String word : words) {
            countPerWord.merge(word, 1, Integer::sum);
        }

        // Standard comparator is slower than manually written bellow
        Comparator<Map.Entry<String, Integer>> comparator =
                Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey());

        Comparator<Map.Entry<String, Integer>> fastComparator = (e1, e2) -> {
            String k1 = e1.getKey();
            String k2 = e2.getKey();
            int v1 = e1.getValue();
            int v2 = e2.getValue();

            int diff = v2 - v1;
            return diff == 0 ? k1.compareTo(k2) : diff;
        };


        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(fastComparator);
        queue.addAll(countPerWord.entrySet());

        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(queue.poll().getKey());
            k--;
        }

        return result;
    }
}
