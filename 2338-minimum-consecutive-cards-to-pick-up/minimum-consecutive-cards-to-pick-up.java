class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;

    for (int i = 0; i < cards.length; i++) {
        int card = cards[i];
        if (map.containsKey(card)) {
            minLen = Math.min(minLen, i - map.get(card) + 1);
        }
        map.put(card, i);
    }

    return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
}

}