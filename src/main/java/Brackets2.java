import java.io.*;

class Brackets2 {
    static BufferedReader rd;

    static void generateBracketsSequence(String seq, int open, int closed, int count) throws IOException {

        if (seq.length() == count * 2) {
            System.out.println(seq);
            return;
        }

        if (open < count) {
            generateBracketsSequence(seq + "(", open + 1, closed, count);
        }

        if (closed < open) {
            generateBracketsSequence(seq + ")", open, closed + 1, count);
        }
    }

    static void makeBrackets(int input) throws IOException {
        if (input == 0 && input > 11) return;
        generateBracketsSequence("", 0, 0, input);
    }

    public static void main(String[] args) throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(rd.readLine());
        makeBrackets(n);
        rd.close();

    }
}