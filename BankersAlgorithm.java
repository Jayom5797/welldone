// BankersAlgorithm.java
// Banker's Algorithm for Deadlock Avoidance
import java.util.*;

public class BankersAlgorithm {
    private int n, m;
    private int[][] alloc, max, need;
    private int[] avail;
    
    public BankersAlgorithm(int n, int m, int[][] alloc, int[][] max, int[] avail) {
        this.n = n;
        this.m = m;
        this.alloc = alloc;
        this.max = max;
        this.avail = avail;
        this.need = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                need[i][j] = max[i][j] - alloc[i][j];
    }

    public boolean isSafe() {
        boolean[] finish = new boolean[n];
        int[] work = Arrays.copyOf(avail, m);
        List<Integer> safeSeq = new ArrayList<>();
        while (safeSeq.size() < n) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (!finish[i]) {
                    int j;
                    for (j = 0; j < m; j++)
                        if (need[i][j] > work[j])
                            break;
                    if (j == m) {
                        for (int k = 0; k < m; k++)
                            work[k] += alloc[i][k];
                        safeSeq.add(i);
                        finish[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) return false;
        }
        System.out.println("Safe sequence: " + safeSeq);
        return true;
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        int[][] alloc = {
            {0, 1, 0},
            {2, 0, 0},
            {3, 0, 2},
            {2, 1, 1},
            {0, 0, 2}
        };
        int[][] max = {
            {7, 5, 3},
            {3, 2, 2},
            {9, 0, 2},
            {2, 2, 2},
            {4, 3, 3}
        };
        int[] avail = {3, 3, 2};
        BankersAlgorithm ba = new BankersAlgorithm(n, m, alloc, max, avail);
        if (ba.isSafe())
            System.out.println("System is in a safe state");
        else
            System.out.println("System is NOT in a safe state");
    }
}