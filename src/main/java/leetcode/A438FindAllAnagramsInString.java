package leetcode;

import java.util.ArrayList;

public class A438FindAllAnagramsInString {
    public ArrayList<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        int[] charCounts = new int[26];

        for (char c : p.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int tracker = p.length();

        while (right < s.length()) {

            if (charCounts[s.charAt(right++) - 'a']-- >= 1) tracker--;

            if (tracker == 0) result.add(left);

            if (right - left == p.length() && charCounts[s.charAt(left++) - 'a']++ >= 0) tracker++;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = new A438FindAllAnagramsInString().findAnagrams("cbaebabacd", "abc");
        System.out.println("result: " + result);
    }
}
