import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            int count = 0;
            int N = Integer.parseInt(br.readLine());
            
            String[] strings = br.readLine().split(" ");
            int[] buildings = new int[strings.length];

            for (int j = 0; j < strings.length; j++) {
                buildings[j] = Integer.parseInt(strings[j]);
            }

            for (int j = 2; j < buildings.length - 2; j++) {
                int maxLeft = Math.max(buildings[j - 2], buildings[j - 1]);
                int maxRight = Math.max(buildings[j + 1], buildings[j + 2]);

                int max = Math.max(maxLeft, maxRight);

                if (buildings[j] - max > 0) {
                    count = count + (buildings[j] - max);
                }
            }

            System.out.println("#" + i + " " + count);
        }
    }
}