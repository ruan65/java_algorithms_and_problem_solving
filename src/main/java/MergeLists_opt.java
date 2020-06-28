import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MergeLists_opt {

    static final String input = "input.txt";
    static final String output = "output.txt";
    static BufferedReader rd;
    static BufferedWriter wr;
    static int size;
    static List<Integer> pointers = new ArrayList<>();
    static HashMap<Integer, List<Integer>> data = new HashMap<>();
    static Deque<Integer> result = new ArrayDeque<>();
    static int steps = 0;

    public static void main(String[] args) throws IOException {
        rd = new BufferedReader(new FileReader(input));
        wr = new BufferedWriter(new FileWriter(output));
        size = Integer.parseInt(rd.readLine());


        for (int i = 0; i < size; i++) {
            List<Integer> line = Arrays.stream(rd.readLine()
                    .split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            pointers.add(line.get(0) - 1);
            List<Integer> numbers = line.subList(1, line.size());
            steps += numbers.size();
            data.put(i, numbers);
        }

        for (int i = 0; i < steps; i++) {
            List<Integer> tails = fillTails();
            int[] iv = findMaxValueAndIndex(tails);
            result.push(iv[1]);
            pointers.set(iv[0], pointers.get(iv[0]) - 1);
        }
        String output = result.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
        wr.write(output);
        rd.close();
        wr.close();
    }

    static List<Integer> fillTails() {
        List<Integer> tls = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = pointers.get(i);
            if (index < 0) {
                tls.add(-1);
            } else {
                tls.add(data.get(i).get(index));
            }
        }
        return tls;
    }

    static int[] findMaxValueAndIndex(List<Integer> arr) {
        int mv = -1;
        int mi = -1;
        int[] res = new int[2];
        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i) > mv) {
                mv = arr.get(i);
                mi = i;
            }
        }
        res[0] = mi;
        res[1] = mv;
        return res;
    }
}
