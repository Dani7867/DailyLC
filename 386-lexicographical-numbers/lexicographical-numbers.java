class Solution {
    private List<Integer> order;
    public List<Integer> lexicalOrder(int n) {
		order = new ArrayList<>();
		getLexographicalOrder(n, 1);
        return order;
    }

	private void getLexographicalOrder(int n, int base) {
		if (base > n) {
			return;
		}
		order.add(base);
		getLexographicalOrder(n, base * 10);
		getLexographicalOrder(n, base * 10 + 1);
		if (base % 10 == 1) {
			for (int I = 1; I < 9; I++) {
				getLexographicalOrder(n, base + I);
			}
		}
	}
}