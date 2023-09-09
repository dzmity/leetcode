import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    private static Map<Integer, String> map = new HashMap<>();
    private static int[] valuesDesc = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int value : valuesDesc) {

            if (value > num) {
                continue;
            }

            int number = num / value;
            if (number > 0) {
                String roman = map.get(value);
                num = num % value;
                result.append(prepareRomanSymbolsV2(number, roman));
                if (num == 0) {
                    break;
                }
            }
        }
        return result.toString();
    }

    private static String prepareRomanSymbols(int number, String roman) {
        return IntStream.range(0, number)
                .mapToObj(i -> roman)
                .collect(Collectors.joining(""));
    }

    private static String prepareRomanSymbolsV2(int number, String roman) {
        String result = "";
        for (int i = 0; i < number; i++) {
            result += roman;
        }
        return result;
    }
}
