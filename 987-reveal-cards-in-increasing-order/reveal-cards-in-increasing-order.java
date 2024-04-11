class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        // Queue<Integer> q = new LinkedList();
        Arrays.sort(deck);
        // System.out.println(Arrays.toString(deck));
        List<Integer> res = new ArrayList();
        int i=n-1;
        while(i>=0) {
            if(!res.isEmpty()) {
                int lastElement = res.remove(res.size() - 1);
                res.add(0, lastElement);
            }
            res.add(0, deck[i]);
            i--;
        } 
        int[] res1 = new int[n];
        for(int j=0; j<n; ++j) {
            res1[j] = res.get(j);
        }
        return res1;
    }
}