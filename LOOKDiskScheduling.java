import java.util.Arrays;
import java.util.Scanner;

public class LOOKDiskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of disk requests: ");
        int n = scanner.nextInt();
        
        int[] requests = new int[n];
        System.out.println("Enter the disk requests:");
        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the initial head position: ");
        int head = scanner.nextInt();
        
        System.out.print("Enter the direction (0 for left, 1 for right): ");
        int direction = scanner.nextInt();
        
        int totalSeekTime = look(requests, head, direction);
        System.out.println("Total seek time: " + totalSeekTime);
    }
    
    public static int look(int[] requests, int head, int direction) {
        Arrays.sort(requests);
        int totalSeekTime = 0;
        int currentPosition = head;
        
        if (direction == 1) { // Moving right
            // First serve all requests in the right direction
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] >= head) {
                    totalSeekTime += Math.abs(requests[i] - currentPosition);
                    currentPosition = requests[i];
                }
            }
            
            // Then serve requests in the left direction
            for (int i = requests.length - 1; i >= 0; i--) {
                if (requests[i] < head) {
                    totalSeekTime += Math.abs(requests[i] - currentPosition);
                    currentPosition = requests[i];
                }
            }
        } else { // Moving left
            // First serve all requests in the left direction
            for (int i = requests.length - 1; i >= 0; i--) {
                if (requests[i] <= head) {
                    totalSeekTime += Math.abs(requests[i] - currentPosition);
                    currentPosition = requests[i];
                }
            }
            
            // Then serve requests in the right direction
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] > head) {
                    totalSeekTime += Math.abs(requests[i] - currentPosition);
                    currentPosition = requests[i];
                }
            }
        }
        
        return totalSeekTime;
    }
} 