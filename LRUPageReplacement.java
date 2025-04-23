// LRUPageReplacement.java
// LRU Page Replacement Algorithm
import java.util.*;

public class LRUPageReplacement {
    public static void main(String[] args) {
        int[] pages = {1, 3, 0, 3, 5, 6};
        int capacity = 3;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> indexes = new HashMap<>();
        int faults = 0;
        for (int i = 0; i < pages.length; i++) {
            int page = pages[i];
            if (!set.contains(page)) {
                if (set.size() == capacity) {
                    int lru = Collections.min(indexes.entrySet(), Map.Entry.comparingByValue()).getKey();
                    set.remove(lru);
                    indexes.remove(lru);
                }
                set.add(page);
                faults++;
            }
            indexes.put(page, i);
            System.out.println("Frames: " + set);
        }
        System.out.println("Total Page Faults: " + faults);
    }
}

// # File to change permissions
// file="example.txt"

// # Change permissions: give read, write, and execute to owner; read to group and others
// chmod 744 "$file"

// echo "Permissions for '$file' changed to 744 (rwxr--r--)."