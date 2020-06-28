package leetcode;

import java.util.*;

public class A692TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                int fr1 = map.get(w1);
                int fr2 = map.get(w2);
                if (fr1 == fr2) {
                    return w2.compareTo(w1);
                }
                return fr1 - fr2;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }


        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "a", "sunny", "the", "the", "the", "sunny", "is", "is", "a", "a", "a"};
        List<String> result = new A692TopKFrequentWords().topKFrequent(words, 3);
        System.out.println(result);
    }
}
