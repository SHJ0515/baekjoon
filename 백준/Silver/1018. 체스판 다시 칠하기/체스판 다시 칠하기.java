
import java.io.*;
import java.util.*;

public class Main {
    public static final char[][] BLACK_BOARD = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
    };

    public static final char[][] WHITE_BOARD = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");

        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minCount = 64;

        for (int i = 0; i <= N - 8; i++) {

            for (int j = 0; j <= M - 8; j++) {

                int countForWhiteStart = 0;
                int countForBlackStart = 0;

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {

                        if (board[i + k][j + l] != WHITE_BOARD[k][l]) {
                            countForWhiteStart++;
                        }
                        
                        if (board[i + k][j + l] != BLACK_BOARD[k][l]) {
                            countForBlackStart++;
                        }
                    }
                }
                int currentMin = Math.min(countForWhiteStart, countForBlackStart);
                minCount = Math.min(minCount, currentMin);
            }
        }

        System.out.println(minCount);

        br.close();
        bw.close();
    }
}

