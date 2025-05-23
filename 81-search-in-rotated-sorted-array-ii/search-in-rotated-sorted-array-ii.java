class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;

        int p = getPivot(nums, 0, nums.length - 1);
        if (p == -1) {
            return bs(nums, 0, nums.length - 1, target) >= 0;
        }
        if (p == 0 && nums[0] == target) return true;
        int e = bs(nums, 0, p, target);
        if (e == -1) {
            e = bs(nums, p + 1, nums.length - 1, target);
        }
        return e >= 0;
    }

    private int getPivot(int[] arr, int l, int r) {
    while (l <= r) {
        int mid = l + (r - l) / 2;

        // Check pivot at mid
        if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
            return mid;
        }

        // Check pivot at mid - 1
        if (mid > 0 && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        // Handle duplicates - carefully skip only if necessary
        if (arr[l] == arr[mid] && arr[mid] == arr[r]) {
            // Try to find pivot in both sides
            int leftPivot = getPivot(arr, l, mid - 1);
            if (leftPivot != -1) return leftPivot;
            return getPivot(arr, mid + 1, r);
        }

        // Right half is sorted, pivot in left half
        if (arr[mid] <= arr[r]) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return -1; // No rotation found
}


    private int bs(int[] arr, int l, int r, int t) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == t) {
                return mid;
            } else if (t > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}