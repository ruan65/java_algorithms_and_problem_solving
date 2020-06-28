package duplicates;

import java.io.*;

public class RemoveDuplicates8 {

    static final String input = "input.txt";
    static final String output = "output.txt";
    static BufferedReader rd;
    static BufferedWriter wr;

    static final int charsSize = 12;
    static final char[] now = new char[charsSize];
    static final char[] before = new char[charsSize];

    public static void main(String[] args) throws IOException {
        rd = new BufferedReader(new FileReader(input));
        wr = new BufferedWriter(new FileWriter(output));

        int count = Integer.parseInt(rd.readLine());
        if (count < 1) return;

        readInput();
        swapToBefore();
        printIt();

        for (int i = 0; i < count - 1; i++) {
            readInput();
            if (!isEqual()) {
                printIt();
                swapToBefore();
            }

        }
        rd.close();
        wr.close();
    }

    static void readInput() throws IOException {
        int input;
        for (int i = 0; i < charsSize; i++) {
            input = rd.read();
            if (input < 0) {
                now[i] = '\n';
                break;
            }
            now[i] = (char) input;
            if (input == '\n') break;
        }
    }

    static void printIt() throws IOException {
        for (int i = 0;; i++) {
            wr.write(now[i]);
            if (now[i] == '\n') break;
        }
    }

    static void swapToBefore() {
        for (int i = 0; i < charsSize; i++) {
            before[i] = now[i];
            if (now[i] == '\n') break;
        }
    }

    static boolean isEqual() {
        for (int i = 0; i < charsSize; i++) {
            if (now[i] != before[i]) return false;
            if (now[i] == '\n') break;
        }
        return true;
    }
}

