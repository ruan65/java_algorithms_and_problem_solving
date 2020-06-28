package duplicates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RemoveDuplicates2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(r.readLine());

        ArrayList numbers = new ArrayList();
        int index = 0;

        int current = Integer.MIN_VALUE;

        while (count > 0) {
            String s = r.readLine();
            int n = Integer.parseInt(s);
            if (n == Integer.MIN_VALUE && index == 0) {
                numbers.add(Integer.MIN_VALUE);
                index++;
            }
            if (n > current) {
                current = n;
                if (n>999) {
                    numbers.add(n);
                } else  {
                    numbers.add(s);
                }
                ++index;
            }
            count--;
        }
        for (int i = 0; i < index; i++) {

            Object n = numbers.get(i);
            if(n instanceof Integer) {
                System.out.println("" + n);
            }
            if (n instanceof String) {
                System.out.println(n);
            }
        }
    }
}

