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
        int a,b,c;

        a = Integer.parseInt(bufferedReader.readLine());
        b = Integer.parseInt(bufferedReader.readLine());
        c = Integer.parseInt(bufferedReader.readLine());

        int [] table = {a,b,c};
        Arrays.sort(table);

        System.out.println(table[1]);

    }
}