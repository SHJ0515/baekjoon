import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[] tokens;

        tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int t1 = 0;
        int t2 = 0;

        boolean flag = true;

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag)
                t1++;

            flag = true;
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (arr[i][j] == 'X') {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
                t2++;
            
            flag = true;
        }

        
        System.out.println(Math.max(t1, t2));
        
        br.close(); // BufferedReader 닫기
        bw.flush();
        bw.close();
    }
}