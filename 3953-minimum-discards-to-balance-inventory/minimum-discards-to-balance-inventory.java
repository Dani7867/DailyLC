class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int d = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arrivals.length; i++) {
            while (!q.isEmpty() && q.peek() <= i - w) {
                int idx = q.poll();
                map.put(arrivals[idx], map.get(arrivals[idx]) - 1);
            }
            int item = arrivals[i];
            if (map.getOrDefault(item, 0) == m) {
                d++;
            } else {
                q.add(i);
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
        }
        return d;
    }
}