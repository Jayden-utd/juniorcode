/**
 * @Description:
 * @author: Jayden
 * @date:4/15/21 11:42 AM
 */

// key point : tailIndex=(headIndex+count−1) mod capacity

public class Leetcode622 {
    private int[] data;
    private int size;
    //头指针
    private int head;
    private int tail;
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public Leetcode622(int k) {
        this.data = new int[k];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size == data.length) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) return false;
        head = (head + 1) % data.length;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (size == 0) return -1;
        return data[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return data[(tail - 1 + data.length) % data.length];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == data.length;
    }
}
