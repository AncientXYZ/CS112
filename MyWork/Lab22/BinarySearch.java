import java.util.*;
import java.io.*;

public class BinarySearch {
    //binary search method to find a target string in a list of strings
    public static String binarySearch(ArrayList<String> donors, String target) {
        int left = 0;
        int right = donors.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = target.compareTo(donors.get(mid));
            if (res == 0) {
                return "MATCH";
            } else if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return "NOT FOUND";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> donors = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            donors.add(line);
        }
        String target = args[0];
        System.out.println(binarySearch(donors, target));
    }
}