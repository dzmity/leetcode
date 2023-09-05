class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            rotateLastElement(nums);
        }
    }

    public void rotateUsingTwoPointers(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length -1 );
    }

    private void reverse(int[] nums, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            int tempStore = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer]= tempStore;
            leftPointer++;
            rightPointer--;
        }
    }

    private void rotateLastElement(int[] nums) {
        int store = nums[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            int tempStore = nums[i];
            nums[i] = store;
            store = tempStore;
        }
    }
}
