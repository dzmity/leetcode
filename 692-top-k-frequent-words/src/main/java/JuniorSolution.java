import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class JuniorSolution {

    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> result = topKFrequent(words, 4);
        System.out.println(result);
    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> countPerWord = new HashMap<>();
        Map<Integer, Set<String>> wordsPerCount = new HashMap<>();

        for (String word : words) {
            Integer count = countPerWord.get(word);
            Set<String> singleton = new HashSet<>();
            singleton.add(word);

            if (count == null) {
                countPerWord.put(word, 1);
                wordsPerCount.merge(1, singleton, (set1, set2) -> {
                            set1.addAll(set2);
                            return set1;
                        }
                );
            } else {
                countPerWord.put(word, count + 1);
                wordsPerCount.get(count).remove(word);
                wordsPerCount.merge(count + 1, singleton, (set1, set2) -> {
                            set1.addAll(set2);
                            return set1;
                        }
                );
            }
        }

        List<Integer> keysForResult = new ArrayList<>();
        int temp = 0;
        TreeSet<Integer> numbers = new TreeSet<>(wordsPerCount.keySet());
        Iterator<Integer> descendingIterator = numbers.descendingIterator();
        while (temp < k) {
            Integer number = descendingIterator.next();
            keysForResult.add(number);
            temp += wordsPerCount.get(number).size();
        }

        List<String> result = new ArrayList<>();
        for (int count : keysForResult) {
            TreeSet<String> sortedWords = new TreeSet<>(wordsPerCount.get(count));
            for (String word : sortedWords) {
                result.add(word);
                if (result.size() == k) {
                    break;
                }
            }
        }

        return result;
    }
}