import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String longNumber = bufferedReader.readLine();
        int length = longNumber.length();
        long result = 0;

        /*
        1623 를 입력 받을 시
        처음 : 1 (charAt(0)) 에 대해서 나머지 연산
        두번째 : 위의 식 * 10 + 6(charAt(1)) 에 대해서 나머지 연산
         */
        for (int i = 0; i < length; i++) {
            result = (result * 10 + (longNumber.charAt(i) - '0')) % 20000303;
        }

        System.out.println(result);
    }
}