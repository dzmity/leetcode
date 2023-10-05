import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] line = s.toCharArray();

        Map<Character, Integer> lastIndexPerChar = new HashMap<>();
        for (int i = 0; i < line.length; i++) {
            lastIndexPerChar.put(line[i], i);
        }

        List<Integer> result = new ArrayList<>();
        int leftPointer = -1;
        int rightPointer = 0;

        while (rightPointer < line.length) {
            char character = line[rightPointer];
            int lasIndex = lastIndexPerChar.get(character);
            while (rightPointer < lasIndex) {
                rightPointer++;
                char anotherChar = line[rightPointer];
                lasIndex = Math.max(lasIndex, lastIndexPerChar.get(anotherChar));
            }
            result.add(rightPointer - leftPointer);
            leftPointer = rightPointer;
            rightPointer++;
        }
        return result;
    }
}