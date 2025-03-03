class Solution {
    public int[] pivotArray(int[] arr, int pivot) {
        int n = arr.length;
        int[] result = new int[n];
        int index = 0;

        // First pass: Add elements less than pivot
        for (int num : arr) {
            if (num < pivot) {
                result[index++] = num;
            }
        }

        // Second pass: Add elements equal to pivot
        for (int num : arr) {
            if (num == pivot) {
                result[index++] = num;
            }
        }

        // Third pass: Add elements greater than pivot
        for (int num : arr) {
            if (num > pivot) {
                result[index++] = num;
            }
        }

        // Copy back to original array to maintain in-place behavior
        System.arraycopy(result, 0, arr, 0, n);
        return arr;
    }
}
