import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            int day = 1;

            String[] pig = br.readLine().split(" ");

            for (int j = 0; j < pig.length; j++) {
                sum += Integer.parseInt(pig[j]);
            }

            while (sum <= n) {
                sum = sum * 4;
                day++;
            }
            System.out.println(day);
        }


        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}
