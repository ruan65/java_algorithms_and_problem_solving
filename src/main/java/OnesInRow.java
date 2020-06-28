import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnesInRow {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(r.readLine());

        int max = 0;
        int current = 0;

        while (count > 0) {
            String n = r.readLine();
            if (Integer.parseInt(n) == 1) {
                current++;
                if (current > max) {
                    max = current;
                }
            } else {

                current = 0;
            }
            count--;
        }
        System.out.println(max);
    }
}
