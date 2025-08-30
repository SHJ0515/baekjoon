
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int GCD = 0;   //최대공약수
        int LCM = 0;  //최소공배수

        String[] s = br.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);

        if (n1 > n2) {
            int tmp = n2;
            n2 = n1;
            n1 = tmp;
        }

        /**
         * 유클리드 호제법
         * n1 * n2 = GCD * LCM 이용
         * 최대공약수 or 최소공배수 하나만 구해서 다른거는 공식 사용
         * -> 커봤자 최대 n1 (단, n1 <= n2)인 최대공약수 먼저 구하기, n1부터 -1 하며 거꾸로
         */

        for (int i = n1; i >= 1; i--) {
            if ((n1 % i == 0) && (n2 % i == 0)) {
                GCD = i;
                break;
            }
        }

        LCM = (n1 * n2) / GCD;

        System.out.println(GCD);
        System.out.println(LCM);

        br.close();
    }
}
