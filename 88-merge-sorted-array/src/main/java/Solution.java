class Solution {

    public void mergeWithoutAdditionalMemory(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int resultPointer = m + n - 1;

        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }

        while (resultPointer >= 0) {
            if (pointer1 >= 0 && (pointer2 < 0 || nums1[pointer1] > nums2[pointer2])) {
                nums1[resultPointer] = nums1[pointer1];
                pointer1--;
            } else {
                nums1[resultPointer] = nums2[pointer2];
                pointer2--;
            }
            resultPointer--;
        }
    }

    public void mergeWithAdditionalMemory(int[] nums1, int m, int[] nums2, int n) {
        int[] resultArray = new int[nums1.length];
        int pointer1 = 0;
        int pointer2 = 0;
        int resultPointer = 0;

        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }

        while (resultPointer < m + n) {
            if (nums1[pointer1] <= nums2[pointer2] && pointer1 < m) {
                resultArray[resultPointer] = nums1[pointer1];
                pointer1++;
            } else {
                resultArray[resultPointer] = nums2[pointer2];
                pointer2++;
            }
            resultPointer++;
        }

        System.arraycopy(resultArray, 0, nums1, 0, resultArray.length);
    }
}
