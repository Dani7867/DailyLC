class Solution {
    public int[] pivotArray(int[] arr, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {
            if (num < pivot) {
                left.add(num);
            } else if (num == pivot) {
                middle.add(num);
            } else {
                right.add(num);
            }
        }

        int i = 0;
        for (int num : left) arr[i++] = num;
        for (int num : middle) arr[i++] = num;
        for (int num : right) arr[i++] = num;

        return arr;
    }
}
