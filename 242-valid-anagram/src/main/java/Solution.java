class Solution {
    private static final int ALPHABET_SIZE = 26;
    private static final char FIRST_LETTER = 'a';

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int [] lettersCount = new int[26];

        for (int i = 0; i < sArray.length; i++) {
            lettersCount[sArray[i] - FIRST_LETTER] ++;
            lettersCount[tArray[i] - FIRST_LETTER] --;
        }

        for (int count : lettersCount) {
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
