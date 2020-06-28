package duplicates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(r.readLine());

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
        for (int i = 0; i < index; i++) {

            System.out.println(numbers[i]);
        }
    }
}

