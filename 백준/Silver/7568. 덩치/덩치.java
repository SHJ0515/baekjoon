import java.io.*;
import java.util.*;

public class Main {

    public static int compare(int[] me, int[] other) {

        if (me[0] < other[0] && me[1] < other[1]){
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] member = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");   //[0] = weight, [1] = height
            member[i][0] = Integer.parseInt(info[0]);
            member[i][1] = Integer.parseInt(info[1]);
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    
                }
                else{
                    rank += compare(member[i], member[j]);
                }
            }

            sb.append(rank + " ");
        }

        sb.append("\n");
        System.out.println(sb);

        br.close();
        bw.close();
    }
}