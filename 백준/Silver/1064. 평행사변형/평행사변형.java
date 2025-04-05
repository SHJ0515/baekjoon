import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;


public class Main {

    public static Double find(Double[] location) {
        Double[] loc1 = {location[0], location[1]};
        Double[] loc2 = {location[2], location[3]};
        Double[] loc3 = {location[4], location[5]};

        Double vec1x = loc2[0] - loc1[0];
        Double vec1y = loc2[1] - loc1[1];
        Double vec2x = loc3[0] - loc1[0];
        Double vec2y = loc3[1] - loc1[1];

        double line1 = Math.sqrt(Math.pow(loc2[0] - loc1[0], 2) + Math.pow(loc2[1] - loc1[1], 2));
        double line2 = Math.sqrt(Math.pow(loc3[0] - loc1[0], 2) + Math.pow(loc3[1] - loc1[1], 2));
        double line3 = Math.sqrt(Math.pow(loc2[0] - loc3[0], 2) + Math.pow(loc2[1] - loc3[1], 2));

        double max = Math.max(line1, Math.max(line2, line3));
        double min = Math.min(line1, Math.min(line2, line3));

        if (vec1x * vec2y - vec2x * vec1y == 0.0) {
            return -1.0;
        }
        return 2 * (max - min);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        Double[] location = new Double[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            location[i] = Double.parseDouble(tokens[i]);
        }
        System.out.println(find(location));

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}