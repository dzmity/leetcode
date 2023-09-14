import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(Arrays.asList(strs));
        }

        Map<String, List<String>> wordsBySortedString = new HashMap<>();
        for (String str : strs) {
            char[] copy = Arrays.copyOf(str.toCharArray(), str.length());
            Arrays.sort(copy);
            wordsBySortedString.merge(String.valueOf(copy), List.of(str), (list1, list2) -> {
                List<String> merge = new ArrayList<>(list1);
                merge.addAll(list2);
                return merge;
            });
        }
        return new ArrayList<>(wordsBySortedString.values());
    }
}