import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        int minEle = Integer.MAX_VALUE;

        for (int ele : basket1) {
            minEle = Math.min(minEle, ele);
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int ele : basket2) {
            minEle = Math.min(minEle, ele);
            map.put(ele, map.getOrDefault(ele, 0) - 1);
        }

        List<Integer> l = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value % 2 != 0) {
                return -1;
            }

            for (int c = 1; c <= Math.abs(value) / 2; c++) {
                l.add(key);
            }
        }

        Collections.sort(l);
        long result = 0;
        for (int i = 0; i < l.size() / 2; i++) {
            result += Math.min(l.get(i), (long)minEle * 2);
        }
        return result;
    }
}