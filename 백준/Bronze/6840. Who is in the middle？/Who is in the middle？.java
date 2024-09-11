import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] table = new int[3];
        
        table[0] = Integer.parseInt(bufferedReader.readLine());
        table[1] = Integer.parseInt(bufferedReader.readLine());
        table[2] = Integer.parseInt(bufferedReader.readLine());
        
        Arrays.sort(table);
        System.out.println(table[1]);
    }
}