class Solution {

    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash stones
        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest

            // If not equal, add remaining stone
            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        // Return remaining stone or 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}