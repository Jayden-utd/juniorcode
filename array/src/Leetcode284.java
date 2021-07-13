import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Description:
 * @author: Jayden
 * @date:6/30/21 6:23 PM
 */
public class Leetcode284 implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> iter;
    public Leetcode284(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        if (next == null) {
            throw new NoSuchElementException();
        }
        Integer res = next;
        next = null;
        if (iter.hasNext()) {
            next = iter.next();
        }
        return res;
    }
}
