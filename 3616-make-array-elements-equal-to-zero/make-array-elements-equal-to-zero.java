class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            if (nums[start] != 0) continue;

            // Try both directions: -1 (left), +1 (right)
            if (isValid(nums, start, 1)) count++;
            if (isValid(nums, start, -1)) count++;
        }

        return count;
    }

    private boolean isValid(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();
        int curr = start;
        int d = dir;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += d;
            } else {
                arr[curr]--;
                d *= -1;
                curr += d;
            }
        }

        // check if all values are 0
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
        }
    }



