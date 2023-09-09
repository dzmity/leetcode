public class Solution {
    public int lengthOfLastWordSlowSolution(String s) {
        String[] words = s.split("\\s+");
        return words[words.length - 1].length();
    }

    public int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();
        int startPoint = 0;
        int endPoint = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char currentSymbol = charArray[i];
            if (startPoint == 0 && currentSymbol != ' ') {
                startPoint = i;
                endPoint = i;
            } else if (currentSymbol != ' ') {
                endPoint = i;
            } else if (endPoint == 0){
                // continue;
            } else {
                break;
            }
        }
        return startPoint  - endPoint + 1;
    }
}
