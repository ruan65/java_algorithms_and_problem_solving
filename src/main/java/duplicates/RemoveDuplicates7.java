package duplicates;

import java.util.Scanner;

public class RemoveDuplicates7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());

        int[] numbers = new int[count];
        int index = 0;

        int current = Integer.MIN_VALUE;

        while (count > 0) {
            int n = Integer.parseInt(sc.nextLine());
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

