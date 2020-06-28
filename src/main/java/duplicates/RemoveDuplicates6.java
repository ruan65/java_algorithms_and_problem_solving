package duplicates;

import java.io.*;

public class RemoveDuplicates6 {

    static  final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    static int current = Integer.MIN_VALUE;
    static int count;
    static boolean first = true;
    static int n;

    public static void main(String[] args) throws IOException {
        count = Integer.parseInt(r.readLine());
        if(count < 1) return;

        while (count > 0) {
            n = Integer.parseInt(r.readLine());
            if (n == Integer.MIN_VALUE && first) {
                System.out.println(n + "");
                first = false;
            }
            if (n > current) {
                current = n;
                System.out.println(n + "");
            }
            count--;
        }
        r.close();
    }
}

