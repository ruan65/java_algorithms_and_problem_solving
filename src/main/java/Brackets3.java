import java.io.*;

class Brackets3 {
    static final String input = "input.txt";
    static final String output = "output.txt";
    static BufferedReader rd;
    static BufferedWriter wr;

    static void generateBracketsSequence(String seq, int open, int closed, int count) throws IOException {

        if (seq.length() == count * 2) {
            wr.write(seq + "\n");
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
        generateBracketsSequence("", 0, 0, input);
    }

    public static void main(String[] args) throws IOException {
        rd = new BufferedReader(new FileReader(input));
        wr = new BufferedWriter(new FileWriter(output));

        int n = Integer.parseInt(rd.readLine());
        makeBrackets(n);
        wr.close();
        rd.close();

    }
}