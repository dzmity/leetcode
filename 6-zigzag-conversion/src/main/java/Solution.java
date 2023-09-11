import java.util.function.BiFunction;

class Solution {

    public String convert(String s, int numRows) {

        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        BiFunction<Integer, Integer, Integer> cornerPositionFunction = (rowNumber, i) -> rowNumber + (2 * numRows - 2) * i;
        BiFunction<Integer, Integer, Integer> intermediatePositionFunction1 = (rowNumber, i) -> rowNumber + (2 * numRows - 2) * i;
        BiFunction<Integer, Integer, Integer> intermediatePositionFunction2 = (rowNumber, i) -> (2 * numRows - 2) * (i + 1) - rowNumber;

        StringBuilder sb = new StringBuilder();

        for (int rowNumber = 0; rowNumber < numRows; rowNumber++) {
            int i = 0;

            if (rowNumber == 0 || rowNumber == numRows - 1) {
                while (true) {
                    int index = cornerPositionFunction.apply(rowNumber, i);
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
                        i++;
                    } else {
                        break;
                    }
                }
            } else {
                while (true) {
                    int index1 = intermediatePositionFunction1.apply(rowNumber, i);
                    int index2 = intermediatePositionFunction2.apply(rowNumber, i);
                    if (index2 < s.length()) {
                        sb.append(s.charAt(index1));
                        sb.append(s.charAt(index2));
                        i++;
                    } else if (index1 < s.length()) {
                        sb.append(s.charAt(index1));
                        break;
                    } else {
                        break;
                    }
                }
            }

        }
        return sb.toString();
    }
}
