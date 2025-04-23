// FIFOPageReplacement.java
// FIFO Page Replacement Algorithm
import java.util.*;

public class FIFOPageReplacement {
    public static void main(String[] args) {
        int[] pages = {1, 3, 0, 3, 5, 6};
        int capacity = 3;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int faults = 0;
        for (int page : pages) {
            if (!set.contains(page)) {
                if (set.size() == capacity) {
                    int removed = queue.poll();
                    set.remove(removed);
                }
                set.add(page);
                queue.add(page);
                faults++;
            }
            System.out.println("Frames: " + queue);
        }
        System.out.println("Total Page Faults: " + faults);
    }
}

//echo "Listing files (default):"
//ls
//echo
// echo "Listing all files including hidden ones (-a):"
// ls -a
// echo
// echo "Listing with detailed information (-l):"
// ls -l
// echo
// echo "Listing all files with detailed info (-la):"
// ls -la
// echo
// echo "Listing files sorted by modification time (-lt):"
// ls -lt
// echo
// echo "Listing files in human-readable format (-lh):"
// ls -lh
// echo
// echo "Listing files recursively (-R):"
// ls -R