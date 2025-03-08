
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tokens;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[5];
        int[] B = new int[5];

        for (int i = 0; i < n; i++) {
            int tmp;

            tokens = br.readLine().split(" ");
            for (int j = 1; j <= Integer.parseInt(tokens[0]); j++) {
                tmp = Integer.parseInt(tokens[j]);
                A[tmp]++;
            }

            tokens = br.readLine().split(" ");
            for (int j = 1; j <= Integer.parseInt(tokens[0]); j++) {
                tmp = Integer.parseInt(tokens[j]);
                B[tmp]++;
            }

            for (int j = 4; j > 0 ; j--) {
                if (A[j] > B[j]){
                    System.out.println("A");
                    break;
                }
                else if (A[j] < B[j]) {
                    System.out.println("B");
                    break;
                }
                if (j==1)
                    System.out.println("D");
            }
            Arrays.fill(A,0);
            Arrays.fill(B,0);
        }
        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}