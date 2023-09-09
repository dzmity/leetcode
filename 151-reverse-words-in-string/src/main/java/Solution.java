class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(words[0]);
            } else {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWordsUsingTwoPointers(String s) {
        int startWordPointer = -1;
        int endWordPointer = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                if (endWordPointer == -1) {
                    if (i == 0) {
                        sb.append(s, 0, 1);
                    } else {
                        endWordPointer = i;
                        startWordPointer = i;
                    }
                } else if (i == 0) {
                    sb.append(s, 0, endWordPointer + 1);
                } else {
                    startWordPointer = i;
                }
            } else {
                if (endWordPointer == -1) {
                    // continue
                } else {
                    sb.append(s, startWordPointer, endWordPointer + 1);
                    sb.append(" ");
                    startWordPointer = -1;
                    endWordPointer = -1;
                }
            }
        }
        return sb.toString().trim();
    }
}
