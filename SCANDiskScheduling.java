import java.util.Arrays;
import java.util.Scanner;

public class SCANDiskScheduling {
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
        
        System.out.print("Enter the total number of tracks: ");
        int totalTracks = scanner.nextInt();
        
        int totalSeekTime = scan(requests, head, direction, totalTracks);
        System.out.println("Total seek time: " + totalSeekTime);
    }
    
    public static int scan(int[] requests, int head, int direction, int totalTracks) {
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
            
            // Move to the end
            totalSeekTime += Math.abs(totalTracks - 1 - currentPosition);
            currentPosition = totalTracks - 1;
            
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
            
            // Move to the beginning
            totalSeekTime += Math.abs(0 - currentPosition);
            currentPosition = 0;
            
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

// # File to create
// file="myfile.txt"

// # Add content to the file
// echo "This is the first line of text." > "$file"
// echo "This is the second line of text." >> "$file"

//echo "File '$file' created and contents added."
