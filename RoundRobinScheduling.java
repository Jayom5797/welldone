// RoundRobinScheduling.java
// Round Robin CPU Scheduling
import java.util.*;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        int[] processes = {1, 2, 3};
        int n = processes.length;
        int[] burst_time = {10, 5, 8};
        int quantum = 2;
        int[] rem_bt = Arrays.copyOf(burst_time, n);
        int t = 0;
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) {
                    done = false;
                    if (rem_bt[i] > quantum) {
                        t += quantum;
                        rem_bt[i] -= quantum;
                    } else {
                        t += rem_bt[i];
                        System.out.println("Process " + processes[i] + " finished at time " + t);
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done) break;
        }
    }
}

//# Source and destination files
//src_file="source.txt"
//dest_file="destination.txt"

// Copy contents
//cp "$src_file" "$dest_file"

//echo "Contents of '$src_file' copied to '$dest_file'."