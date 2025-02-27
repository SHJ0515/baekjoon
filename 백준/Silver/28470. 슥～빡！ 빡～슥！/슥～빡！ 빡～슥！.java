import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long res = 0;

        int[] attack = new int[n];
        int[] dodge = new int[n];
        int[] ap = new int[n];

        for (int i = 0; i < n; i++){
            attack[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++){
            dodge[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++){
            float a = in.nextFloat() * 10;
            ap[i] = (int)a;
        }

        for (int i = 0; i < n;i++){
            if (ap[i] >= 10) res += (attack[i] * ap[i]) / 10 - dodge[i];
            else res += attack[i] - (dodge[i] * ap[i]) / 10;
        }
        System.out.println(res);
    }
}