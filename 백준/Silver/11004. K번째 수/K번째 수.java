import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);

        nums = br.readLine().split(" ");

        int[] num = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(num);
        System.out.println(num[k - 1]);

        br.close(); // BufferedReader 닫기
        bw.flush();
        bw.close();
    }
}
