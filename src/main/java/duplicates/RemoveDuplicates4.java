package duplicates;

import java.io.*;

public class RemoveDuplicates4 {

    static final String input = "input.txt";
    static final String output = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(input));
        BufferedWriter w = new BufferedWriter(new FileWriter(output));
        int count = Integer.parseInt(r.readLine());

        String current = Integer.MIN_VALUE + "";

        while (count > 0) {
            String  n = r.readLine();
            if (!n.equals(current) || n.equals(Integer.MIN_VALUE + "")) {
                current = n;
                w.write(current + "\n");
            }
            count--;
        }
        r.close();
        w.close();
    }
}

