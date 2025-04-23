// ShortestJobFirst.java
// Shortest Job First (Non-preemptive) Scheduling
import java.util.*;

public class ShortestJobFirst {
    static class Job {
        int id, burst;
        Job(int id, int burst) { this.id = id; this.burst = burst; }
    }
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 6), new Job(2, 8), new Job(3, 7), new Job(4, 3)
        );
        jobs.sort(Comparator.comparingInt(j -> j.burst));
        int time = 0;
        for (Job job : jobs) {
            System.out.println("Job " + job.id + " starts at " + time);
            time += job.burst;
            System.out.println("Job " + job.id + " ends at " + time);
        }
    }
}

// echo "Top 10 processes by memory usage:"
// ps aux --sort=-%mem | head -n 11
