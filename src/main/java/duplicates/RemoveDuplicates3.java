package duplicates;

import java.io.*;

public class RemoveDuplicates3 {

    static final String input = "input.txt";
    static final String output = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(input));
        BufferedWriter w = new BufferedWriter(new FileWriter(output));
        int count = Integer.parseInt(r.readLine());
        if (count < 1) return;

        int[] numbers = new int[count];
        int index = 0;

        int current = Integer.MIN_VALUE;

        while (count > 0) {
            int n = Integer.parseInt(r.readLine());
            if (n == Integer.MIN_VALUE && index == 0) {
                numbers[0] = Integer.MIN_VALUE;
                index++;
            }
            if (n > current) {
                current = n;
                numbers[index] = n;
                ++index;
            }
            count--;
        }
        r.close();
        for (int i = 0; i < index; i++) {
            w.write(numbers[i] + "\n");
        }
        w.close();
    }
}

