package duplicates;

import java.io.*;

public class RemoveDuplicates5 {

    static final String input = "input.txt";
    static final String output = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(input));
        BufferedWriter w = new BufferedWriter(new FileWriter(output));
        int count = Integer.parseInt(r.readLine());
        boolean first = true;
        int current = Integer.MIN_VALUE;

        while (count > 0) {
            int n = Integer.parseInt(r.readLine());
            if (n == Integer.MIN_VALUE && first) {
                w.write(n + "\n");
                first = false;
            }
            if (n > current) {
                current = n;
                w.write(current + "\n");
            }
            count--;
        }
        r.close();
        w.close();
    }
}

