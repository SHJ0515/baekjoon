import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            nums.add(Integer.parseInt(s));
        }

        int count = 0;
        
        nums.sort(Comparator.naturalOrder());
        
        for (Integer num : nums) {
            count += num;
        }

        System.out.println(count / 5);
        System.out.println(nums.get(2));

        br.close();
        bw.close();
    }
}