class Solution {
    // https://ru.wikipedia.org/wiki/%D0%98%D0%BD%D0%B4%D0%B5%D0%BA%D1%81_%D0%A5%D0%B8%D1%80%D1%88%D0%B0
    // memory = O(N)
    // time = O(N)
    public int hIndex(int[] citations) {
        int[] papersNumberWithCitations = new int[citations.length + 1];

        for (int citation : citations) {
            int position = Math.min(citation, citations.length);
            papersNumberWithCitations[position]++;
        }

        int citationsNumber = 0;
        for (int i = papersNumberWithCitations.length - 1; i >= 0; i--) {
            citationsNumber += papersNumberWithCitations[i];
            if (citationsNumber >= i) {
                return i;
            }
        }
        return 0;
    }
}
