import java.util.*;

class MedianFinder {

    // Max Heap (smaller half)
    PriorityQueue<Integer> small;

    // Min Heap (larger half)
    PriorityQueue<Integer> large;

    public MedianFinder() {

        small = new PriorityQueue<>(Collections.reverseOrder());

        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: add to max heap
        small.offer(num);

        // Step 2: move largest to min heap
        large.offer(small.poll());

        // Step 3: balance sizes
        if (large.size() > small.size()) {

            small.offer(large.poll());
        }
    }

    public double findMedian() {

        // Odd count
        if (small.size() > large.size()) {

            return small.peek();
        }

        // Even count
        return (small.peek() + large.peek()) / 2.0;
    }
}