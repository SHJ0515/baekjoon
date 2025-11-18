
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();


        int n = sc.nextInt();
        int x = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t < x){
                list.add(t);
            }
        }

        for (Integer i : list) {
            sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }
}