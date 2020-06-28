import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StonesAndJewelries {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String J = r.readLine();
        String S = r.readLine();



        System.out.println(calculateJewelry(J, S));


    }

    public static  int calculateJewelry(String jews, String stones) {

        int result = 0;

        for (Character s : stones.toCharArray()) {
            if (jews.contains(s.toString())) {
                result++;
            };
        }

        return  result;
    }
}
