import java.io.*;
import java.util.*;

public class Merge {
    public static void main(String[] args) {
        // Check if there are exactly three arguments
        if (args.length != 3) {
            System.err.println("ERROR: Three file names are required.");
            return;
        }

        // Initialize ArrayLists for the three lists
        ArrayList<Integer>[] lists = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            lists[i] = new ArrayList<>();
            try {
                Scanner sc = new Scanner(new File(args[i]));
                while (sc.hasNextInt()) {
                    lists[i].add(sc.nextInt());
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.err.println("ERROR: File not found - " + args[i]);
                return;
            }
        }

        // Merge the three lists
        ArrayList<Integer> mergedList = mergeThreeLists(lists[0], lists[1], lists[2]);

        // Output the merged list
        for (int num : mergedList) {
            System.out.println(num);
        }
    }

    private static ArrayList<Integer> mergeThreeLists(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < list1.size() || j < list2.size() || k < list3.size()) {
            int val1 = i < list1.size() ? list1.get(i) : Integer.MAX_VALUE;
            int val2 = j < list2.size() ? list2.get(j) : Integer.MAX_VALUE;
            int val3 = k < list3.size() ? list3.get(k) : Integer.MAX_VALUE;

            if (val1 <= val2 && val1 <= val3) {
                result.add(val1);
                i++;
            } else if (val2 <= val1 && val2 <= val3) {
                result.add(val2);
                j++;
            } else {
                result.add(val3);
                k++;
            }
        }
        return result;
    }
}
