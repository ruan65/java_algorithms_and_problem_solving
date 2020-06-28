import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MergeListsSort {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(rd.readLine());
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> line = Arrays.stream(rd.readLine()
                    .split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            data.addAll(line.subList(1, line.size()));
        }
        Collections.sort(data);
        for (int e : data) {
            System.out.print(e + " ");
        }
    }
}
