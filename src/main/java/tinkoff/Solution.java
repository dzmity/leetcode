package tinkoff;

public class Solution {
    private static final int NO_RESULT = -1;

    public static void main(String[] args) {
        System.out.println(findCommonNumber(new int[] {1,2,4,4,6}, new int[] {3,3,5,7}, new int[] {2,3,4,5,6}));
    }

    public static int findCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        int startRangeElement = Math.max(Math.max(arr1[0], arr2[0]), arr3[0]);
        int endRangeElement = Math.min(Math.min(arr1[arr1.length - 1], arr2[arr2.length - 1]), arr3[arr3.length - 1]);

        if (endRangeElement < startRangeElement) {
            return NO_RESULT;
        }

        if (endRangeElement == startRangeElement) {
            return endRangeElement;
        }

        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;
        int potentialCandidate = startRangeElement;

        while (pointer1 < arr1.length && pointer2 < arr2.length && pointer3 < arr3.length) {
            pointer1 = findFirstPositionWithEqualOrGreaterElement(pointer1, arr1, potentialCandidate);
            pointer2 = findFirstPositionWithEqualOrGreaterElement(pointer2, arr2, potentialCandidate);
            pointer3 = findFirstPositionWithEqualOrGreaterElement(pointer3, arr3, potentialCandidate);

            if (pointer1 == arr1.length || pointer2 == arr2.length || pointer3 == arr3.length) {
                return NO_RESULT;
            }

            int value1 = arr1[pointer1];
            int value2 = arr2[pointer2];
            int value3 = arr3[pointer3];

            if (value1 == value2 && value1 == value3) {
                return value1;
            }

            potentialCandidate = Math.max(Math.max(value1, value2), value3);
            if (potentialCandidate > endRangeElement) {
                return NO_RESULT;
            }
        }
        return NO_RESULT;
    }

    private static int findFirstPositionWithEqualOrGreaterElement(int startPosition, int[] array, int element) {
        for (int i = startPosition; i < array.length; i++) {
            if (array[i] >= element) {
                return i;
            }
        }
        return array.length;
    }
}
